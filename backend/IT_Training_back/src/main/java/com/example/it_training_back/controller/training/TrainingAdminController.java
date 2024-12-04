package com.example.it_training_back.controller.training;

import com.example.it_training_back.dto.location.LocationDtoGet;
import com.example.it_training_back.dto.location.LocationDtoPost;
import com.example.it_training_back.dto.session.SessionDtoGet;
import com.example.it_training_back.dto.session.SessionDtoPost;
import com.example.it_training_back.dto.training.TrainingDtoGet;
import com.example.it_training_back.dto.training.TrainingDtoPost;
import com.example.it_training_back.service.TrainingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class TrainingAdminController {

    private final TrainingService trainingService;

    public TrainingAdminController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping("/training/add")
    public ResponseEntity<TrainingDtoGet> addTraining(@RequestBody TrainingDtoPost trainingDtoPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(trainingService.addTraining(trainingDtoPost));
    }

    @PostMapping("/session/add")
    public ResponseEntity<SessionDtoGet> addSession(@RequestBody SessionDtoPost sessionDtoPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(trainingService.addSession(sessionDtoPost));
    }

    @PostMapping("/location/add")
    public ResponseEntity<LocationDtoGet> addLocation(@RequestBody LocationDtoPost locationDtoPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(trainingService.addLocation(locationDtoPost));
    }

    @GetMapping("/location")
    public ResponseEntity<List<LocationDtoGet>> getAllLocations() {
        return ResponseEntity.status(HttpStatus.OK).body(trainingService.getAllLocations());
    }
}
