package com.example.it_training_back.repository;

import com.example.it_training_back.entity.Evaluation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EvaluationRepository extends MongoRepository<Evaluation, String> {

    Optional<Evaluation> findByIdUserAndIdSession(long idUser, long idSession);
}
