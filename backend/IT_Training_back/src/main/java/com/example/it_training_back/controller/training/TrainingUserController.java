package com.example.it_training_back.controller.training;

import com.example.it_training_back.dto.BaseResponseDto;
import com.example.it_training_back.dto.session.SessionDtoGet;
import com.example.it_training_back.service.UserToTrainingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class TrainingUserController {

    private final UserToTrainingService userToTrainingService;

    public TrainingUserController(UserToTrainingService userToTrainingService) {
        this.userToTrainingService = userToTrainingService;
    }

    @PatchMapping("/register/{userId}/session/{sessionId}")
    public ResponseEntity<BaseResponseDto> registerUserToSession(@PathVariable long userId, @PathVariable long sessionId) {
        boolean result = userToTrainingService.addUserToSession(userId, sessionId);
        if (result){
            return ResponseEntity.ok(new BaseResponseDto("User registered successfully to Session", true));
        }else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDto("User not registered to Session", false));
    }

    @GetMapping("/registered/{userId}/session/{sessionId}")
    public ResponseEntity<BaseResponseDto> userHasRegisteredToSession(@PathVariable long userId, @PathVariable long sessionId) {
        boolean result = userToTrainingService.userHasRegisteredToSession(userId, sessionId);
        if (result){
            return ResponseEntity.ok(new BaseResponseDto("User has registered to Session", true));
        }else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDto("User not registered to Session", false));
    }

    @GetMapping("/session/byUser/{idUser}")
    public ResponseEntity<List<SessionDtoGet>> userHasRegisteredToSession(@PathVariable long idUser) {
        return ResponseEntity.ok(userToTrainingService.getAllSessionByUserID(idUser));
    }
}
