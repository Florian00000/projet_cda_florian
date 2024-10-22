package com.example.it_training_back;

import com.example.it_training_back.dto.theme.ThemeDtoGet;
import com.example.it_training_back.dto.theme.ThemeDtoPost;
import com.example.it_training_back.repository.SubThemeRepository;
import com.example.it_training_back.repository.ThemeRepository;
import com.example.it_training_back.service.TrainingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TrainingServiceTest {

    private TrainingService trainingService;
    private ThemeRepository themeRepository = Mockito.mock(ThemeRepository.class);
    private SubThemeRepository subThemeRepository = Mockito.mock(SubThemeRepository.class);

    @BeforeEach
    public void setUp() {
        trainingService = new TrainingService(themeRepository, subThemeRepository);
    }

    @Test public void testAddTheme(){
        //arrange
        ThemeDtoPost themeDtoPost = new ThemeDtoPost();
        themeDtoPost.setTitle("Réseau");
        themeDtoPost.setImagePath("./chemin");

        //arrange
        ThemeDtoGet themeDtoGet = new ThemeDtoGet();
        themeDtoGet.setId(1);
        themeDtoGet.setTitle("Réseau");
        themeDtoGet.setImagePath("./chemin");

        //act
        trainingService.addTheme(themeDtoPost);

        //TODO assert
    }
}
