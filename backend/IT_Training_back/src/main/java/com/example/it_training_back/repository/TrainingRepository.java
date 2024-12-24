package com.example.it_training_back.repository;

import com.example.it_training_back.entity.SubTheme;
import com.example.it_training_back.entity.Training;
import com.example.it_training_back.entity.testUser.TestUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Integer> {
    List<Training> findAllBySubThemes(List<SubTheme> subThemes);

    @Query("SELECT t FROM Training t WHERE t.testUser = :testUser")
    List<Training> findAllByTestUser(@Param("testUser") TestUser testUser);
}
