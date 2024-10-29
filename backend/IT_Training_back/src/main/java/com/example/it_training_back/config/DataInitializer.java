package com.example.it_training_back.config;

import com.example.it_training_back.dto.subTheme.SubThemeDtoPost;
import com.example.it_training_back.dto.theme.ThemeDtoPost;
import com.example.it_training_back.service.ThemeService;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

//@Component
public class DataInitializer implements CommandLineRunner {

    private final ThemeService themeService;
    Random rand = new Random();

    public DataInitializer(ThemeService themeService) {
        this.themeService = themeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        //fake themes
        for (int i = 0; i < 5; i++) {
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
    }
}
