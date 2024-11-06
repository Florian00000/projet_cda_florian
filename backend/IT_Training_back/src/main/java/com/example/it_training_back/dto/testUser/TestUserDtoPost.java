package com.example.it_training_back.dto.testUser;

import com.example.it_training_back.dto.testUser.question.QuestionDtoPost;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Builder
public class TestUserDtoPost {

    private int expectedResult;

    private List<QuestionDtoPost> questions;
}
