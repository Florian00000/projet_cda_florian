package com.example.it_training_back.service;

import com.example.it_training_back.dto.course.CourseDtoPostSession;
import com.example.it_training_back.dto.location.LocationDtoGet;
import com.example.it_training_back.dto.location.LocationDtoPost;
import com.example.it_training_back.dto.session.SessionDtoGet;
import com.example.it_training_back.dto.session.SessionDtoPost;
import com.example.it_training_back.dto.training.TrainingDtoGet;
import com.example.it_training_back.dto.training.TrainingDtoPost;
import com.example.it_training_back.entity.Location;
import com.example.it_training_back.entity.Session;
import com.example.it_training_back.entity.SubTheme;
import com.example.it_training_back.entity.Training;
import com.example.it_training_back.entity.course.Course;
import com.example.it_training_back.exception.NotFoundException;
import com.example.it_training_back.repository.LocationRepository;
import com.example.it_training_back.repository.SessionRepository;
import com.example.it_training_back.repository.SubThemeRepository;
import com.example.it_training_back.repository.TrainingRepository;
import com.example.it_training_back.repository.course.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.it_training_back.utils.StaticMethods.saveImage;

@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;
    private final LocationRepository locationRepository;
    private final SessionRepository sessionRepository;
    private final SubThemeRepository subThemeRepository;
    private final CourseRepository courseRepository;

    public TrainingService(TrainingRepository trainingRepository, LocationRepository locationRepository,
                           SessionRepository sessionRepository, SubThemeRepository subThemeRepository,
                           CourseRepository courseRepository) {
        this.trainingRepository = trainingRepository;
        this.locationRepository = locationRepository;
        this.sessionRepository = sessionRepository;
        this.subThemeRepository = subThemeRepository;
        this.courseRepository = courseRepository;
    }

    //============================= Training =============================

    public TrainingDtoGet addTraining(TrainingDtoPost trainingDtoPost) {
        Training training = Training.builder().title(trainingDtoPost.getTitle())
                .description(trainingDtoPost.getDescription())
                .price(trainingDtoPost.getPrice())
                .inter(trainingDtoPost.isInter())
                .build();
        if (trainingDtoPost.getImagePath() != null) {
            try {
                String imagePath = saveImage(trainingDtoPost.getImagePath());
                training.setImagePath(imagePath);
            }catch (IOException e){
                throw new IllegalArgumentException("Image path could not be saved");
            }

        }

        if (trainingDtoPost.getSubThemes() != null && !trainingDtoPost.getSubThemes().isEmpty()) {
            List<SubTheme> subThemeList = updateSubThemesOfTraining(trainingDtoPost.getSubThemes());
            training.setSubThemes(subThemeList);
        }
        trainingRepository.save(training);
        return new TrainingDtoGet(training);
    }

    public List<TrainingDtoGet> getAllTrainingsBySubThemeId(int subThemeId){
        SubTheme subThemeInData = subThemeRepository.findById(subThemeId).orElseThrow(() -> new NotFoundException("SubTheme with id " + subThemeId + " not found"));
        List<Training> trainings = trainingRepository.findAllBySubThemes(List.of(subThemeInData));
        return trainings.stream().map(TrainingDtoGet::new).toList();
    }

    public TrainingDtoGet getTraining(int trainingId) {
        Training training = trainingRepository.findById(trainingId).orElseThrow(() -> new NotFoundException("Training with id " + trainingId + " not found"));
        return new TrainingDtoGet(training);
    }

    public List<TrainingDtoGet> getAllTrainings() {
        List<Training> trainings = (List<Training>) trainingRepository.findAll();
        return trainings.stream().map(TrainingDtoGet::new).toList();
    }

    private List<SubTheme> updateSubThemesOfTraining(List<Integer> subThemesId){
        List<SubTheme> subThemeList = new ArrayList<>();
        for (Integer idSubTheme: subThemesId){
            SubTheme subTheme = subThemeRepository.findById(idSubTheme).orElseThrow(() -> new NotFoundException("SubTheme with id " + idSubTheme + " not found"));
            subThemeList.add(subTheme);
        }
        return subThemeList;
    }

    //============================= Session =============================

    @Transactional
    public SessionDtoGet addSession(SessionDtoPost sessionDtoPost) {
        Session session = Session.builder()
                .startDate(LocalDate.parse(sessionDtoPost.getStartDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .endDate(LocalDate.parse(sessionDtoPost.getEndDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .placeLimit(sessionDtoPost.getPlaceLimit())
                .roomReserved(sessionDtoPost.isRoomReserved())
                .machinesInstalled(sessionDtoPost.isMachinesInstalled())
                .trainerConfirmation(sessionDtoPost.isTrainerConfirmation())
                .traineesConfirmation(sessionDtoPost.isTraineesConfirmation())
                .evaluationForms(sessionDtoPost.isEvaluationForms())

                .build();

        Training training = trainingRepository.findById(sessionDtoPost.getTrainingID()).orElseThrow(
                () -> new NotFoundException("Training with id " + sessionDtoPost.getTrainingID() + " not found"));
        session.setTraining(training);

        if (session.getEndDate().isBefore(session.getStartDate())) throw new IllegalArgumentException("end date cannot be before start date");
        if (session.getPlaceLimit() < 3) throw new IllegalArgumentException("place limit cannot be less than 3");

        if (sessionDtoPost.getLocationID() > 0){
            Location location = locationRepository.findById(sessionDtoPost.getLocationID())
                    .orElseThrow(() -> new NotFoundException("Location with id " + sessionDtoPost.getLocationID() + " not found"));
            session.setLocation(location);
        }

        sessionRepository.save(session);

        verifyDaysOfSession(sessionDtoPost.getTimetables());
        try {
            for (CourseDtoPostSession timetable : sessionDtoPost.getTimetables()){

                if (timetable.getEndTime().isBefore(timetable.getStartTime())){
                    throw new IllegalArgumentException("End date cannot be before start date");
                }

                LocalDate currentDate = session.getStartDate();
                while (!currentDate.getDayOfWeek().equals(DayOfWeek.valueOf(timetable.getDayOfWeek()))){
                    currentDate = currentDate.plusDays(1);
                }

                while (!currentDate.isAfter(session.getEndDate())){
                    Course course = Course.builder()
                            .date(currentDate)
                            .startHour(timetable.getStartTime())
                            .endHour(timetable.getEndTime())
                            .session(session)
                            .build();
                    courseRepository.save(course);
                    currentDate = currentDate.plusWeeks(1);
                }

            }
        }catch (Exception e){
            throw new IllegalArgumentException("Error while adding courses of session", e);
        }

        return new SessionDtoGet(session);
    }

    public List<SessionDtoGet> getSessionsByTrainingID(int trainingID) {
        trainingRepository.findById(trainingID).orElseThrow(() -> new NotFoundException("Training with id " + trainingID + " not found"));
        List<Session> sessions = sessionRepository.findAllByTrainingId(trainingID);
        return sessions.stream().map(SessionDtoGet::new).toList();
    }

    private void verifyDaysOfSession(List<CourseDtoPostSession> daysOfSession){
        List<String> listOfDays = daysOfSession.stream()
                .map(CourseDtoPostSession::getDayOfWeek).toList();
        Set<String> setOfDays = new HashSet<>(listOfDays);

        if (listOfDays.size() != setOfDays.size()) {
            throw new IllegalArgumentException("The same day of the week is present twice for the session");
        }
    }


    //============================= Location =============================

    public LocationDtoGet addLocation(LocationDtoPost locationDtoPost) {
        Location location = Location.builder()
                .street(locationDtoPost.getStreet())
                .number(locationDtoPost.getNumber())
                .city(locationDtoPost.getCity())
                .zipCode(locationDtoPost.getZipCode())
                .build();
        locationRepository.save(location);
        return new LocationDtoGet(location);
    }

    public List<LocationDtoGet> getAllLocations() {
        List<Location> locations = (List<Location>) locationRepository.findAll();
        return locations.stream().map(LocationDtoGet::new).toList();
    }

}
