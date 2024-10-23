package com.example.it_training_back.repository;

import com.example.it_training_back.entity.Theme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThemeRepository extends CrudRepository<Theme, Integer> {
    Optional<Theme> findByTitleIgnoreCase(String title);
}
