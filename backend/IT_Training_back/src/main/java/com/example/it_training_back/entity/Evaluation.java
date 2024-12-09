package com.example.it_training_back.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Evaluation")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evaluation {

    private int qualityReception;

}
