package com.example.it_training_back.repository;

import com.example.it_training_back.entity.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Integer> {
}
