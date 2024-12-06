package com.example.it_training_back.controller;

import com.example.it_training_back.dto.BaseResponseDto;
import com.example.it_training_back.dto.user.UserDtoPost;
import com.example.it_training_back.dto.user.UserLoginDto;
import com.example.it_training_back.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<BaseResponseDto> registerUser(@RequestBody UserDtoPost userDtoPost) {
        if (userService.createUser(userDtoPost)) {
            Map<String, String> data = new HashMap<>();
            long id = userService.getIdByEmail(userDtoPost.getEmail());
            data.put("token", userService.generateJwtToken(userDtoPost.getEmail(), userDtoPost.getPassword(), id));
            return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResponseDto("User registered successfully", data));
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDto("User could not be registered"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponseDto> loginUser(@RequestBody UserLoginDto userDtoPost) {
        if (userService.checkUserNameExists(userDtoPost.getEmail())) {

            if (userService.verifyUserPassword(userDtoPost.getEmail(), userDtoPost.getPassword())) {
                Map<String, String> data = new HashMap<>();
                long id = userService.getIdByEmail(userDtoPost.getEmail());
                data.put("token", userService.generateJwtToken(userDtoPost.getEmail(), userDtoPost.getPassword(), id));
               return ResponseEntity.status(HttpStatus.OK).body(new BaseResponseDto("User logged successfully", data));
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new BaseResponseDto("invalid email or password"));
    }


}
