package com.demo.Repository;

import com.demo.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByAuthorNameContainingIgnoreCase(String authorName);
    List<Course> findByCourseNameContainingIgnoreCase(String courseName);
}
