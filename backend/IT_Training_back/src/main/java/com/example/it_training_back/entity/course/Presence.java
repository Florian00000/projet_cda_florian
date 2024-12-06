package com.example.it_training_back.entity.course;

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
@NoArgsConstructor
@AllArgsConstructor
public class Presence {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presence")
    private long id;

    @Column(name = "ispresent")
    private boolean present;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonIgnore
    private Course course;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}
