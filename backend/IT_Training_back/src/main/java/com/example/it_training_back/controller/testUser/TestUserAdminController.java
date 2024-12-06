package com.example.it_training_back.controller.testUser;

import com.example.it_training_back.dto.testUser.TestUserDtoGet;
import com.example.it_training_back.dto.testUser.TestUserDtoPost;
import com.example.it_training_back.dto.training.TrainingDtoGet;
import com.example.it_training_back.service.TestUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class TestUserAdminController {

    private final TestUserService testUserService;

    public TestUserAdminController(TestUserService testUserService) {
        this.testUserService = testUserService;
    }

    @PostMapping("/test-user/add")
    public ResponseEntity<TestUserDtoGet> addTestUser(@RequestBody TestUserDtoPost testUserDtoPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(testUserService.addTestUser(testUserDtoPost));
    }

    @GetMapping("/test-user/get-all")
    public ResponseEntity<List<TestUserDtoGet>> getAllTestUser() {
        return ResponseEntity.status(HttpStatus.OK).body(testUserService.getAllTestUsers());
    }

    @PatchMapping("/test-user/{idTestUser}/test-training/{idTraining}")
    public ResponseEntity<TrainingDtoGet> addTestToTraining(@PathVariable long idTestUser, @PathVariable int idTraining) {
        return ResponseEntity.ok(testUserService.addTestToTraining(idTestUser, idTraining));
    }
}
