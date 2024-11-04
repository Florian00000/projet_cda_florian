package com.example.it_training_back;

import com.example.it_training_back.dto.training.TrainingDtoGet;
import com.example.it_training_back.dto.training.TrainingDtoPost;
import com.example.it_training_back.entity.Session;
import com.example.it_training_back.entity.SubTheme;
import com.example.it_training_back.entity.Training;
import com.example.it_training_back.exception.NotFoundException;
import com.example.it_training_back.repository.LocationRepository;
import com.example.it_training_back.repository.SessionRepository;
import com.example.it_training_back.repository.SubThemeRepository;
import com.example.it_training_back.repository.TrainingRepository;
import com.example.it_training_back.service.TrainingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

public class TrainingServiceTest {

    private TrainingService trainingService;
    private final TrainingRepository trainingRepository = Mockito.mock(TrainingRepository.class);
    private final LocationRepository locationRepository = Mockito.mock(LocationRepository.class);
    private final SessionRepository sessionRepository = Mockito.mock(SessionRepository.class);
    private final SubThemeRepository subThemeRepository = Mockito.mock(SubThemeRepository.class);

    @BeforeEach
    public void setUp() {
        trainingService = new TrainingService(trainingRepository, locationRepository, sessionRepository, subThemeRepository);
    }

    @Test
    public void GivenAddTraining_ThenSaveTraining(){
        //arrange
        TrainingDtoPost trainingDtoPost = TrainingDtoPost.builder().title("training")
                .description("# title description #").price(5.5).inter(true).imagePath("/path")
                .subThemes(List.of(1, 2)).build();
        SubTheme subTheme1 = SubTheme.builder().id(1).title("title1").build();
        SubTheme subTheme2 = SubTheme.builder().id(2).title("title2").build();
        Mockito.when(subThemeRepository.findById(1)).thenReturn(Optional.of(subTheme1));
        Mockito.when(subThemeRepository.findById(2)).thenReturn(Optional.of(subTheme2));

        //act
        TrainingDtoGet trainingDtoGet = trainingService.addTraining(trainingDtoPost);

        //assert
        Mockito.verify(trainingRepository, Mockito.times(1)).save(Mockito.any(Training.class));
        Assertions.assertEquals("training", trainingDtoGet.getTitle());
        Assertions.assertEquals(5.5, trainingDtoGet.getPrice());
        Assertions.assertTrue(trainingDtoGet.isInter());
        Assertions.assertEquals("/path", trainingDtoGet.getImagePath());
        Assertions.assertTrue(trainingDtoGet.getSubThemes().stream().anyMatch(s -> s.getId() == 1));
        Assertions.assertTrue(trainingDtoGet.getSubThemes().stream().anyMatch(s -> s.getId() == 2));
    }

    @Test
    public void GivenAddTraining_WhenSubThemesHaveNonExistentId_ThenThrowNotFoundException() {
        //arrange
        TrainingDtoPost trainingDtoPost = TrainingDtoPost.builder().title("training")
                .description("# title description #").inter(true)
                .subThemes(List.of(1)).build();
        Mockito.when(subThemeRepository.findById(1)).thenReturn(Optional.empty());

        //act & assert
        Assertions.assertThrows(NotFoundException.class, () -> trainingService.addTraining(trainingDtoPost));
    }

    @Test
    public void GivenAddTraining_WhenManyFieldsAreMissing_ThenSaveTraining(){
        //arrange
        TrainingDtoPost trainingDtoPost = TrainingDtoPost.builder().title("training")
                .description("# title description #").inter(true)
                .subThemes(List.of(1, 2)).build();
        SubTheme subTheme1 = SubTheme.builder().id(1).title("title1").build();
        SubTheme subTheme2 = SubTheme.builder().id(2).title("title2").build();
        Mockito.when(subThemeRepository.findById(1)).thenReturn(Optional.of(subTheme1));
        Mockito.when(subThemeRepository.findById(2)).thenReturn(Optional.of(subTheme2));

        //act
        TrainingDtoGet trainingDtoGet = trainingService.addTraining(trainingDtoPost);

        //assert
        Mockito.verify(trainingRepository, Mockito.times(1)).save(Mockito.any(Training.class));
        Assertions.assertEquals("training", trainingDtoGet.getTitle());
        Assertions.assertTrue(trainingDtoGet.isInter());
        Assertions.assertTrue(trainingDtoGet.getSubThemes().stream().anyMatch(s -> s.getId() == 1));
        Assertions.assertTrue(trainingDtoGet.getSubThemes().stream().anyMatch(s -> s.getId() == 2));
    }

