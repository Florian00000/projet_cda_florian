package com.example.it_training_back.service;

import com.example.it_training_back.dto.evaluation.EvaluationDtoGet;
import com.example.it_training_back.dto.evaluation.EvaluationDtoPost;
import com.example.it_training_back.entity.Evaluation;
import com.example.it_training_back.entity.user.User;
import com.example.it_training_back.exception.NotFoundException;
import com.example.it_training_back.repository.EvaluationRepository;
import com.example.it_training_back.repository.SessionRepository;
import com.example.it_training_back.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;

    public EvaluationService(EvaluationRepository evaluationRepository, UserRepository userRepository,
                             SessionRepository sessionRepository) {
        this.evaluationRepository = evaluationRepository;
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    public EvaluationDtoGet addEvaluation(EvaluationDtoPost evaluationDtoPost) {

        User user = userRepository.findById(evaluationDtoPost.getIdUser()).orElseThrow(
                () -> new NotFoundException("User not found")
        );
        sessionRepository.findById(evaluationDtoPost.getIdSession()).orElseThrow(
                () -> new NotFoundException("Session not found")
        );

        sessionRepository.findByIdAndUsers(evaluationDtoPost.getIdSession(), List.of(user)).orElseThrow(
                () -> new NotFoundException("This user is not registered for this session")
        );

        if (alreadyRated(evaluationDtoPost.getIdUser(), evaluationDtoPost.getIdSession())){
            throw new IllegalArgumentException("This user has already evaluated this session");
        }

        if (evaluationDtoPost.getQualityReception() > 5 || evaluationDtoPost.getQualityEnvironment() > 5 ||
        evaluationDtoPost.getPedagogy() > 5 || evaluationDtoPost.getDomainExpertise() > 5 ||
        evaluationDtoPost.getQualityResponses() > 5 || evaluationDtoPost.getTechnicalAnimations() > 5) {
            throw new IllegalArgumentException("the score cannot be higher than 5");
        }

        if (evaluationDtoPost.getQualityReception() < 1 || evaluationDtoPost.getQualityEnvironment() < 1 ||
                evaluationDtoPost.getPedagogy() < 1 || evaluationDtoPost.getDomainExpertise() < 1 ||
                evaluationDtoPost.getQualityResponses() < 1 || evaluationDtoPost.getTechnicalAnimations() < 1) {
            throw new IllegalArgumentException("the score cannot be less than 1");
        }

        Evaluation evaluation = Evaluation.builder()
                .qualityReception(evaluationDtoPost.getQualityReception())
                .qualityEnvironment(evaluationDtoPost.getQualityEnvironment())
                .pedagogy(evaluationDtoPost.getPedagogy())
                .domainExpertise(evaluationDtoPost.getDomainExpertise())
                .qualityResponses(evaluationDtoPost.getQualityResponses())
                .technicalAnimations(evaluationDtoPost.getTechnicalAnimations())
                .recommended(evaluationDtoPost.isRecommended())
                .valuationDate(LocalDateTime.now())
                .idUser(evaluationDtoPost.getIdUser())
                .idSession(evaluationDtoPost.getIdSession())
                .build();

        if (evaluationDtoPost.getTrainingProjects() != null){
            evaluation.setTrainingProjects(evaluationDtoPost.getTrainingProjects());
        }

        evaluationRepository.save(evaluation);
        return new EvaluationDtoGet(evaluation);

    }

    public boolean alreadyRated(long idUser, long idSession) {
        Optional<Evaluation> alreadyRated = evaluationRepository.findByIdUserAndIdSession(idUser, idSession);
        return alreadyRated.isPresent();
    }
}
