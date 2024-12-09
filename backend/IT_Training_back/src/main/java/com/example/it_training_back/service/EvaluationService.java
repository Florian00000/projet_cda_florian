package com.example.it_training_back.service;

import com.example.it_training_back.entity.Evaluation;
import com.example.it_training_back.repository.EvaluationRepository;
import org.springframework.stereotype.Service;

@Service
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    public EvaluationService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public Evaluation save(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);

    }
}
