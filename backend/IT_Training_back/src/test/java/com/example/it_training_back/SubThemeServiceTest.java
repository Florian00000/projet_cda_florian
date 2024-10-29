package com.example.it_training_back;

import com.example.it_training_back.dto.subTheme.SubThemeDtoGet;
import com.example.it_training_back.dto.subTheme.SubThemeDtoPost;
import com.example.it_training_back.entity.SubTheme;
import com.example.it_training_back.entity.Theme;
import com.example.it_training_back.exception.NotFoundException;
import com.example.it_training_back.repository.SubThemeRepository;
import com.example.it_training_back.repository.ThemeRepository;
import com.example.it_training_back.service.ThemeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

public class SubThemeServiceTest {

    private ThemeService themeService;
    private ThemeRepository themeRepository = Mockito.mock(ThemeRepository.class);
    private SubThemeRepository subThemeRepository = Mockito.mock(SubThemeRepository.class);

    @BeforeEach
    public void setUp() {
        themeService = new ThemeService(themeRepository, subThemeRepository);
    }

    @Test
    public void WhenAddSubTheme_ThenNewSubThemeIsSaved() {
        //arrange
        SubThemeDtoPost subThemeDtoPost = new SubThemeDtoPost();
        subThemeDtoPost.setTitle("testAddSubTheme");
        subThemeDtoPost.setImagePath("testAddSubTheme");
        //subThemeDtoPost.setThemes(List.of());

        //act
        SubThemeDtoGet subThemeDtoGet = themeService.addSubTheme(subThemeDtoPost);

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
        Assertions.assertThrows(DataIntegrityViolationException.class, ()-> themeService.addSubTheme(subThemeDtoPost));
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
        Assertions.assertThrows(NotFoundException.class, ()-> themeService.addSubTheme(subThemeDtoPost));
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
        SubThemeDtoGet subThemeDtoGet = themeService.addSubTheme(subThemeDtoPost);

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
        List<SubThemeDtoGet> subThemeDtoGets = themeService.getAllSubThemes();

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
        List<SubThemeDtoGet> subThemeDtoGets = themeService.getAllSubThemes();

        //arrange
        Assertions.assertTrue( subThemeDtoGets.isEmpty());
        Mockito.verify(subThemeRepository, times(1)).findAll();
    }

    @Test
    public void GivenRemoveSubTheme_WhenNonExistantId_ThenThrowNotFoundException(){
        //arrange
        Mockito.when(subThemeRepository.findById(1)).thenReturn(Optional.empty());

        //act & arrange
        Assertions.assertThrows(NotFoundException.class, ()-> themeService.deleteSubTheme(1));
    }

