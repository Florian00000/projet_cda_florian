package com.example.it_training_back.repository.testUser;

import com.example.it_training_back.entity.testUser.TestUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUserRepository extends CrudRepository<TestUser, Long> {
}
