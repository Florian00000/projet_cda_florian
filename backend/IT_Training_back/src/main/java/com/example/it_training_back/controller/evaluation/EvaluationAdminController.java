package com.example.it_training_back.controller.evaluation;

import com.example.it_training_back.dto.BaseResponseDto;
import com.example.it_training_back.dto.ListString;
import com.example.it_training_back.dto.evaluation.EvaluationDtoGet;
import com.example.it_training_back.service.EvaluationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/evaluation")
public class EvaluationAdminController {

    private final EvaluationService evaluationService;

    public EvaluationAdminController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping()
    public ResponseEntity<List<EvaluationDtoGet>> getAllEvaluations() {
        return ResponseEntity.ok(evaluationService.getAllEvaluations());
    }

    @GetMapping("/readByAdmin=true")
    public ResponseEntity<List<EvaluationDtoGet>> getAllEvaluationsReadByAdmin() {
        return ResponseEntity.ok(evaluationService.getAllEvaluationsByReadByAdmin(true));
    }

    @GetMapping("/readByAdmin=false")
    public ResponseEntity<List<EvaluationDtoGet>> getAllEvaluationsNotReadByAdmin() {
        return ResponseEntity.ok(evaluationService.getAllEvaluationsByReadByAdmin(false));
    }

    @PatchMapping("/{idEvaluation}/readByAdmin")
    public ResponseEntity<EvaluationDtoGet> readByAdmin(@PathVariable String idEvaluation) {
        return ResponseEntity.ok(evaluationService.readEvaluation(idEvaluation));
    }

    @PatchMapping("/list/readByAdmin")
    public ResponseEntity<BaseResponseDto> readByAdmin(@RequestBody ListString listString) {
       return ResponseEntity.ok(evaluationService.readListEvaluations(listString));
    }
}
