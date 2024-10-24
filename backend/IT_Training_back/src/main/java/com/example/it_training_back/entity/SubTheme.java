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
public class SubTheme {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subtheme")
    private int id;
    @Column(name = "title_subtheme", unique = true, nullable = false)
    private String title;
    @Column(name = "image_path")
    private String imagePath;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "theme_subtheme",
            joinColumns = @JoinColumn(name = "id_subtheme"),
            inverseJoinColumns = @JoinColumn(name = "id_theme")
    )
    @JsonIgnore
    private List<Theme> themes;
}
