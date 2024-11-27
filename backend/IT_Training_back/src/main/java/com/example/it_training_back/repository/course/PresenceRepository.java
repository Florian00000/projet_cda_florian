package com.example.it_training_back.repository.course;

import com.example.it_training_back.entity.course.Presence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PresenceRepository extends CrudRepository<Presence, Long> {

}
