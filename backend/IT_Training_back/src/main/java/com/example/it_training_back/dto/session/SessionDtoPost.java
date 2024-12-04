package com.example.it_training_back.dto.session;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class SessionDtoPost {

    private String startDate;
    private String endDate;
    private int placeLimit;
    private boolean roomReserved;
    private boolean machinesInstalled;
    private boolean trainerConfirmation;
    private boolean traineesConfirmation;
    private boolean evaluationForms;

    private int locationID;
    private int trainingID;
}
