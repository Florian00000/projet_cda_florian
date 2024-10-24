package com.example.it_training_back.controller;

import com.example.it_training_back.dto.subTheme.SubThemeDtoGet;
import com.example.it_training_back.dto.subTheme.SubThemeDtoPost;
import com.example.it_training_back.dto.theme.ThemeDtoGet;
import com.example.it_training_back.dto.theme.ThemeDtoPost;
import com.example.it_training_back.service.TrainingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final TrainingService trainingService;

    public AdminController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping("/add-theme")
    public ResponseEntity<ThemeDtoGet> addTheme(@RequestBody ThemeDtoPost themeDtoPost) {
        return ResponseEntity.ok(trainingService.addTheme(themeDtoPost));
    }

    @DeleteMapping("/delete-theme/{id}")
    public ResponseEntity<String> deleteTheme(@PathVariable int id) {
        trainingService.deleteTheme(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/add-subtheme")
    public ResponseEntity<SubThemeDtoGet> addSubTheme(@RequestBody SubThemeDtoPost subThemeDtoPost) {
        return ResponseEntity.ok(trainingService.addSubTheme(subThemeDtoPost));
    }

    @GetMapping("/subthemes")
    public ResponseEntity<List<SubThemeDtoGet>> getAllSubThemes() {
        return ResponseEntity.ok(trainingService.getAllSubThemes());
    }
}
