package com.example.it_training_back.repository;

import com.example.it_training_back.entity.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {
    List<Session> findAllByTrainingId(int trainingId);
}
