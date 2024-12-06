package com.example.it_training_back.entity.testUser;

import com.example.it_training_back.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "result_test")
    private int result;

    private boolean success;

    @ManyToOne()
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User user;

    @ManyToOne()
    @JoinColumn(name = "id_test_user")
    @JsonIgnore
    private TestUser testUser;
}
