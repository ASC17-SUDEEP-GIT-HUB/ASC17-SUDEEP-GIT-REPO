package com.demo.Entity;

import javax.persistence.*;


@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "author_name", nullable = false)
    private String authorName;

    @Column(name = "duration", nullable = false)
    private int duration; // in hours

    @Column(name = "availability", nullable = false)
    private boolean availability;

    public Course() {}

    public Course(String courseName, String authorName, int duration, boolean availability) {
        this.courseName = courseName;
        this.authorName = authorName;
        this.duration = duration;
        this.availability = availability;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
