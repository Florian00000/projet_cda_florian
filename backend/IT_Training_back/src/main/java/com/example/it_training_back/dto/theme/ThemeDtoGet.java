package com.example.it_training_back.dto.theme;

import com.example.it_training_back.entity.SubTheme;
import com.example.it_training_back.entity.Theme;
import lombok.Data;

import java.util.List;

@Data
public class ThemeDtoGet {

    private int id;
    private String title;
    private String imagePath;
    //private List<SubTheme> subThemes;

    public ThemeDtoGet() {
    }

    public ThemeDtoGet(Theme theme) {
        this.id = theme.getId();
        this.title = theme.getTitle();
        this.imagePath = theme.getImagePath();
       // this.subThemes = theme.getSubThemes();
    }
}
