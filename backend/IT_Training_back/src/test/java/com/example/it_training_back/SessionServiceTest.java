package com.example.it_training_back;

import com.example.it_training_back.dto.session.SessionDtoGet;
import com.example.it_training_back.dto.session.SessionDtoPost;
import com.example.it_training_back.entity.Location;
import com.example.it_training_back.entity.Session;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class SessionServiceTest {

    private TrainingService trainingService;
    private final TrainingRepository trainingRepository = Mockito.mock(TrainingRepository.class);
    private final LocationRepository locationRepository = Mockito.mock(LocationRepository.class);
    private final SessionRepository sessionRepository = Mockito.mock(SessionRepository.class);
    private final SubThemeRepository subThemeRepository = Mockito.mock(SubThemeRepository.class);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @BeforeEach
    public void setUp() {
        trainingService = new TrainingService(trainingRepository, locationRepository, sessionRepository, subThemeRepository);
    }

    @Test
    public void GivenAddSession_thenSaveSession() {
        //arrange
        SessionDtoPost sessionDtoPost = SessionDtoPost.builder()
                .startDate("01/01/2025")
                .endDate("01/03/2025")
                .placeLimit(20)
                .roomReserved(false)
                .machinesInstalled(false)
                .trainerConfirmation(false)
                .traineesConfirmation(false)
                .evaluationForms(true)
                .locationID(1)
                .trainingID(1)
                .build();
        Mockito.when(locationRepository.findById(1)).thenReturn(Optional.of(Location.builder().id(1).build()));
        Training training = Training.builder().id(1).build();
        Mockito.when(trainingRepository.findById(1)).thenReturn(Optional.of(training));

        //act
        SessionDtoGet result = trainingService.addSession(sessionDtoPost);

        //assert
        Mockito.verify(sessionRepository, Mockito.times(1)).save(Mockito.any(Session.class));
        Assertions.assertEquals(LocalDate.parse("01/01/2025", formatter), result.getStartDate());
        Assertions.assertEquals(LocalDate.parse("01/03/2025", formatter), result.getEndDate());
        Assertions.assertEquals(20, result.getPlaceLimit());
        Assertions.assertFalse(result.isRoomReserved());
        Assertions.assertFalse(result.isMachinesInstalled());
        Assertions.assertFalse(result.isTrainerConfirmation());
        Assertions.assertFalse(result.isTraineesConfirmation());
        Assertions.assertTrue(result.isEvaluationForms());
        Assertions.assertEquals(1, result.getTraining().getId());
        Assertions.assertEquals(1, result.getLocation().getId());
    }

    @Test
    public void GivenAddSession_WhenLocationHaveNonExistantId_ThenThrowException() {
        //arrange
        SessionDtoPost sessionDtoPost = SessionDtoPost.builder()
                .startDate("01/01/2025")
                .endDate("01/03/2025")
                .locationID(1)
                .build();
        Mockito.when(locationRepository.findById(1)).thenReturn(Optional.empty());

        //assert & equals
        Assertions.assertThrows(NotFoundException.class, () -> trainingService.addSession(sessionDtoPost));
    }

    @Test
    public void GivenAddSession_WhenTrainingHaveNonExistantId_ThenThrowException() {
        //arrange
        SessionDtoPost sessionDtoPost = SessionDtoPost.builder()
                .startDate("01/01/2025")
                .endDate("01/03/2025")
                .trainingID(1)
                .build();
        Mockito.when(trainingRepository.findById(1)).thenReturn(Optional.empty());

        //assert & equals
        Assertions.assertThrows(NotFoundException.class, () -> trainingService.addSession(sessionDtoPost));
    }

    @Test
    public void GivenAddSession_WhenEndDateBeforeStartDate_ThenThrowException() {
        //arrange
        SessionDtoPost sessionDtoPost = SessionDtoPost.builder()
                .startDate("01/03/2025")
                .endDate("01/01/2025")
                .trainingID(1)
                .build();
        Mockito.when(trainingRepository.findById(1)).thenReturn(Optional.of(Training.builder().id(1).build()));

        //act & assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> trainingService.addSession(sessionDtoPost));
    }

    @Test
    public void GivenAddSession_WhenPlaceLimitUnder3_ThenThrowException() {
        //arrange
        SessionDtoPost sessionDtoPost = SessionDtoPost.builder()
                .startDate("01/01/2025")
                .endDate("01/03/2025")
                .placeLimit(2)
                .trainingID(1)
                .build();
        Mockito.when(trainingRepository.findById(1)).thenReturn(Optional.of(Training.builder().id(1).build()));

        //act & assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> trainingService.addSession(sessionDtoPost));
    }

    @Test
    public void GivenGetSessionsByTrainingID_WhenTrainingHaveNonExistantId_ThenThrowException() {
        //arrange
        Mockito.when(trainingRepository.findById(1)).thenReturn(Optional.empty());

        //act & assert
        Assertions.assertThrows(NotFoundException.class, () -> trainingService.getSessionsByTrainingID(1));
    }

    @Test
    public void GivenGetSessionsByTrainingID_ThenReturnSessions() {
        //arrange
        Session session1 = Session.builder().id(1).build();
        Session session2 = Session.builder().id(2).build();
        Mockito.when(trainingRepository.findById(1)).thenReturn(Optional.of(Training.builder().id(1).build()));
        Mockito.when(sessionRepository.findAllByTrainingId(1)).thenReturn(List.of(session1, session2));

        //act
        List<SessionDtoGet> result = trainingService.getSessionsByTrainingID(1);

        //assert
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.stream().anyMatch(s -> s.getId() == 1));
        Assertions.assertTrue(result.stream().anyMatch(s -> s.getId() == 2));
    }

    @Test
    public void GivenGetSessionsByTrainingID_ThenReturnEmptyList(){
        //arrange
        Mockito.when(trainingRepository.findById(1)).thenReturn(Optional.of(Training.builder().id(1).build()));
        Mockito.when(sessionRepository.findAllByTrainingId(1)).thenReturn(List.of());

        //act
        List<SessionDtoGet> result = trainingService.getSessionsByTrainingID(1);

        //assert
        Assertions.assertTrue(result.isEmpty());
        Mockito.verify(sessionRepository, Mockito.times(1)).findAllByTrainingId(1);
    }
}
