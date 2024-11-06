package com.example.it_training_back.service;

import com.example.it_training_back.dto.testUser.TestUserDtoGet;
import com.example.it_training_back.dto.testUser.TestUserDtoPost;
import com.example.it_training_back.dto.testUser.question.QuestionDtoPost;
import com.example.it_training_back.entity.Proposition;
import com.example.it_training_back.entity.Question;
import com.example.it_training_back.entity.TestUser;
import com.example.it_training_back.repository.TrainingRepository;
import com.example.it_training_back.repository.testUser.PropositionRepository;
import com.example.it_training_back.repository.testUser.QuestionRepository;
import com.example.it_training_back.repository.testUser.TestUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestUserService {

    private final TrainingRepository trainingRepository;
    private final TestUserRepository testUserRepository;
    private final QuestionRepository questionRepository;
    private final PropositionRepository propositionRepository;

    public TestUserService(TrainingRepository trainingRepository, TestUserRepository testUserRepository,
                           QuestionRepository questionRepository, PropositionRepository propositionRepository) {
        this.trainingRepository = trainingRepository;
        this.testUserRepository = testUserRepository;
        this.questionRepository = questionRepository;
        this.propositionRepository = propositionRepository;
    }

    //============================= TestUser =============================

    @Transactional
    public TestUserDtoGet addTestUser(TestUserDtoPost testUserDtoPost) {

        if ( testUserDtoPost.getQuestions() == null || testUserDtoPost.getQuestions().isEmpty()){
            throw new IllegalArgumentException("Questions cannot be null or empty");
        }
        TestUser testUser = TestUser.builder().expectedResult(testUserDtoPost.getExpectedResult()).build();
        testUser = testUserRepository.save(testUser);

        for (QuestionDtoPost questionDtoPost : testUserDtoPost.getQuestions()) {

            if ( questionDtoPost.getPropositions() == null || questionDtoPost.getPropositions().isEmpty()){
                throw new IllegalArgumentException("Propositions cannot be null or empty");
            }

            Question question = Question.builder()
                    .label(questionDtoPost.getLabel())
                    .answer(questionDtoPost.getAnswer())
                    .testUser(testUser)
                    .build();
            questionRepository.save(question);

            List<Proposition> propositions = questionDtoPost.getPropositions().stream()
                    .map(propositionDto -> Proposition.builder()
                            .option(propositionDto.getOption())
                            .question(question)
                            .build())
                    .toList();
            propositionRepository.saveAll(propositions);
        }

        return new TestUserDtoGet(testUser);
    }

}
