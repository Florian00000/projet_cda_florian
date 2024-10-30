package com.example.it_training_back.dto.training;

import com.example.it_training_back.entity.SubTheme;
import com.example.it_training_back.entity.Training;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class TrainingDtoGet {

    private int id;
    private String title;
    private String description;
    private double price;
    private boolean inter;
    private String imagePath;

    private List<SubTheme> subThemes;

    public TrainingDtoGet(Training training) {
        this.id = training.getId();
        this.title = training.getTitle();
        this.description = training.getDescription();
        this.price = training.getPrice();
        this.inter = training.isInter();
        this.imagePath = training.getImagePath();
        this.subThemes = training.getSubThemes();
    }


}
