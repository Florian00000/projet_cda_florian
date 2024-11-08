package com.example.it_training_back.dto.location;

import com.example.it_training_back.entity.Location;
import com.example.it_training_back.entity.Session;
import lombok.Data;

import java.util.List;

@Data
public class LocationDtoGet {

    private int id;
    private String street;
    private String number;
    private String city;
    private int zipCode;

    private List<Session> sessions;

    public LocationDtoGet(Location location) {
        this.id = location.getId();
        this.street = location.getStreet();
        this.number = location.getNumber();
        this.city = location.getCity();
        this.zipCode = location.getZipCode();
        this.sessions = location.getSessions();
    }
}
