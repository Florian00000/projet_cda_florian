package com.example.it_training_back.dto.testUser.proposition;

import com.example.it_training_back.entity.Proposition;
import lombok.Data;

@Data
public class PropositionDtoGet {

    private long id;
    private String option;

    public PropositionDtoGet(Proposition proposition) {
        this.id = proposition.getId();
        this.option = proposition.getOption();
    }
}
