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
public class ThemeAdminController {

    private final ThemeService themeService;

    public ThemeAdminController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @PostMapping("/theme/add")
    public ResponseEntity<ThemeDtoGet> addTheme(@RequestBody ThemeDtoPost themeDtoPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(themeService.addTheme(themeDtoPost));
    }

    @DeleteMapping("/theme/delete/{id}")
    public ResponseEntity<String> deleteTheme(@PathVariable int id) {
        themeService.deleteTheme(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/theme/update/{id}")
    public ResponseEntity<ThemeDtoGet> updateTheme(@PathVariable int id, @RequestBody ThemeDtoPost themeDtoPost) {
        return ResponseEntity.ok(themeService.updateTheme(id, themeDtoPost));
    }

    @PostMapping("/subTheme/add")
    public ResponseEntity<SubThemeDtoGet> addSubTheme(@RequestBody SubThemeDtoPost subThemeDtoPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(themeService.addSubTheme(subThemeDtoPost));
    }

    @DeleteMapping("/subTheme/delete/{id}")
    public ResponseEntity<String> deleteSubTheme(@PathVariable int id) {
        themeService.deleteSubTheme(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/subTheme/update/{id}")
    public ResponseEntity<SubThemeDtoGet> updateSubTheme(@PathVariable int id, @RequestBody SubThemeDtoPost subThemeDtoPost) {
        return ResponseEntity.ok(themeService.updateSubTheme(id, subThemeDtoPost));
    }

}
