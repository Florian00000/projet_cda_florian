package com.example.it_training_back.repository.course;

import com.example.it_training_back.entity.Session;
import com.example.it_training_back.entity.course.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAllBySession(Session session);
}
