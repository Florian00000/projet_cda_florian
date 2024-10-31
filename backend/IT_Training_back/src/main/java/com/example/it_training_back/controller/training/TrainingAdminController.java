package com.example.it_training_back.controller.training;

import com.example.it_training_back.dto.training.TrainingDtoGet;
import com.example.it_training_back.dto.training.TrainingDtoPost;
import com.example.it_training_back.service.TrainingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class TrainingAdminController {

    private final TrainingService trainingService;

    public TrainingAdminController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping("/training/add")
    public ResponseEntity<TrainingDtoGet> addTraining(@RequestBody TrainingDtoPost trainingDtoPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(trainingService.addTraining(trainingDtoPost));
    }
}
