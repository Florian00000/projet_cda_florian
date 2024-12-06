package com.example.it_training_back.dto.testUser.note;

import com.example.it_training_back.entity.testUser.Note;
import com.example.it_training_back.entity.testUser.TestUser;
import lombok.Data;

@Data
public class NoteDtoGet {

    private long id;
    private int result;
    private boolean success;
    private long userId;
    private TestUser testUser;

    public NoteDtoGet(Note note) {

        this.id = note.getId();
        this.result = note.getResult();
        this.success = note.isSuccess();
        this.userId = note.getUser().getId();
        this.testUser = note.getTestUser();
    }
}
