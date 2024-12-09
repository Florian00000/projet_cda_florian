package com.example.it_training_back.controller.evaluation;

import com.example.it_training_back.dto.BaseResponseDto;
import com.example.it_training_back.dto.evaluation.EvaluationDtoGet;
import com.example.it_training_back.dto.evaluation.EvaluationDtoPost;
import com.example.it_training_back.service.EvaluationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/evaluation")
public class EvaluationUserController {

    private final EvaluationService evaluationService;

    public EvaluationUserController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PostMapping("/add")
    public ResponseEntity<EvaluationDtoGet> addEvaluation(@RequestBody EvaluationDtoPost evaluationDtoPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(evaluationService.addEvaluation(evaluationDtoPost));
    }

    @GetMapping("/{evaluationId}")
    public ResponseEntity<EvaluationDtoGet> getEvaluation(@PathVariable String evaluationId) {
        return ResponseEntity.ok(evaluationService.getEvaluation(evaluationId));
    }

    @GetMapping("/{idUser}/alreadyRated/{idSession}")
    public ResponseEntity<BaseResponseDto> alreadyRated(@PathVariable("idUser") long idUser,
                                                        @PathVariable("idSession") long idSession) {
        if (evaluationService.alreadyRated(idUser, idSession)) {
            return ResponseEntity.ok(new BaseResponseDto("Already Rated by this user", true ));
        }else{
            return ResponseEntity.ok(new BaseResponseDto("Not rated by this user", false ));
        }
    }
}
