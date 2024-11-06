package com.example.it_training_back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    private long id;

    @Column(nullable = false)
    private String label;
    @Column(nullable = false)
    private String answer;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_test_user")
    private TestUser testUser;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Proposition> propositions;
}
