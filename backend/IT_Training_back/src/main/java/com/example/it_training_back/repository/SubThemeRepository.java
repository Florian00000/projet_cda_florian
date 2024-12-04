package com.example.it_training_back.repository;

import com.example.it_training_back.entity.SubTheme;
import com.example.it_training_back.entity.Theme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubThemeRepository extends CrudRepository<SubTheme, Integer> {
    Optional<SubTheme> findByTitleIgnoreCase(String title);
    List<SubTheme> findAllByThemes(List<Theme> themes);
}
