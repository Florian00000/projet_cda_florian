package com.example.it_training_back.entity;

import com.example.it_training_back.entity.course.Course;
import com.example.it_training_back.entity.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Session {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_session")
    private long id;
    @Column(name = "start_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate endDate;
    @Column(name = "place_limit")
    private int placeLimit;
    @Column(name = "room_reserved")
    private boolean roomReserved;
    @Column(name = "machines_installed")
    private boolean machinesInstalled;
    @Column(name = "trainer_confirmation")
    private boolean trainerConfirmation;
    @Column(name = "trainees_confirmation")
    private boolean traineesConfirmation;
    @Column(name = "evaluation_forms")
    private boolean evaluationForms;

    @ManyToOne
    @JoinColumn(name = "location_id")
    @JsonIgnore
    private Location location;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "training_id")
    @JsonIgnore
    private Training training;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Course> courses;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "user_session")
    @JsonIgnore
    private List<User> users;
}
