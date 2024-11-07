package com.example.it_training_back;

import com.example.it_training_back.dto.testUser.TestUserDtoGet;
import com.example.it_training_back.dto.testUser.TestUserDtoPost;
import com.example.it_training_back.dto.testUser.proposition.PropositionDtoPost;
import com.example.it_training_back.dto.testUser.question.QuestionDtoPost;
import com.example.it_training_back.dto.training.TrainingDtoGet;
import com.example.it_training_back.entity.Proposition;
import com.example.it_training_back.entity.Question;
import com.example.it_training_back.entity.TestUser;
import com.example.it_training_back.entity.Training;
import com.example.it_training_back.exception.NotFoundException;
import com.example.it_training_back.repository.TrainingRepository;
import com.example.it_training_back.repository.testUser.PropositionRepository;
import com.example.it_training_back.repository.testUser.QuestionRepository;
import com.example.it_training_back.repository.testUser.TestUserRepository;
import com.example.it_training_back.service.TestUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

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

    @Test
    public void GivenExistantId_WhenGetTestUser_ThenReturnTestUser() {
        //arrange
        TestUser testUser = TestUser.builder().id(1L)
                .questions(List.of(Question.builder().id(1L)
                        .propositions(List.of(Proposition.builder().id(1L).build())).build()))
                .build();
        Mockito.when(testUserRepository.findById(1L)).thenReturn(Optional.of(testUser));

        //act
        TestUserDtoGet result = testUserService.getTestUser(1L);

        //assert
        Mockito.verify(testUserRepository, Mockito.times(1)).findById(1L);
        Assertions.assertEquals(1L, result.getId());
        Assertions.assertEquals(1L, result.getQuestions().get(0).getId());
        Assertions.assertEquals(1L, result.getQuestions().get(0).getPropositions().get(0).getId());
    }

    @Test
    public void GivenNonExistantId_WhenGetTestUser_ThenThrowException() {
        //arrange
        Mockito.when(testUserRepository.findById(1L)).thenReturn(Optional.empty());

        //act & assert
        Assertions.assertThrows(NotFoundException.class, () -> testUserService.getTestUser(1L));
    }

    @Test
    public void WhenGetAllTestUsers_ThenReturnAllTestUsers() {
        //arrange
        TestUser testUser1 = TestUser.builder().id(1L)
                .questions(List.of(Question.builder().id(1L)
                        .propositions(List.of(Proposition.builder().id(1L).build())).build()))
                .build();
        TestUser testUser2 = TestUser.builder().id(2L)
                .questions(List.of(Question.builder().id(1L)
                        .propositions(List.of(Proposition.builder().id(1L).build())).build()))
                .build();
        Mockito.when(testUserRepository.findAll()).thenReturn(List.of(testUser1, testUser2));

        //act
        List<TestUserDtoGet> result = testUserService.getAllTestUsers();

        //assert
        Mockito.verify(testUserRepository, Mockito.times(1)).findAll();
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(1L, result.get(0).getId());
        Assertions.assertEquals(2L, result.get(1).getId());
    }

    @Test
    public void WhenGetAllTestUsers_ThenReturnEmptyList(){
        //arrange
        Mockito.when(testUserRepository.findAll()).thenReturn(List.of());

        //act
        List<TestUserDtoGet> result = testUserService.getAllTestUsers();

        //assert
        Mockito.verify(testUserRepository, Mockito.times(1)).findAll();
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void GivenExistantsIds_WhenAddTestToTraining(){
        //arrange
        TestUser testUser = TestUser.builder().id(1L)
                .questions(List.of(Question.builder().id(1L)
                        .propositions(List.of(Proposition.builder().id(1L).build())).build()))
                .build();
        Mockito.when(testUserRepository.findById(1L)).thenReturn(Optional.of(testUser));
        Training training = Training.builder().id(1).build();
        Mockito.when(trainingRepository.findById(1)).thenReturn(Optional.of(training));


        //act
        TrainingDtoGet result = testUserService.addTestToTraining(1L, 1);

        //assertion
        Mockito.verify(trainingRepository, Mockito.times(1)).save(Mockito.any(Training.class));
        Assertions.assertEquals(1, result.getId());
        Assertions.assertEquals(1L, result.getTestUser().getId());
    }

    @Test
    public void GivenNonExistantIdForTestUser_WhenAddTestToTraining_ThenThrowException() {
        //arrange
        Mockito.when(testUserRepository.findById(1L)).thenReturn(Optional.empty());

        //act & assertion
        Assertions.assertThrows(NotFoundException.class, () -> testUserService.addTestToTraining(1L, 1));
    }

    @Test
    public void GivenNonExistantIdForTraining_WhenAddTestToTraining_ThenThrowException() {
        //arrange
        Mockito.when(trainingRepository.findById(1)).thenReturn(Optional.empty());

        //act & assertion
        Assertions.assertThrows(NotFoundException.class, () -> testUserService.addTestToTraining(1L, 1));
    }
}
