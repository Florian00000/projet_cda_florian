package com.example.it_training_back;

import com.example.it_training_back.dto.subTheme.SubThemeDtoGet;
import com.example.it_training_back.dto.subTheme.SubThemeDtoPost;
import com.example.it_training_back.entity.SubTheme;
import com.example.it_training_back.entity.Theme;
import com.example.it_training_back.exception.NotFoundException;
import com.example.it_training_back.repository.SubThemeRepository;
import com.example.it_training_back.repository.ThemeRepository;
import com.example.it_training_back.service.TrainingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

public class SubThemeServiceTest {

    private TrainingService trainingService;
    private ThemeRepository themeRepository = Mockito.mock(ThemeRepository.class);
    private SubThemeRepository subThemeRepository = Mockito.mock(SubThemeRepository.class);

    @BeforeEach
    public void setUp() {
        trainingService = new TrainingService(themeRepository, subThemeRepository);
    }

    @Test
    public void WhenAddSubTheme_ThenNewSubThemeIsSaved() {
        //arrange
        SubThemeDtoPost subThemeDtoPost = new SubThemeDtoPost();
        subThemeDtoPost.setTitle("testAddSubTheme");
        subThemeDtoPost.setImagePath("testAddSubTheme");
        //subThemeDtoPost.setThemes(List.of());

        //act
        SubThemeDtoGet subThemeDtoGet = trainingService.addSubTheme(subThemeDtoPost);

        //assert
        Assertions.assertEquals("testAddSubTheme", subThemeDtoGet.getTitle());
        Assertions.assertEquals("testAddSubTheme", subThemeDtoGet.getImagePath());
        Mockito.verify(subThemeRepository, times(1)).save(any(SubTheme.class));
    }

    @Test
    public void GivenDuplicateTitle_WhenAddSubTheme_ThenThrowException(){
        //arrange
        SubThemeDtoPost subThemeDtoPost = new SubThemeDtoPost();
        subThemeDtoPost.setTitle("testAddSubTheme");
        subThemeDtoPost.setImagePath("testAddSubTheme");

        SubTheme existingSubTheme = SubTheme.builder().id(1).title("testAddSubTheme").build();
        Mockito.when(subThemeRepository.findByTitleIgnoreCase("testAddSubTheme")).thenReturn(Optional.of(existingSubTheme));

        //act and assert
        Assertions.assertThrows(DataIntegrityViolationException.class, ()->trainingService.addSubTheme(subThemeDtoPost));
    }

    @Test
    public void GivenAddSubTheme_WhenThemesHaveNonExistentId_ThenThrowNotFoundException(){
        //arrange
        SubThemeDtoPost subThemeDtoPost = new SubThemeDtoPost();
        subThemeDtoPost.setTitle("testAddSubTheme");
        subThemeDtoPost.setImagePath("testAddSubTheme");
        subThemeDtoPost.setThemes(List.of(1));

        Mockito.when(themeRepository.findById(1)).thenReturn(Optional.empty());

        //act and assert
        Assertions.assertThrows(NotFoundException.class, ()->trainingService.addSubTheme(subThemeDtoPost));
    }

    @Test
    public void GivenAddSubTheme_WhenThemesHaveExistentId_ThenReturnThemes(){
        //arrange
        SubThemeDtoPost subThemeDtoPost = new SubThemeDtoPost();
        subThemeDtoPost.setTitle("testAddSubTheme");
        subThemeDtoPost.setImagePath("testAddSubTheme");
        subThemeDtoPost.setThemes(List.of(1, 2));

        Theme theme1 = Theme.builder().id(1).title("theme1").build();
        Theme theme2 = Theme.builder().id(2).title("theme2").build();

        Mockito.when(themeRepository.findById(1)).thenReturn(Optional.of(theme1));
        Mockito.when(themeRepository.findById(2)).thenReturn(Optional.of(theme2));

        //act
        SubThemeDtoGet subThemeDtoGet = trainingService.addSubTheme(subThemeDtoPost);

        //assert
        Assertions.assertEquals(2, subThemeDtoGet.getThemes().size());
        Assertions.assertEquals("theme1", subThemeDtoGet.getThemes().get(0).getTitle());
        Assertions.assertEquals("theme2", subThemeDtoGet.getThemes().get(1).getTitle());
    }

    @Test
    public void WhenGetAllSubThemes_ThenReturnThemes(){
        //arrange
        SubTheme subTheme1 = SubTheme.builder().id(1).title("subTheme1").build();
        SubTheme subTheme2 = SubTheme.builder().id(2).title("subTheme2").build();
        List<SubTheme> subThemes = List.of(subTheme1, subTheme2);
        Mockito.when(subThemeRepository.findAll()).thenReturn(subThemes);

        //act
        List<SubThemeDtoGet> subThemeDtoGets = trainingService.getAllSubThemes();

        //assert
        Assertions.assertEquals(2, subThemeDtoGets.size());
        Assertions.assertEquals("subTheme1", subThemeDtoGets.get(0).getTitle());
        Assertions.assertEquals("subTheme2", subThemeDtoGets.get(1).getTitle());
        Mockito.verify(subThemeRepository, times(1)).findAll();
    }

    @Test
    public void WhenGetAllSubThemes_ThenReturnEmptyList(){
        //arrange
        Mockito.when(subThemeRepository.findAll()).thenReturn(new ArrayList<>());

        //act
        List<SubThemeDtoGet> subThemeDtoGets = trainingService.getAllSubThemes();

        //arrange
        Assertions.assertTrue( subThemeDtoGets.isEmpty());
        Mockito.verify(subThemeRepository, times(1)).findAll();
    }
}
