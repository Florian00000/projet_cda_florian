package com.example.it_training_back.dto.evaluation;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EvaluationDtoPost {

    private int qualityReception;
    private int qualityEnvironment;
    private int pedagogy;
    private int domainExpertise;
    private int qualityResponses;
    private int technicalAnimations;

    private boolean recommended;
    private String trainingProjects;

    private long idUser;
    private long idSession;
}
