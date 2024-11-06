package com.example.it_training_back.dto.testUser.question;

import com.example.it_training_back.dto.testUser.proposition.PropositionDtoPost;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Builder
public class QuestionDtoPost {

    private String label;
    private String answer;

    private List<PropositionDtoPost> propositions;
}