    @Test
    public void GivenRemoveSubTheme_WhenExistantId_ThenRemoveSubTheme(){
        //arrange
        SubTheme existingSubTheme = SubTheme.builder().id(1).title("testAddSubTheme").build();
        Mockito.when(subThemeRepository.findById(1)).thenReturn(Optional.of(existingSubTheme));

        //act
        themeService.deleteSubTheme(1);

        //assert
        Mockito.verify(subThemeRepository, times(1)).delete(existingSubTheme);
        Mockito.when(subThemeRepository.findById(1)).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, ()-> themeService.deleteTheme(1));
    }

    @Test
    public void WhenDeleteSubTheme_ThenSubThemeIsRemoveButThemesAreNot(){
        //arrange
        Theme theme1 = Theme.builder().id(1).title("Theme 1").build();
        Theme theme2 = Theme.builder().id(2).title("Theme 2").build();

        SubTheme subTheme = SubTheme.builder().id(1).title("SubTheme").themes(List.of(theme1, theme2)).build();
        Mockito.when(subThemeRepository.findById(1)).thenReturn(Optional.of(subTheme));

        //act
        themeService.deleteSubTheme(1);

        Mockito.verify(themeRepository, never()).delete(theme1);
        Mockito.verify(themeRepository, never()).delete(theme2);
    }

    @Test
    public void WhenSubUpdateThemeWithValidData_ThenSubThemeIsUpdated(){
        //arrange
        SubTheme existingSubTheme = SubTheme.builder().id(1).title("SubTheme").build();
        SubThemeDtoPost subThemeDtoPost = new SubThemeDtoPost();
        subThemeDtoPost.setTitle("testUpdateSubTheme");
        subThemeDtoPost.setImagePath("testUpdateSubTheme");

        Mockito.when(subThemeRepository.findById(1)).thenReturn(Optional.of(existingSubTheme));
        Mockito.when(subThemeRepository.findByTitleIgnoreCase("testUpdateSubTheme")).thenReturn(Optional.empty());

        //act
        SubThemeDtoGet subThemeDtoGet = themeService.updateSubTheme(1, subThemeDtoPost);

        //assert
        Assertions.assertEquals("testUpdateSubTheme", subThemeDtoGet.getTitle());
        Assertions.assertEquals("testUpdateSubTheme", subThemeDtoGet.getImagePath());
        Assertions.assertEquals(1, subThemeDtoGet.getId());
        Mockito.verify(subThemeRepository, times(1)).save(any(SubTheme.class));
    }

    @Test
    public void WhenUpdateSubThemeWithDuplicateTitle_ThenThrowDataIntegrityViolationException(){
        //arrange
        SubTheme existingSubTheme1 = SubTheme.builder().id(1).title("SubTheme").build();
        SubThemeDtoPost subThemeDtoPost = new SubThemeDtoPost();
        subThemeDtoPost.setTitle("testUpdateSubTheme");
        SubTheme existingSubTheme2 = SubTheme.builder().id(2).title("testUpdateSubTheme").build();

        Mockito.when(subThemeRepository.findById(1)).thenReturn(Optional.of(existingSubTheme1));
        Mockito.when(subThemeRepository.findByTitleIgnoreCase("testUpdateSubTheme")).thenReturn(Optional.of(existingSubTheme2));

        //act & assert
        Assertions.assertThrows(DataIntegrityViolationException.class, ()-> themeService.updateSubTheme(1, subThemeDtoPost));
    }

    @Test
    public void WhenUpdateSubThemeWithNonExistentId_ThenThrowNotFoundException(){
        //arrange
        SubThemeDtoPost subThemeDtoPost = new SubThemeDtoPost();
        subThemeDtoPost.setTitle("testUpdateSubTheme");
        Mockito.when(subThemeRepository.findById(1)).thenReturn(Optional.empty());

        //act & assert
        Assertions.assertThrows(NotFoundException.class, ()-> themeService.updateSubTheme(1, subThemeDtoPost));
    }

    @Test
    public void WhenUpdateSubTheme_ThenSubThemeIsUpdatedWithNewThemes() {
        //arrange
        SubTheme existingSubTheme = SubTheme.builder()
                .id(1).title("SubTheme")
                .themes(List.of(Theme.builder().id(1).title("theme1").build(),
                        Theme.builder().id(2).title("theme2").build()))
                .build();
        SubThemeDtoPost subThemeDtoPost = new SubThemeDtoPost();
        subThemeDtoPost.setTitle("testUpdateSubTheme");
        subThemeDtoPost.setThemes(List.of(3,4));

        Mockito.when(subThemeRepository.findById(1)).thenReturn(Optional.of(existingSubTheme));
        Mockito.when(subThemeRepository.findByTitleIgnoreCase("testUpdateSubTheme")).thenReturn(Optional.empty());
        Mockito.when(themeRepository.findById(3)).thenReturn(Optional.of(Theme.builder().id(3).title("theme3").build()));
        Mockito.when(themeRepository.findById(4)).thenReturn(Optional.of(Theme.builder().id(4).title("theme4").build()));

        //act
        SubThemeDtoGet subThemeDtoGet = themeService.updateSubTheme(1, subThemeDtoPost);

        //assert
        List<Theme> updatedThemes = subThemeDtoGet.getThemes();
        Assertions.assertEquals(2, updatedThemes.size());
        Assertions.assertTrue(updatedThemes.stream().anyMatch(t -> t.getId() == 3));
        Assertions.assertTrue(updatedThemes.stream().anyMatch(t -> t.getId() == 4));
    }

    @Test
    public void GivenUpdateSubTheme_WhenNonExistantIdForThemes_ThenThrowNotFoundException() {
        //arrange
        SubTheme existingSubTheme = SubTheme.builder()
                .id(1).title("SubTheme")
                .themes(List.of(Theme.builder().id(1).title("theme1").build(),
                        Theme.builder().id(2).title("theme2").build()))
                .build();
        SubThemeDtoPost subThemeDtoPost = new SubThemeDtoPost();
        subThemeDtoPost.setTitle("testUpdateSubTheme");
        subThemeDtoPost.setThemes(List.of(3));

        Mockito.when(subThemeRepository.findById(1)).thenReturn(Optional.of(existingSubTheme));
        Mockito.when(subThemeRepository.findByTitleIgnoreCase("testUpdateSubTheme")).thenReturn(Optional.empty());
        Mockito.when(themeRepository.findById(3)).thenReturn(Optional.empty());

        //act & assert
        Assertions.assertThrows(NotFoundException.class, ()-> themeService.updateSubTheme(1, subThemeDtoPost));
    }

    @Test
    public void GivenGetAllSubThemesByThemeId_WhenNonExistantIdForThemes_ThenThrowNotFoundException() {
        //arrange
        int themeId = 1;
        Mockito.when(themeRepository.findById(themeId)).thenReturn(Optional.empty());

        //act & assert
        Assertions.assertThrows(NotFoundException.class, ()-> themeService.getAllSubThemesByThemeId(themeId));
    }

    @Test
    public void GivenGetAllSubThemesByThemeId_WhenNoRelationsForThemes_ThenReturnEmptyList() {
        //arrange
        int themeId = 1;
        Theme theme = Theme.builder().id(1).title("theme1").build();
        Mockito.when(themeRepository.findById(themeId)).thenReturn(Optional.of(theme));
        Mockito.when(subThemeRepository.findAllByThemes(List.of(theme))).thenReturn(List.of());

        //act
        List<SubThemeDtoGet> result = themeService.getAllSubThemesByThemeId(themeId);

        //assert
        Assertions.assertTrue(result.isEmpty());
        Mockito.verify(subThemeRepository, Mockito.times(1)).findAllByThemes(List.of(theme));
    }

    @Test
    public void GivenGetAllSubThemesByThemeId_WhenRelationsForThemes_ThenReturnThemes(){
        //arrange
        int themeId = 1;
        Theme theme = Theme.builder().id(1).title("theme1").build();
        SubTheme subTheme1 = SubTheme.builder().id(2).title("subTheme1").build();
        SubTheme subTheme2 = SubTheme.builder().id(3).title("subTheme2").build();
        Mockito.when(themeRepository.findById(themeId)).thenReturn(Optional.of(theme));
        Mockito.when(subThemeRepository.findAllByThemes(List.of(theme))).thenReturn(List.of(subTheme1, subTheme2));

        //act
        List<SubThemeDtoGet> result = themeService.getAllSubThemesByThemeId(themeId);

        //assert
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.stream().anyMatch(t -> t.getId() == 2));
        Assertions.assertTrue(result.stream().anyMatch(t -> t.getId() == 3));
        Mockito.verify(subThemeRepository, Mockito.times(1)).findAllByThemes(List.of(theme));
    }
}
