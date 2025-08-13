package com.demo.Controller;

import com.demo.Entity.Course;
import com.demo.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/search/author/{author}")
    public List<Course> searchByAuthor(@PathVariable String author) {
        return courseService.searchByAuthor(author);
    }

    @GetMapping("/search/name/{name}")
    public List<Course> searchByCourseName(@PathVariable String name) {
        return courseService.searchByCourseName(name);
    }

    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestBody Course course) {
        courseService.addToCart(course);
        return "Course added to cart";
    }

    @DeleteMapping("/cart/remove/{courseId}")
    public String removeFromCart(@PathVariable Long courseId) {
        courseService.removeFromCart(courseId);
        return "Course removed from cart";
    }

    @GetMapping("/cart")
    public List<Course> viewCart() {
        return courseService.viewCart();
    }
}
