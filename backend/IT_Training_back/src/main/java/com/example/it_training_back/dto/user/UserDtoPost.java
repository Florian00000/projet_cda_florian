package com.example.it_training_back.dto.user;

import com.example.it_training_back.entity.user.User;
import lombok.Data;

import java.util.List;

@Data
public class UserDtoPost {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer nbBlame;
    private String phone;
    private List<String> roles;

    public User convertToUser() {
        User user = User.builder()
                .firstname(firstName)
                .lastname(lastName)
                .email(email)
                .build();
        if (nbBlame != null ) {
            user.setNbBlame(nbBlame);
        }
        if (phone != null ) {
            user.setPhone(phone);
        }
        return user;
    }
}
