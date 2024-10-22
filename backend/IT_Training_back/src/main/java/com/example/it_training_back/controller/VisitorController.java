package com.example.it_training_back.controller;

import com.example.it_training_back.dto.theme.ThemeDtoGet;
import com.example.it_training_back.dto.theme.ThemeDtoPost;
import com.example.it_training_back.service.TrainingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class VisitorController {

    private final TrainingService trainingService;

    public VisitorController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping("/add-theme")
    public ResponseEntity<ThemeDtoGet> addTheme(@RequestBody ThemeDtoPost themeDtoPost) {
        return ResponseEntity.ok(trainingService.addTheme(themeDtoPost));
    }
}
