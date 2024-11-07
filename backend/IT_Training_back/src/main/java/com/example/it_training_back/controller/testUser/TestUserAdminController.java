package com.example.it_training_back.controller.testUser;

import com.example.it_training_back.dto.testUser.TestUserDtoGet;
import com.example.it_training_back.dto.testUser.TestUserDtoPost;
import com.example.it_training_back.service.TestUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class TestUserAdminController {

    private final TestUserService testUserService;

    public TestUserAdminController(TestUserService testUserService) {
        this.testUserService = testUserService;
    }

    @PostMapping("/test-user/add")
    public ResponseEntity<TestUserDtoGet> addTestUser(@RequestBody TestUserDtoPost testUserDtoPost) {
        return ResponseEntity.ok(testUserService.addTestUser(testUserDtoPost));
    }
}
