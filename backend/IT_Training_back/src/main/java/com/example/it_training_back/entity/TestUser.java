package com.example.it_training_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "test_user")
public class TestUser {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, name = "expected_result")
    private int expectedResult;

    @OneToMany(mappedBy = "testUser", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Training> trainings;

    @OneToMany(mappedBy = "testUser", cascade = CascadeType.ALL)
    private List<Question> questions;
}
