package com.example.it_training_back;

import com.example.it_training_back.dto.theme.ThemeDtoGet;
import com.example.it_training_back.dto.theme.ThemeDtoPost;
import com.example.it_training_back.entity.Theme;
import com.example.it_training_back.repository.SubThemeRepository;
import com.example.it_training_back.repository.ThemeRepository;
import com.example.it_training_back.service.TrainingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TrainingServiceTest {

    private TrainingService trainingService;
    private ThemeRepository themeRepository = Mockito.mock(ThemeRepository.class);
    private SubThemeRepository subThemeRepository = Mockito.mock(SubThemeRepository.class);

    @BeforeEach
    public void setUp() {
        trainingService = new TrainingService(themeRepository, subThemeRepository);
    }

    @Test public void GivenNewTest_ThenNewTestIsSaved() {
        //arrange
        ThemeDtoPost themeDtoPost = new ThemeDtoPost();
        themeDtoPost.setTitle("Réseau");
        themeDtoPost.setImagePath("./chemin");

        //act
        trainingService.addTheme(themeDtoPost);

        //assert
        verify(themeRepository, times(1)).save(any(Theme.class));
    }

    @Test public void GivenNewTest_ThenReturnThemeDtoGet() {
        //arrange
        ThemeDtoPost themeDtoPost = new ThemeDtoPost();
        themeDtoPost.setTitle("Réseau");
        themeDtoPost.setImagePath("./chemin");

        //act
        ThemeDtoGet result = trainingService.addTheme(themeDtoPost);

        //assert
        assertEquals("Réseau", result.getTitle());
        assertEquals("./chemin", result.getImagePath());
    }

    //TODO finir le test
    @Test public void GivenDuplicateTitle_WhenAddTheme_ThenThrowException() {
        //arrange
        ThemeDtoPost themeDtoPost = new ThemeDtoPost();
        themeDtoPost.setTitle("Réseau");
        themeDtoPost.setImagePath("./chemin");

        //act
        trainingService.addTheme(themeDtoPost);

        //assert
        Assertions.assertThrows(Exception.class, () -> trainingService.addTheme(themeDtoPost));
    }
}
