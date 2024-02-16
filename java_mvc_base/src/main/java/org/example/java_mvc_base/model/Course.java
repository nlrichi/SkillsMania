package org.example.java_mvc_base.model;

import jakarta.persistence.*;
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseName;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseID) {
        this.courseId = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
