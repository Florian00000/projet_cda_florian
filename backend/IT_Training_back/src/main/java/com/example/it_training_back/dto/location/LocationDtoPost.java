package com.example.it_training_back.dto.location;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Builder
public class LocationDtoPost {

    private String street;
    private String number;
    private String city;
    private int zipCode;
}
