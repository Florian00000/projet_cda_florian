package com.example.it_training_back;

import com.example.it_training_back.dto.theme.ThemeDtoGet;
import com.example.it_training_back.dto.theme.ThemeDtoPost;
import com.example.it_training_back.entity.Theme;
import com.example.it_training_back.repository.SubThemeRepository;
import com.example.it_training_back.repository.ThemeRepository;
import com.example.it_training_back.service.TrainingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
}
