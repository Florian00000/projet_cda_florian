package com.example.it_training_back;

import com.example.it_training_back.dto.testUser.TestUserDtoGet;
import com.example.it_training_back.dto.testUser.TestUserDtoPost;
import com.example.it_training_back.dto.testUser.proposition.PropositionDtoPost;
import com.example.it_training_back.dto.testUser.question.QuestionDtoPost;
import com.example.it_training_back.entity.Proposition;
import com.example.it_training_back.entity.Question;
import com.example.it_training_back.entity.TestUser;
import com.example.it_training_back.repository.TrainingRepository;
import com.example.it_training_back.repository.testUser.PropositionRepository;
import com.example.it_training_back.repository.testUser.QuestionRepository;
import com.example.it_training_back.repository.testUser.TestUserRepository;
import com.example.it_training_back.service.TestUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class TestUserServiceTest {

    private TestUserService testUserService;
    private TestUserRepository testUserRepository;
    private QuestionRepository questionRepository;
    private PropositionRepository propositionRepository;
    private TrainingRepository trainingRepository;

    @BeforeEach
    public void setUp() {
        trainingRepository = Mockito.mock(TrainingRepository.class);
        testUserRepository = Mockito.mock(TestUserRepository.class);
        questionRepository = Mockito.mock(QuestionRepository.class);
        propositionRepository = Mockito.mock(PropositionRepository.class);
        testUserService = new TestUserService(trainingRepository, testUserRepository, questionRepository, propositionRepository);
    }

    @Test
    public void GivenValidTestUser_WhenAddTestUser_ThenSaveTestUser() {
        //arrange
        TestUserDtoPost testUserDtoPost = TestUserDtoPost.builder()
                .expectedResult(35)
                .questions(List.of(
                        QuestionDtoPost.builder()
                                .label("question1")
                                .answer("option1")
                                .propositions(List.of(
                                        PropositionDtoPost.builder().option("option1").build(),
                                        PropositionDtoPost.builder().option("option2").build()
                                ))
                                .build(),
                        QuestionDtoPost.builder()
                                .label("question2")
                                .answer("option1")
                                .propositions(List.of(
                                        PropositionDtoPost.builder().option("option1").build(),
                                        PropositionDtoPost.builder().option("option2").build()
                                ))
                                .build()
                ))
                .build();
        Proposition savedProposition1 = Proposition.builder().option("option1").build();
        Proposition savedProposition2 = Proposition.builder().option("option2").build();
        Question savedQuestion = Question.builder().label("question1").propositions(List.of(savedProposition1, savedProposition2)).build();
        TestUser savedTestUser = TestUser.builder().id(1L).expectedResult(35).questions(List.of(savedQuestion, savedQuestion)).build();
        Mockito.when(testUserRepository.save(Mockito.any(TestUser.class))).thenReturn(savedTestUser);
        Mockito.when(questionRepository.save(Mockito.any(Question.class))).thenReturn(savedQuestion);

        //act
        TestUserDtoGet result = testUserService.addTestUser(testUserDtoPost);

        //Assert
        Mockito.verify(testUserRepository, Mockito.times(1)).save(Mockito.any(TestUser.class));
        Mockito.verify(questionRepository, Mockito.times(2)).save(Mockito.any(Question.class));

        Assertions.assertEquals(35, result.getExpectedResult());
        Assertions.assertEquals(2, result.getQuestions().size());
        Assertions.assertEquals("question1", result.getQuestions().get(0).getLabel());
    }

    @Test
    public void GivenEmptyQuestions_WhenAddTestUser_ThenThrowException() {
        //arrange
        TestUserDtoPost testUserDtoPost = TestUserDtoPost.builder()
                .expectedResult(35)
                .questions(List.of())
                .build();

        //act & assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> testUserService.addTestUser(testUserDtoPost));
    }

    @Test
    public void GivenEmptyPropositions_WhenAddTestUser_ThenThrowException() {
        //arrange
        TestUserDtoPost testUserDtoPost = TestUserDtoPost.builder()
                .expectedResult(35)
                .questions(List.of(
                        QuestionDtoPost.builder().propositions(List.of()).build()
                ))
                .build();
        Mockito.when(testUserRepository.save(Mockito.any(TestUser.class))).thenReturn(new TestUser());

        //act & assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> testUserService.addTestUser(testUserDtoPost));
    }

    @Test
    public void GivenQuestionWithoutMatchingAnswer_WhenAddTestUser_ThenThrowException(){
        //arrange
        TestUserDtoPost testUserDtoPost = TestUserDtoPost.builder()
                .expectedResult(35)
                .questions(List.of(
                        QuestionDtoPost.builder()
                                .label("question1")
                                .answer("réponse")
                                .propositions(List.of(
                                        PropositionDtoPost.builder().option("option1").build()
                                ))
                                .build()
                ))
                .build();

        TestUser testUser = TestUser.builder().expectedResult(35).build();
        Mockito.when(testUserRepository.save(Mockito.any(TestUser.class))).thenReturn(testUser);
        Question savedQuestion = Question.builder().label("question1").testUser(testUser).build();
        Mockito.when(questionRepository.save(Mockito.any(Question.class))).thenReturn(savedQuestion);
        Proposition savedProposition1 = Proposition.builder().option("option1").build();
        Mockito.when(propositionRepository.save(Mockito.any(Proposition.class))).thenReturn(savedProposition1);

        //act & assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> testUserService.addTestUser(testUserDtoPost),
                "no option matches the solution");
    }
}
