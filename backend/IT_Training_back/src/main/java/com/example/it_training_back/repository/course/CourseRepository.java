package com.example.it_training_back.repository.course;

import com.example.it_training_back.entity.course.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
}
