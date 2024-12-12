package com.example.it_training_back.controller.training;

import com.example.it_training_back.dto.session.SessionDtoGet;
import com.example.it_training_back.dto.training.TrainingDtoGet;
import com.example.it_training_back.service.TrainingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitor")
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

    @GetMapping("/training")
    public ResponseEntity<List<TrainingDtoGet>> getAllTrainings() {
        return ResponseEntity.ok(trainingService.getAllTrainings());
    }

    @GetMapping("/session/findByTraining/{trainingId}")
    public ResponseEntity<List<SessionDtoGet>> getSessionsByTraining(@PathVariable int trainingId) {
        return ResponseEntity.ok(trainingService.getSessionsByTrainingID(trainingId));
    }

    @GetMapping("/session/{sessionId}")
    public ResponseEntity<SessionDtoGet> getSessionById(@PathVariable long sessionId) {
        return ResponseEntity.ok(trainingService.getSessionById(sessionId));
    }
}
