package com.example.it_training_back.dto.testUser.note;
import lombok.Data;

@Data
public class NoteDtoPost {

    private int result;
    private boolean success;

    private long userId;
    private long testUserId;


}
