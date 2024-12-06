package com.example.it_training_back.controller.testUser;

import com.example.it_training_back.dto.testUser.TestUserDtoGet;
import com.example.it_training_back.dto.testUser.proposition.PropositionDtoGet;
import com.example.it_training_back.dto.testUser.question.QuestionDtoGet;
import com.example.it_training_back.service.TestUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visitor")
public class TestUserVisitorController {

    private final TestUserService testUserService;

    public TestUserVisitorController(TestUserService testUserService) {
        this.testUserService = testUserService;
    }

    @GetMapping("/test-user/{id}")
    public ResponseEntity<TestUserDtoGet> getTestUser(@PathVariable long id) {
        return ResponseEntity.ok(testUserService.getTestUser(id));
    }

    @GetMapping("/test-user/question/{id}")
    public ResponseEntity<QuestionDtoGet> getQuestion(@PathVariable long id) {
        return ResponseEntity.ok(testUserService.getQuestion(id));
    }

    @GetMapping("/test-user/proposition/{id}")
    public ResponseEntity<PropositionDtoGet> getProposition(@PathVariable long id) {
        return ResponseEntity.ok(testUserService.getProposition(id));
    }
}
