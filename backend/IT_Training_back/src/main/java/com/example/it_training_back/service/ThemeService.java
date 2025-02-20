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
public class ThemeService {

    private final ThemeRepository themeRepository;
    private final SubThemeRepository subThemeRepository;

    public ThemeService(ThemeRepository themeRepository, SubThemeRepository subThemeRepository) {
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

    public List<SubThemeDtoGet> getAllSubThemes() {
        List<SubTheme> subThemes = (List<SubTheme>) subThemeRepository.findAll();
        return subThemes.stream().map(SubThemeDtoGet::new).toList();
    }

    public List<SubThemeDtoGet> getAllSubThemesByThemeId(int id) {
        Theme themeInData = themeRepository.findById(id).orElseThrow(() -> new NotFoundException("Theme with id " + id + " not found"));
        List<SubTheme> subThemes = subThemeRepository.findAllByThemes(List.of(themeInData));
        return subThemes.stream().map(SubThemeDtoGet::new).toList();
    }

    public SubThemeDtoGet addSubTheme(SubThemeDtoPost subThemeDtoPost) {
        Optional<SubTheme> subThemeInData = subThemeRepository.findByTitleIgnoreCase(subThemeDtoPost.getTitle());

        if (subThemeInData.isPresent()) throw new DataIntegrityViolationException("A SubTheme already has this title");

        SubTheme subTheme = SubTheme.builder()
                .title(subThemeDtoPost.getTitle())
                .imagePath(subThemeDtoPost.getImagePath())
                .build();

        if (subThemeDtoPost.getThemes() != null && !subThemeDtoPost.getThemes().isEmpty()){
            List<Theme> themeList = updateThemesOfSubTheme(subThemeDtoPost.getThemes());
            subTheme.setThemes(themeList);
        }

        subThemeRepository.save(subTheme);
        return new SubThemeDtoGet(subTheme);
    }

    public void deleteSubTheme(int id) {
        SubTheme subTheme = subThemeRepository.findById(id).orElseThrow(() -> new NotFoundException("SubTheme with id " + id + " not found"));
        subThemeRepository.delete(subTheme);
    }

    public SubThemeDtoGet updateSubTheme(int id, SubThemeDtoPost subThemeDtoPost) {
        SubTheme subTheme = subThemeRepository.findById(id).orElseThrow(() -> new NotFoundException("SubTheme with id " + id + " not found"));

        Optional<SubTheme> subThemeInData = subThemeRepository.findByTitleIgnoreCase(subThemeDtoPost.getTitle());
        if (subThemeInData.isPresent()) throw new DataIntegrityViolationException("A subTheme already has this title");

        if (subThemeDtoPost.getThemes() == null || subThemeDtoPost.getThemes().isEmpty()){
            subTheme.setThemes(null);
        }else {
            List<Theme> themeList = updateThemesOfSubTheme(subThemeDtoPost.getThemes());
            subTheme.setThemes(themeList);
        }

        subTheme.setTitle(subThemeDtoPost.getTitle());
        subTheme.setImagePath(subThemeDtoPost.getImagePath());
        subThemeRepository.save(subTheme);
        return new SubThemeDtoGet(subTheme);
    }

    private List<Theme> updateThemesOfSubTheme(List<Integer> themesId) {
        List<Theme> themeList = new ArrayList<>();
        for (Integer idTheme : themesId) {
            Theme theme = themeRepository.findById(idTheme).orElseThrow(() -> new NotFoundException("Theme with id " + idTheme + " not found"));
            themeList.add(theme);
        }
        return themeList;
    }

}
