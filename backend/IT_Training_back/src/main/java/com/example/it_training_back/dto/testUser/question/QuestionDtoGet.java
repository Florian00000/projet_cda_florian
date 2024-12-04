package com.example.it_training_back.dto.testUser.question;

import com.example.it_training_back.dto.testUser.proposition.PropositionDtoGet;
import com.example.it_training_back.entity.Question;
import lombok.Data;

import java.util.List;

@Data
public class QuestionDtoGet {

    private long id;
    private String label;
    private String answer;

    private List<PropositionDtoGet> propositions;

    public QuestionDtoGet( Question question ) {
        this.id = question.getId();
        this.label = question.getLabel();
        this.answer = question.getAnswer();
        this.propositions = question.getPropositions().stream().map(PropositionDtoGet::new).toList();
    }
}
