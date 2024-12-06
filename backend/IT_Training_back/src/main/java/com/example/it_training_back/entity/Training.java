package com.example.it_training_back.entity;

import com.example.it_training_back.entity.testUser.TestUser;
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
public class Training {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_training")
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;
    private double price;
    @Column(nullable = false)
    private boolean inter;
    @Column(name = "image_path")
    private String imagePath;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "training_subtheme",
            joinColumns = @JoinColumn(name = "id_training"),
            inverseJoinColumns = @JoinColumn(name = "id_subtheme")
    )
    @JsonIgnore
    private List<SubTheme> subThemes;

    @OneToMany(mappedBy = "training", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Session> sessions;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_test_user")
    @JsonIgnore
    private TestUser testUser;
}
