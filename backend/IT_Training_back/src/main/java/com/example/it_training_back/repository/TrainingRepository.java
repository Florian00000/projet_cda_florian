package com.example.it_training_back.repository;

import com.example.it_training_back.entity.SubTheme;
import com.example.it_training_back.entity.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Integer> {
    List<Training> findAllBySubThemes(List<SubTheme> subThemes);
}
