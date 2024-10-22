package com.example.it_training_back.service;

import com.example.it_training_back.dto.theme.ThemeDtoGet;
import com.example.it_training_back.dto.theme.ThemeDtoPost;
import com.example.it_training_back.repository.SubThemeRepository;
import com.example.it_training_back.repository.ThemeRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {

    private final ThemeRepository themeRepository;
    private final SubThemeRepository themeSubRepository;

    public TrainingService(ThemeRepository themeRepository, SubThemeRepository themeSubRepository) {
        this.themeRepository = themeRepository;
        this.themeSubRepository = themeSubRepository;
    }

    //TODO faire la méthode
    public ThemeDtoGet addTheme(ThemeDtoPost themeDtoPost) {
        return null;
    }
}
