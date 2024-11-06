package com.example.it_training_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(nullable = false)
    private String option;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_question")
    @JsonIgnore
    private Question question;
}
