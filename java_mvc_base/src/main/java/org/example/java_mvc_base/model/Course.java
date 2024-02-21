package org.example.java_mvc_base.model;

import jakarta.persistence.*;

import java.util.List;

// represents the different courses
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Question> questions; // the questions that belong to this course
    @Column(unique = true)
    private String courseName; // name of the course

    // getters and setters

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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
