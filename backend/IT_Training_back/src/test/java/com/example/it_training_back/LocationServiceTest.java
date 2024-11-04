package com.example.it_training_back;

import com.example.it_training_back.dto.location.LocationDtoGet;
import com.example.it_training_back.dto.location.LocationDtoPost;
import com.example.it_training_back.entity.Location;
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

public class LocationServiceTest {

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
    public void GivenAddLocation_ThenSaveLocation() {
        //arrange
        LocationDtoPost locationDtoPost = LocationDtoPost.builder().street("street").number("5")
                .city("city").zipCode(5).build();

        //act
        LocationDtoGet result = trainingService.addLocation(locationDtoPost);

        //assert
        Mockito.verify(locationRepository, Mockito.times(1)).save(Mockito.any(Location.class));
        Assertions.assertEquals("street", result.getStreet());
        Assertions.assertEquals("5", result.getNumber());
        Assertions.assertEquals("city", result.getCity());
        Assertions.assertEquals(5, result.getZipCode());
    }

    @Test
    public void GivenGetAllLocations_ThenReturnAllLocations() {
        //arrange
        Location location1 = Location.builder().id(1).build();
        Location location2 = Location.builder().id(2).build();
        List<Location> locations = List.of(location1, location2);
        Mockito.when(locationRepository.findAll()).thenReturn(locations);

        //act
        List<LocationDtoGet> result = trainingService.getAllLocations();

        Mockito.verify(locationRepository, Mockito.times(1)).findAll();
        Assertions.assertTrue(result.stream().anyMatch(l -> l.getId() == 1));
        Assertions.assertTrue(result.stream().anyMatch(l -> l.getId() == 2));
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void GivenGetAllLocations_ThenReturnEmptyList() {
        //arrange
        Mockito.when(locationRepository.findAll()).thenReturn(List.of());

        //act
        List<LocationDtoGet> result = trainingService.getAllLocations();

        //assert
        Assertions.assertTrue(result.isEmpty());
        Mockito.verify(locationRepository, Mockito.times(1)).findAll();
    }
}
