package com.example.it_training_back.dto.session;

import com.example.it_training_back.dto.course.CourseDtoPostSession;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    private List<CourseDtoPostSession> timetables;

    private int locationID;
    private int trainingID;
}
