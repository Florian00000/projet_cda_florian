package com.example.it_training_back.service;

import com.example.it_training_back.dto.BaseResponseDto;
import com.example.it_training_back.dto.testUser.note.NoteDtoGet;
import com.example.it_training_back.dto.testUser.note.NoteDtoPost;
import com.example.it_training_back.entity.Session;
import com.example.it_training_back.entity.course.Course;
import com.example.it_training_back.entity.course.Presence;
import com.example.it_training_back.entity.testUser.Note;
import com.example.it_training_back.entity.testUser.TestUser;
import com.example.it_training_back.entity.user.User;
import com.example.it_training_back.exception.NotFoundException;
import com.example.it_training_back.repository.SessionRepository;
import com.example.it_training_back.repository.course.CourseRepository;
import com.example.it_training_back.repository.course.PresenceRepository;
import com.example.it_training_back.repository.testUser.NoteRepository;
import com.example.it_training_back.repository.testUser.TestUserRepository;
import com.example.it_training_back.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserToTrainingService {

    private final UserRepository userRepository;
    private final NoteRepository noteRepository;
    private final TestUserRepository testUserRepository;
    private final PresenceRepository presenceRepository;
    private final CourseRepository courseRepository;
    private final SessionRepository sessionRepository;

    public UserToTrainingService(UserRepository userRepository, NoteRepository noteRepository,
                                 TestUserRepository testUserRepository, PresenceRepository presenceRepository,
                                 CourseRepository courseRepository, SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.noteRepository = noteRepository;
        this.testUserRepository = testUserRepository;
        this.presenceRepository = presenceRepository;
        this.courseRepository = courseRepository;
        this.sessionRepository = sessionRepository;
    }

    public NoteDtoGet addNote(NoteDtoPost noteDtoPost) {
        User user = userRepository.findById(noteDtoPost.getUserId())
                .orElseThrow(() -> new NotFoundException("id_user not found"));
        TestUser testUser = testUserRepository.findById(noteDtoPost.getTestUserId())
                .orElseThrow(() -> new NotFoundException("id_test_user not found"));

        Optional<Note> noteInBdd = noteRepository.findByUserAndTestUser(user, testUser);
        if (noteInBdd.isPresent()) {
            throw new IllegalArgumentException("the user already has a note");
        }


        Note note = Note.builder()
                .result(noteDtoPost.getResult())
                .success(noteDtoPost.isSuccess())
                .user(user)
                .testUser(testUser)
                .build();
        note = noteRepository.save(note);
        return new NoteDtoGet(note);
    }

    public BaseResponseDto userHasNote(long userId, long testUserId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("id_user not found"));
        TestUser testUser = testUserRepository.findById(testUserId)
                .orElseThrow(() -> new NotFoundException("id_test_user not found"));
        Optional<Note> note = noteRepository.findByUserAndTestUser(user, testUser);
        Map<String, Object> data = new HashMap<>();
       if (note.isPresent()) {
           data.put("completed", true);
           data.put("success", note.get().isSuccess());
           data.put("note", note.get().getResult());
           return new BaseResponseDto("This user has already done this test",data);
       }else{
           data.put("completed", false);
           return new BaseResponseDto("This user has not yet passed the test",data);
       }
    }

    @Transactional
    public boolean addUserToSession(long userId, long sessionId) {
        //Verification liés au test utilisateur
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("id_user not found"));
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new NotFoundException("id_session not found"));

        if (session.getTraining().getTestUser() != null){
            TestUser testUser =  session.getTraining().getTestUser();
            Optional<Note> note = noteRepository.findByUserAndTestUser(user, testUser);
            if (note.isPresent()) {
                if (!note.get().isSuccess())throw new IllegalArgumentException("the user did not pass the test");
            }else{
                throw new IllegalArgumentException("The user has not done the test");
            }
        }

        //Vérifications liées à l'inscription
        Optional<User> userOptional = session.getUsers().stream().filter(u -> u.getId() == userId).findFirst();
        if (userOptional.isPresent()) throw new IllegalArgumentException("This user is already registered for this session");

        if (session.getPlaceLimit() <= session.getUsers().size()){
            throw new IllegalArgumentException("there are no more places available for this session");
        }

        try {
            List<Course> courses = courseRepository.findAllBySession(session);
            for (Course course : courses) {
                Presence presence = Presence.builder().course(course).user(user).build();
                presenceRepository.save(presence);
            }
        }catch (Exception e){
            throw new DataIntegrityViolationException("Problems with registration", e);
        }

        session.getUsers().add(user);
        sessionRepository.save(session);
        return true;
    }

    public boolean userHasRegisteredToSession(long userId, long sessionId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("id_user not found"));
        Optional<Session> session = sessionRepository.findByIdAndUsers(sessionId, List.of(user));
        if (session.isPresent()) {
            return true;
        }else return false;
    }

}
