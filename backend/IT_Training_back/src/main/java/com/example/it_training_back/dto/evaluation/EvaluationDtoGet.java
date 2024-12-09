package com.example.it_training_back.dto.evaluation;

import com.example.it_training_back.entity.Evaluation;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EvaluationDtoGet {

    private String id;

    private int qualityReception;
    private int qualityEnvironment;
    private int pedagogy;
    private int domainExpertise;
    private int qualityResponses;
    private int technicalAnimations;

    private boolean recommended;
    private String trainingProjects;
    private LocalDateTime valuationDate;

    private long idUser;
    private long idSession;

    private boolean readByAdmin;

    public EvaluationDtoGet(Evaluation evaluation) {
        this.id = evaluation.getId();
        this.qualityReception = evaluation.getQualityReception();
        this.qualityEnvironment = evaluation.getQualityEnvironment();
        this.pedagogy = evaluation.getPedagogy();
        this.domainExpertise = evaluation.getDomainExpertise();
        this.qualityResponses = evaluation.getQualityResponses();
        this.technicalAnimations = evaluation.getTechnicalAnimations();
        this.recommended = evaluation.isRecommended();
        if (evaluation.getTrainingProjects() != null) {
            this.trainingProjects = evaluation.getTrainingProjects();
        }
        this.valuationDate = evaluation.getValuationDate();
        this.idUser = evaluation.getIdUser();
        this.idSession = evaluation.getIdSession();
        this.readByAdmin = evaluation.isReadByAdmin();
    }
}
