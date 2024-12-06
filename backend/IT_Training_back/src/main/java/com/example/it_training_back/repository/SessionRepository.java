package com.example.it_training_back.repository;

import com.example.it_training_back.entity.Session;
import com.example.it_training_back.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {
    List<Session> findAllByTrainingId(int trainingId);
    Optional<Session> findByIdAndUsers(long id, List<User> users);
}
