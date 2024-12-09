package com.example.it_training_back.entity;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("Evaluation")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evaluation {

    @Id
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
}
