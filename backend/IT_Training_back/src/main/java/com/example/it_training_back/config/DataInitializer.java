package com.example.it_training_back.config;

import com.example.it_training_back.dto.location.LocationDtoPost;
import com.example.it_training_back.dto.session.SessionDtoPost;
import com.example.it_training_back.dto.subTheme.SubThemeDtoPost;
import com.example.it_training_back.dto.theme.ThemeDtoPost;
import com.example.it_training_back.dto.training.TrainingDtoPost;
import com.example.it_training_back.entity.Location;
import com.example.it_training_back.entity.user.Role;
import com.example.it_training_back.service.ThemeService;
import com.example.it_training_back.service.TrainingService;
import com.example.it_training_back.service.UserService;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

//@Component
public class DataInitializer implements CommandLineRunner {

    private final ThemeService themeService;
    private final TrainingService trainingService;
    private final UserService userService;
    Random rand = new Random();

    public DataInitializer(ThemeService themeService, TrainingService trainingService, UserService userService) {
        this.themeService = themeService;
        this.trainingService = trainingService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        //fake themes
        /*for (int i = 0; i < 5; i++) {
            ThemeDtoPost themeDtoPost = new ThemeDtoPost();
            themeDtoPost.setTitle(faker.book().title());
            themeDtoPost.setImagePath(faker.file().fileName("/images", null, "png", "/"));
            themeService.addTheme(themeDtoPost);
        }

        //fake subthemes
        for (int i = 0; i < 5; i++) {
            SubThemeDtoPost subThemeDtoPost = new SubThemeDtoPost();
            subThemeDtoPost.setTitle(faker.twinPeaks().character());
            subThemeDtoPost.setImagePath(faker.file().fileName("/images", null, "png", "/"));

            //choix d'un theme au hasard
            int id = themeService.getAllThemes()
                    .get(rand.nextInt(themeService.getAllThemes().size())).getId();

            subThemeDtoPost.setThemes(List.of(id));
            themeService.addSubTheme(subThemeDtoPost);
        }

        //fake training
        for (int i = 0; i < 5; i++) {
            TrainingDtoPost trainingDtoPost = TrainingDtoPost.builder()
                    .title(faker.dune().character())
                    .description(faker.lorem().paragraph())
                    .price(faker.number().randomDouble(2, 0, 10000))
                    .inter(true)
                    .imagePath(faker.file().fileName("/images", null, "png", "/"))
                    .build();
            int id = themeService.getAllSubThemes().get(rand.nextInt(themeService.getAllSubThemes().size())).getId();
            trainingDtoPost.setSubThemes(List.of(id));
            trainingService.addTraining(trainingDtoPost);
        }


        //fake Location
        for (int i = 0; i < 5; i++) {
            LocationDtoPost locationDtoPost = LocationDtoPost.builder()
                    .street(faker.address().streetAddress())
                    .number(Integer.toString( rand.nextInt(50)))
                    .city(faker.address().city())
                    .zipCode(rand.nextInt(60000))
                    .build();
            trainingService.addLocation(locationDtoPost);
        }



        //fake Session
        for (int i = 0; i < 5; i++) {
            SessionDtoPost sessionDtoPost = SessionDtoPost.builder()
                    .startDate("01/0"+ (i+1) + "/2025")
                    .endDate("01/0"+ (i+2) + "/2025")
                    .placeLimit(rand.nextInt(3,30))
                    .roomReserved(false).machinesInstalled(false).traineesConfirmation(false)
                    .trainerConfirmation(false).traineesConfirmation(false).evaluationForms(false)
                    .build();
            int idLocation = trainingService.getAllLocations()
                    .get(rand.nextInt(trainingService.getAllLocations().size())).getId();
            sessionDtoPost.setLocationID(idLocation);
            int idTraining = trainingService.getAllTrainings()
                    .get(rand.nextInt(trainingService.getAllTrainings().size())).getId();
            sessionDtoPost.setTrainingID(idTraining);
            trainingService.addSession(sessionDtoPost);
        }



        //ROLE
        userService.createRole(Role.builder().role("ROLE_USER").build());
        userService.createRole(Role.builder().role("ROLE_TRAINER").build());
        userService.createRole(Role.builder().role("ROLE_ADMIN").build());

         */
    }
}
