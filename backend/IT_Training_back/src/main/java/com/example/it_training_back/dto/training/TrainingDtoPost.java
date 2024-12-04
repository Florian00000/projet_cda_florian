package com.example.it_training_back.dto.training;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Builder
public class TrainingDtoPost {

    private String title;
    private String description;
    private double price;
    private boolean inter;
    private String imagePath;

    private List<Integer> subThemes;
}
