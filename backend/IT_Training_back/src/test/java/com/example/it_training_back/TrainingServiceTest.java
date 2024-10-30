package com.example.it_training_back;

import com.example.it_training_back.dto.training.TrainingDtoGet;
import com.example.it_training_back.dto.training.TrainingDtoPost;
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
        TrainingDtoPost trainingDtoPost = TrainingDtoPost.builder().title("training").subThemes(List.of(1)).build();
        Mockito.when(subThemeRepository.findById(1)).thenReturn(Optional.empty());

        //act & assert
        Assertions.assertThrows(NotFoundException.class, () -> trainingService.addTraining(trainingDtoPost));
    }

    //TODO Faire des test où il manque des informations
}
