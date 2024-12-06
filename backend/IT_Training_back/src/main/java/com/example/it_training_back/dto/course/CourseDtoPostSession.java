package com.example.it_training_back.dto.course;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter @Setter
@Builder
public class CourseDtoPostSession {

    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
}
