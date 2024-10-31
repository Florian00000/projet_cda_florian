package com.example.it_training_back.controller.training;

import com.example.it_training_back.dto.training.TrainingDtoGet;
import com.example.it_training_back.service.TrainingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TrainingVisitorController {

    private final TrainingService trainingService;

    public TrainingVisitorController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping("/training/findBySubTheme/{subThemeId}")
    public ResponseEntity<List<TrainingDtoGet>> getTrainingBySubTheme(@PathVariable int subThemeId) {
        return ResponseEntity.ok(trainingService.getAllTrainingsBySubThemeId(subThemeId));
    }

    @GetMapping("/training/{trainingId}")
    public ResponseEntity<TrainingDtoGet> getTrainingById(@PathVariable int trainingId) {
        return ResponseEntity.ok(trainingService.getTraining(trainingId));
    }
}
