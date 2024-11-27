package com.example.it_training_back.dto.session;

import com.example.it_training_back.entity.Location;
import com.example.it_training_back.entity.Session;
import com.example.it_training_back.entity.Training;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SessionDtoGet {

    private long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate endDate;
    private int placeLimit;
    private boolean roomReserved;
    private boolean machinesInstalled;
    private boolean trainerConfirmation;
    private boolean traineesConfirmation;
    private boolean evaluationForms;

    private Location location;
    private Training training;

    private List<String> users;

    public SessionDtoGet(Session session) {
        this.id = session.getId();
        this.startDate = session.getStartDate();
        this.endDate = session.getEndDate();
        this.placeLimit = session.getPlaceLimit();
        this.roomReserved = session.isRoomReserved();
        this.machinesInstalled = session.isMachinesInstalled();
        this.trainerConfirmation = session.isTrainerConfirmation();
        this.traineesConfirmation = session.isTraineesConfirmation();
        this.evaluationForms = session.isEvaluationForms();
        this.location = session.getLocation();
        this.training = session.getTraining();
        if (session.getUsers() != null) {
            this.users = session.getUsers().stream().map(user -> user.getFirstname()+ " " + user.getLastname()).toList();
        }
    }
}
