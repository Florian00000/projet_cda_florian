package com.example.it_training_back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Proposition {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proposition")
    private long id;

    private String proposition;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_question")
    private Question question;
}
