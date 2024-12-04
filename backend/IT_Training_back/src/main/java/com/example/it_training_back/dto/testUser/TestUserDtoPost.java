package com.example.it_training_back.dto.testUser;

import com.example.it_training_back.dto.testUser.question.QuestionDtoPost;
import lombok.*;

import java.util.List;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestUserDtoPost {

    private int expectedResult;

    private List<QuestionDtoPost> questions;
}
