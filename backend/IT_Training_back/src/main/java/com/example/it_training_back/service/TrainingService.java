package com.example.it_training_back.service;

import com.example.it_training_back.dto.training.TrainingDtoGet;
import com.example.it_training_back.dto.training.TrainingDtoPost;
import com.example.it_training_back.entity.SubTheme;
import com.example.it_training_back.entity.Training;
import com.example.it_training_back.exception.NotFoundException;
import com.example.it_training_back.repository.LocationRepository;
import com.example.it_training_back.repository.SessionRepository;
import com.example.it_training_back.repository.SubThemeRepository;
import com.example.it_training_back.repository.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;
    private final LocationRepository locationRepository;
    private final SessionRepository sessionRepository;
    private final SubThemeRepository subThemeRepository;

    public TrainingService(TrainingRepository trainingRepository, LocationRepository locationRepository,
                           SessionRepository sessionRepository, SubThemeRepository subThemeRepository) {
        this.trainingRepository = trainingRepository;
        this.locationRepository = locationRepository;
        this.sessionRepository = sessionRepository;
        this.subThemeRepository = subThemeRepository;
    }

    //============================= Training =============================

    public TrainingDtoGet addTraining(TrainingDtoPost trainingDtoPost) {
        Training training = Training.builder().title(trainingDtoPost.getTitle())
                .description(trainingDtoPost.getDescription())
                .price(trainingDtoPost.getPrice())
                .inter(trainingDtoPost.isInter())
                .imagePath(trainingDtoPost.getImagePath())
                .build();
        if (trainingDtoPost.getSubThemes() != null && !trainingDtoPost.getSubThemes().isEmpty()) {
            List<SubTheme> subThemeList = updateSubThemesOfTraining(trainingDtoPost.getSubThemes());
            training.setSubThemes(subThemeList);
        }
        trainingRepository.save(training);
        return new TrainingDtoGet(training);
    }

    public List<TrainingDtoGet> getAllTrainingsBySubThemeId(int subThemeId){
        SubTheme subThemeInData = subThemeRepository.findById(subThemeId).orElseThrow(() -> new NotFoundException("SubTheme with id " + subThemeId + " not found"));
        List<Training> trainings = trainingRepository.findAllBySubThemes(List.of(subThemeInData));
        return trainings.stream().map(TrainingDtoGet::new).toList();
    }

    private List<SubTheme> updateSubThemesOfTraining(List<Integer> subThemesId){
        List<SubTheme> subThemeList = new ArrayList<>();
        for (Integer idSubTheme: subThemesId){
            SubTheme subTheme = subThemeRepository.findById(idSubTheme).orElseThrow(() -> new NotFoundException("SubTheme with id " + idSubTheme + " not found"));
            subThemeList.add(subTheme);
        }
        return subThemeList;
    }
}
