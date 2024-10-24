package com.example.it_training_back.controller;

import com.example.it_training_back.dto.subTheme.SubThemeDtoGet;
import com.example.it_training_back.dto.theme.ThemeDtoGet;
import com.example.it_training_back.service.ThemeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ThemeVisitorController {

    private final ThemeService themeService;

    public ThemeVisitorController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping("themes")
    public ResponseEntity<List<ThemeDtoGet>> getThemes() {
        return ResponseEntity.ok(themeService.getAllThemes());
    }

    @GetMapping("/subThemes")
    public ResponseEntity<List<SubThemeDtoGet>> getAllSubThemes() {
        return ResponseEntity.ok(themeService.getAllSubThemes());
    }
}