    @Test
    public void GivenGetAllTrainingsBySubThemeId_WhenNonExistantIdForSubTheme_ThenThrowNotFoundException() {
        //arrange
        int subThemeId = 1;
        Mockito.when(subThemeRepository.findById(subThemeId)).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class, () -> trainingService.getAllTrainingsBySubThemeId(subThemeId));
    }

    @Test
    public void GivenGetAllTrainingsBySubThemeId_WhenNoRelationsForSubThemes_ThenReturnEmptyList() {
        //arrange
        int subThemeId = 1;
        SubTheme subTheme = SubTheme.builder().id(1).title("title1").build();
        Mockito.when(subThemeRepository.findById(subThemeId)).thenReturn(Optional.of(subTheme));
        Mockito.when(trainingRepository.findAllBySubThemes(List.of(subTheme))).thenReturn(List.of());

        //act
        List<TrainingDtoGet> result = trainingService.getAllTrainingsBySubThemeId(subThemeId);

        //assert
        Assertions.assertTrue(result.isEmpty());
        Mockito.verify(trainingRepository, Mockito.times(1)).findAllBySubThemes(List.of(subTheme));
    }

    @Test
    public void GivenGetAllTrainingsBySubThemeId_WhenRelationsForSubThemes_ThenReturnTrainings(){
        //arrange
        int subThemeId = 1;
        SubTheme subTheme = SubTheme.builder().id(1).title("title1").build();
        Training training1 = Training.builder().id(1).title("title1").description("test").inter(true).build();
        Training training2 = Training.builder().id(2).title("title2").description("test").inter(true).build();
        Mockito.when(subThemeRepository.findById(subThemeId)).thenReturn(Optional.of(subTheme));
        Mockito.when(trainingRepository.findAllBySubThemes(List.of(subTheme))).thenReturn(List.of(training1, training2));

        //act
        List<TrainingDtoGet> result = trainingService.getAllTrainingsBySubThemeId(subThemeId);

        //assert
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.stream().anyMatch(s -> s.getId() == 1));
        Assertions.assertTrue(result.stream().anyMatch(s -> s.getId() == 2));
    }

    @Test
    public void GivenGetAllTrainingsBySubThemeId_WhenTrainingHaveSessions_ThenReturnSessions(){
        //arrange
        int subThemeId = 1;
        SubTheme subTheme = SubTheme.builder().id(1).title("title1").build();
        Session session = Session.builder().id(1).build();
        Training training1 = Training.builder().id(1).title("title1").
                sessions(List.of(session)).build();
        Training training2 = Training.builder().id(2).title("title2").description("test").inter(true).build();
        Mockito.when(subThemeRepository.findById(subThemeId)).thenReturn(Optional.of(subTheme));
        Mockito.when(trainingRepository.findAllBySubThemes(List.of(subTheme))).thenReturn(List.of(training1, training2));

        //act
        List<TrainingDtoGet> result = trainingService.getAllTrainingsBySubThemeId(subThemeId);

        //assert
        TrainingDtoGet trainingDtoGet = result.stream().filter(t -> t.getId() == 1).findFirst().get();
        boolean sessionPresent = trainingDtoGet.getSessions().stream().anyMatch(s -> s.getId() == 1);
        Assertions.assertTrue(sessionPresent);

    }

    @Test
    public void GivenGetTraining_ThenReturnTraining(){
        //arrange
        int trainingId = 1;
        Training training = Training.builder().id(trainingId).title("title1").description("text").inter(true).build();
        Mockito.when(trainingRepository.findById(trainingId)).thenReturn(Optional.of(training));

        //act
        TrainingDtoGet result = trainingService.getTraining(trainingId);

        //assert
        Mockito.verify(trainingRepository, Mockito.times(1)).findById(trainingId);
        Assertions.assertEquals(1, result.getId());
        Assertions.assertEquals("title1", result.getTitle());
        Assertions.assertEquals("text", result.getDescription());
        Assertions.assertTrue(result.isInter());
    }

    @Test
    public void GivenGetTraining_WhenNonExistantId_ThenThrowNotFoundException() {
        //arrange
        int trainingId = 1;
        Mockito.when(trainingRepository.findById(trainingId)).thenReturn(Optional.empty());

        //act & assert
        Assertions.assertThrows(NotFoundException.class, () -> trainingService.getTraining(trainingId));
    }

    @Test
    public void GivenGetAllTrainings_ThenReturnAllTrainings(){
        //arrange
        Training training1 = Training.builder().id(1).title("title1").build();
        Training training2 = Training.builder().id(2).title("title2").build();
        List<Training> trainings = List.of(training1, training2);
        Mockito.when(trainingRepository.findAll()).thenReturn(trainings);

        //act
        List<TrainingDtoGet> result = trainingService.getAllTrainings();

        //assert
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.stream().anyMatch(s -> s.getId() == 1));
        Assertions.assertTrue(result.stream().anyMatch(s -> s.getId() == 2));
    }

    @Test
    public void  GivenGetAllTrainings_ThenReturnEmptyList(){
        //arrange
        Mockito.when(trainingRepository.findAll()).thenReturn(List.of());

        //act
        List<TrainingDtoGet> result = trainingService.getAllTrainings();

        //assert
        Assertions.assertTrue(result.isEmpty());
        Mockito.verify(trainingRepository, Mockito.times(1)).findAll();
    }
}
