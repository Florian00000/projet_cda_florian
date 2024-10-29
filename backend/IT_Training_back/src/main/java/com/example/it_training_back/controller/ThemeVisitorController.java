package com.example.it_training_back.controller;

import com.example.it_training_back.dto.subTheme.SubThemeDtoGet;
import com.example.it_training_back.dto.theme.ThemeDtoGet;
import com.example.it_training_back.service.ThemeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
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

    @GetMapping("/subThemes/findByTheme/{themeId}")
    public ResponseEntity<List<SubThemeDtoGet>> getSubThemesByThemeId(@PathVariable int themeId) {
        return ResponseEntity.ok(themeService.getAllSubThemesByThemeId(themeId));
    }
}
