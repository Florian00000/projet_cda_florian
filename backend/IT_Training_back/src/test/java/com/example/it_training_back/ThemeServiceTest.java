package com.example.it_training_back;

import com.example.it_training_back.dto.theme.ThemeDtoGet;
import com.example.it_training_back.dto.theme.ThemeDtoPost;
import com.example.it_training_back.entity.Theme;
import com.example.it_training_back.exception.NotFoundException;
import com.example.it_training_back.repository.SubThemeRepository;
import com.example.it_training_back.repository.ThemeRepository;
import com.example.it_training_back.service.TrainingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ThemeServiceTest {

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

    @Test public void GivenDuplicateTitle_WhenAddTheme_ThenThrowException() {
        //arrange
        ThemeDtoPost themeDtoPost = new ThemeDtoPost();
        themeDtoPost.setTitle("Réseau");
        themeDtoPost.setImagePath("./chemin");

        Theme existingTheme = Theme.builder().title("Réseau").id(1).build();
        Mockito.when(themeRepository.findByTitleIgnoreCase("Réseau")).thenReturn(Optional.of(existingTheme));

        //act and assert
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> trainingService.addTheme(themeDtoPost));
    }

    @Test public void WhenRemoveTheme_ThenRemoveTheme() {
        //arrange
        Theme existingTheme = Theme.builder().id(1).build();
        Mockito.when(themeRepository.findById(1)).thenReturn(Optional.of(existingTheme));

        //act
        trainingService.deleteTheme(1);

        //assert
        verify(themeRepository, times(1)).delete(existingTheme);
        Mockito.when(themeRepository.findById(1)).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> trainingService.deleteTheme(1));
    }

    @Test
    public void WhenGetAllThemes_ThenReturnAllThemes() {
        // arrange
        Theme theme1 = Theme.builder().id(1).title("Réseau").imagePath("./image1").build();
        Theme theme2 = Theme.builder().id(2).title("Sécurité").imagePath("./image2").build();

        List<Theme> mockThemes = Arrays.asList(theme1, theme2);

        Mockito.when(themeRepository.findAll()).thenReturn(mockThemes);

        // act
        List<ThemeDtoGet> result = trainingService.getAllThemes();

        // assert
        assertEquals(2, result.size());
        assertEquals("Réseau", result.get(0).getTitle());
        assertEquals("Sécurité", result.get(1).getTitle());
        verify(themeRepository, times(1)).findAll();
    }

    @Test
    public void WhenGetAllThemes_ThenReturnEmptyList() {
        // arrange
        Mockito.when(themeRepository.findAll()).thenReturn(Collections.emptyList());

        // act
        List<ThemeDtoGet> result = trainingService.getAllThemes();

        // assert
        Assertions.assertTrue(result.isEmpty());
        verify(themeRepository, times(1)).findAll();
    }

    @Test
    public void WhenUpdateThemeWithValidData_ThenThemeIsUpdated() {
        //arrange
        Theme existingTheme = Theme.builder().id(1).title("réso").imagePath("./che").build();
        ThemeDtoPost themeDtoPost = new ThemeDtoPost();
        themeDtoPost.setTitle("réseau");
        themeDtoPost.setImagePath("./chemin");

        Mockito.when(themeRepository.findById(1)).thenReturn(Optional.of(existingTheme));
        Mockito.when(themeRepository.findByTitleIgnoreCase("réseau")).thenReturn(Optional.empty());

        //act
        ThemeDtoGet updatedTheme = trainingService.updateTheme(1, themeDtoPost);

        //assert
        assertEquals("réseau", updatedTheme.getTitle());
        assertEquals("./chemin", updatedTheme.getImagePath());
        assertEquals(1, updatedTheme.getId());
        verify(themeRepository, times(1)).save(any(Theme.class));
    }

    @Test
    public void WhenUpdateThemeWithDuplicateTitle_ThenThrowDataIntegrityViolationException(){
        //arrange
        Theme existingTheme = Theme.builder().id(1).title("réso").imagePath("./chemin").build();
        ThemeDtoPost themeDtoPost = new ThemeDtoPost();
        themeDtoPost.setTitle("réseau");
        themeDtoPost.setImagePath("./chemin");

        Theme existingTheme2 = Theme.builder().id(2).title("réseau").build();

        Mockito.when(themeRepository.findById(1)).thenReturn(Optional.of(existingTheme));
        Mockito.when(themeRepository.findByTitleIgnoreCase("réseau")).thenReturn(Optional.of(existingTheme2));

        // act & assert
        Assertions.assertThrows(DataIntegrityViolationException.class,
                () -> trainingService.updateTheme(1, themeDtoPost));
    }

    @Test
    public void WhenUpdateThemeWithNonExistentId_ThenThrowNotFoundException() {
        //arrange
        ThemeDtoPost themeDtoPost = new ThemeDtoPost();
        themeDtoPost.setTitle("réseau");
        themeDtoPost.setImagePath("./chemin");

        Mockito.when(themeRepository.findById(1)).thenReturn(Optional.empty());

        //act & assert
        Assertions.assertThrows(NotFoundException.class,
                () -> trainingService.updateTheme(1, themeDtoPost));
    }

}
