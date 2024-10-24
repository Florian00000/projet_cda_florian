package com.example.it_training_back.controller;

import com.example.it_training_back.dto.subTheme.SubThemeDtoGet;
import com.example.it_training_back.dto.subTheme.SubThemeDtoPost;
import com.example.it_training_back.dto.theme.ThemeDtoGet;
import com.example.it_training_back.dto.theme.ThemeDtoPost;
import com.example.it_training_back.service.ThemeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final ThemeService themeService;

    public AdminController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @PostMapping("/add-theme")
    public ResponseEntity<ThemeDtoGet> addTheme(@RequestBody ThemeDtoPost themeDtoPost) {
        return ResponseEntity.ok(themeService.addTheme(themeDtoPost));
    }

    @DeleteMapping("/delete-theme/{id}")
    public ResponseEntity<String> deleteTheme(@PathVariable int id) {
        themeService.deleteTheme(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/add-subtheme")
    public ResponseEntity<SubThemeDtoGet> addSubTheme(@RequestBody SubThemeDtoPost subThemeDtoPost) {
        return ResponseEntity.ok(themeService.addSubTheme(subThemeDtoPost));
    }

    @GetMapping("/subthemes")
    public ResponseEntity<List<SubThemeDtoGet>> getAllSubThemes() {
        return ResponseEntity.ok(themeService.getAllSubThemes());
    }
}
