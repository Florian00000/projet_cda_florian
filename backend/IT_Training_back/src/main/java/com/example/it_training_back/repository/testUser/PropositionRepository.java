package com.example.it_training_back.repository.testUser;

import com.example.it_training_back.entity.Proposition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropositionRepository extends CrudRepository<Proposition, Long> {
}
