package com.example.it_training_back.service;

import com.example.it_training_back.dto.subTheme.SubThemeDtoGet;
import com.example.it_training_back.dto.subTheme.SubThemeDtoPost;
import com.example.it_training_back.dto.theme.ThemeDtoGet;
import com.example.it_training_back.dto.theme.ThemeDtoPost;
import com.example.it_training_back.entity.SubTheme;
import com.example.it_training_back.entity.Theme;
import com.example.it_training_back.exception.NotFoundException;
import com.example.it_training_back.repository.SubThemeRepository;
import com.example.it_training_back.repository.ThemeRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {

    private final ThemeRepository themeRepository;
    private final SubThemeRepository subThemeRepository;

    public TrainingService(ThemeRepository themeRepository, SubThemeRepository subThemeRepository) {
        this.themeRepository = themeRepository;
        this.subThemeRepository = subThemeRepository;
    }

    //============================= Themes =============================
    public List<ThemeDtoGet> getAllThemes() {
        List<Theme> themes = (List<Theme>) themeRepository.findAll();
        return themes.stream().map(ThemeDtoGet::new).toList();
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

    public void deleteTheme(int id) {
        Theme theme = themeRepository.findById(id).orElseThrow(() -> new NotFoundException("Theme with id " + id + " not found"));
        themeRepository.delete(theme);
    }

    public ThemeDtoGet updateTheme(int id, ThemeDtoPost themeDtoPost) {
        Theme theme = themeRepository.findById(id).orElseThrow(() -> new NotFoundException("Theme with id " + id + " not found"));

        Optional<Theme> themeInData = themeRepository.findByTitleIgnoreCase(themeDtoPost.getTitle());
        if (themeInData.isPresent()) throw new DataIntegrityViolationException("A theme already has this title");

        theme.setTitle(themeDtoPost.getTitle());
        theme.setImagePath(themeDtoPost.getImagePath());
        themeRepository.save(theme);
        return new ThemeDtoGet(theme);
    }

    //============================= SubThemes =============================

    public SubThemeDtoGet addSubTheme(SubThemeDtoPost subThemeDtoPost) {
        Optional<SubTheme> subThemeInData = subThemeRepository.findByTitleIgnoreCase(subThemeDtoPost.getTitle());

        if (subThemeInData.isPresent()) throw new DataIntegrityViolationException("A SubTheme already has this title");

        List<Theme> themeList = new ArrayList<>();
        for (Integer id : subThemeDtoPost.getThemes()) {
            Theme theme = themeRepository.findById(id).orElseThrow(() -> new NotFoundException("Theme with id " + id + " not found"));
            themeList.add(theme);
        }


        SubTheme subTheme = SubTheme.builder()
                .title(subThemeDtoPost.getTitle())
                .imagePath(subThemeDtoPost.getImagePath())
                .themes(themeList)
                .build();
        subThemeRepository.save(subTheme);
        return new SubThemeDtoGet(subTheme);
    }
}
