package com.example.it_training_back.controller.evaluation;

import com.example.it_training_back.entity.Evaluation;
import com.example.it_training_back.service.EvaluationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/visitor/evaluation")
public class EvaluationUserController {

    private final EvaluationService evaluationService;

    public EvaluationUserController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PostMapping
    public ResponseEntity<Evaluation> addEvaluation(@RequestBody Evaluation evaluation) {
        return ResponseEntity.ok(evaluationService.save(evaluation));
    }
}
