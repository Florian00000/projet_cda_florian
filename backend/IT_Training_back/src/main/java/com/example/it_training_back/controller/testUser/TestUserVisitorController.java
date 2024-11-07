package com.example.it_training_back.controller.testUser;

import com.example.it_training_back.dto.testUser.TestUserDtoGet;
import com.example.it_training_back.service.TestUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestUserVisitorController {

    private final TestUserService testUserService;

    public TestUserVisitorController(TestUserService testUserService) {
        this.testUserService = testUserService;
    }

    @GetMapping("/test-user/{id}")
    public ResponseEntity<TestUserDtoGet> getTestUser(@PathVariable long id) {
        return ResponseEntity.ok(testUserService.getTestUser(id));
    }
}
