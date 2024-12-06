package com.example.it_training_back.dto.testUser;

import com.example.it_training_back.dto.testUser.question.QuestionDtoGet;
import com.example.it_training_back.entity.testUser.TestUser;
import com.example.it_training_back.entity.Training;
import lombok.Data;

import java.util.List;

@Data
public class TestUserDtoGet {

    private long id;
    private int expectedResult;

    private List<Training> trainings;
    private List<QuestionDtoGet> questions;

    public TestUserDtoGet(TestUser testUser) {
        this.id = testUser.getId();
        this.expectedResult = testUser.getExpectedResult();
        this.trainings = testUser.getTrainings();
        this.questions = testUser.getQuestions().stream().map(QuestionDtoGet::new).toList();
    }
}
