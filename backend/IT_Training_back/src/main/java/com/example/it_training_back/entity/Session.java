package com.example.it_training_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Session {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_session")
    private long id;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
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

    @ManyToOne
    @JoinColumn(name = "training_id")
    @JsonIgnore
    private Training training;
}
