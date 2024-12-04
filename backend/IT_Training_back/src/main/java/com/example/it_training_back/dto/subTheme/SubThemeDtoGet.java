package com.example.it_training_back.dto.subTheme;

import com.example.it_training_back.entity.SubTheme;
import com.example.it_training_back.entity.Theme;
import lombok.Data;

import java.util.List;

@Data
public class SubThemeDtoGet {

    private int id;
    private String title;
    private String imagePath;
    private List<Theme> themes;

    public SubThemeDtoGet() {
    }

    public SubThemeDtoGet(SubTheme subTheme) {
        this.id = subTheme.getId();
        this.title = subTheme.getTitle();
        this.imagePath = subTheme.getImagePath();
        this.themes = subTheme.getThemes();
    }
}
