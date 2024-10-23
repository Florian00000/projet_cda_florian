package com.example.it_training_back.service;

import com.example.it_training_back.dto.theme.ThemeDtoGet;
import com.example.it_training_back.dto.theme.ThemeDtoPost;
import com.example.it_training_back.entity.Theme;
import com.example.it_training_back.repository.SubThemeRepository;
import com.example.it_training_back.repository.ThemeRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainingService {

    private final ThemeRepository themeRepository;
    private final SubThemeRepository subThemeRepository;

    public TrainingService(ThemeRepository themeRepository, SubThemeRepository subThemeRepository) {
        this.themeRepository = themeRepository;
        this.subThemeRepository = subThemeRepository;
    }

    public ThemeDtoGet addTheme(ThemeDtoPost themeDtoPost) {

        Optional<Theme> themeInData = themeRepository.findByTitleIgnoreCase(themeDtoPost.getTitle());

        if (themeInData.isPresent()) throw new DataIntegrityViolationException("A theme already has this title");

        Theme theme = Theme.builder()
                .title(themeDtoPost.getTitle())
                .imagePath(themeDtoPost.getImagePath()).build();
        themeRepository.save(theme);
        return new ThemeDtoGet(theme);
    }
}
