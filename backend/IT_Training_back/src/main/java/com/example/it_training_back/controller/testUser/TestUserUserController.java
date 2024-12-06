package com.example.it_training_back.controller.testUser;

import com.example.it_training_back.dto.BaseResponseDto;
import com.example.it_training_back.dto.testUser.note.NoteDtoGet;
import com.example.it_training_back.dto.testUser.note.NoteDtoPost;
import com.example.it_training_back.service.UserToTrainingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class TestUserUserController {

    private final UserToTrainingService userToTrainingService;

    public TestUserUserController(UserToTrainingService userToTrainingService) {
        this.userToTrainingService = userToTrainingService;
    }

    @PostMapping("/note/add")
    public ResponseEntity<NoteDtoGet> addNote(@RequestBody NoteDtoPost noteDtoPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userToTrainingService.addNote(noteDtoPost));
    }

    @GetMapping("/note/{idTestUser}/userHasNote/{idUser}")
    public ResponseEntity<BaseResponseDto> userHasNote(@PathVariable long idTestUser, @PathVariable long idUser) {
        return ResponseEntity.ok(userToTrainingService.userHasNote(idUser, idTestUser));
    }
}
