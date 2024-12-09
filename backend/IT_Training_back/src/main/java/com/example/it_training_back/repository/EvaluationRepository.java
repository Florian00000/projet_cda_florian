package com.example.it_training_back.repository;

import com.example.it_training_back.entity.Evaluation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EvaluationRepository extends MongoRepository<Evaluation, String> {
}
