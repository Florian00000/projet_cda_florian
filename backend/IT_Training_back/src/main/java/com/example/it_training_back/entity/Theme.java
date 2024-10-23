package com.example.it_training_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Theme {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_theme")
    private int id;

    @Column(unique = true, nullable = false)
    private String title;
    @Column(name = "image_path")
    private String imagePath;

    @ManyToMany(mappedBy = "themes")
    @JsonIgnore
    private List<SubTheme> subThemes;
}
