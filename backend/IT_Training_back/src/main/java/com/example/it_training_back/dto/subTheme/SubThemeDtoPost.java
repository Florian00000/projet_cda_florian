package com.example.it_training_back.dto.subTheme;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class SubThemeDtoPost {

    private String title;
    private String imagePath;

    private List<Integer> themes;
}
