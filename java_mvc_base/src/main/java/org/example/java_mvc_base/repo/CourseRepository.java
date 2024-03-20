package org.example.java_mvc_base.repo;

import org.example.java_mvc_base.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
    Course findByCourseName(String courseName);

    Course findByLink(String link);
}
