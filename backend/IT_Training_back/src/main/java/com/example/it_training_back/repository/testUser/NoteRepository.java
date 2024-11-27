package com.example.it_training_back.repository.testUser;

import com.example.it_training_back.entity.testUser.Note;
import com.example.it_training_back.entity.testUser.TestUser;
import com.example.it_training_back.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
    List<Note> findAllByUser(User user);
    Optional<Note> findNoteByUserAndTestUser(User user, TestUser testUser);
}
