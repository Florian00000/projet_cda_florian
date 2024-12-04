package com.example.it_training_back.dto.testUser.question;

import com.example.it_training_back.dto.testUser.proposition.PropositionDtoPost;
import lombok.*;

import java.util.List;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDtoPost {

    private String label;
    private String answer;

    private List<PropositionDtoPost> propositions;
}
