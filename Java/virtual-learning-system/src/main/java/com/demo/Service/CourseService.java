package com.demo.Service;

import com.demo.Entity.Course;
import com.demo.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepo;

    private List<Course> cart = new ArrayList<>();

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public List<Course> searchByAuthor(String author) {
        return courseRepo.findByAuthorNameContainingIgnoreCase(author);
    }

    public List<Course> searchByCourseName(String name) {
        return courseRepo.findByCourseNameContainingIgnoreCase(name);
    }

    public Course addCourse(Course c) {
        return courseRepo.save(c);
    }

    public void addToCart(Course course) {
        cart.add(course);
    }

    public void removeFromCart(Long courseId) {
        cart.removeIf(c -> c.getCourseId().equals(courseId));
    }

    public List<Course> viewCart() {
        return cart;
    }
}
