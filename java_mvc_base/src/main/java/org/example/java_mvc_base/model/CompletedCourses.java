package org.example.java_mvc_base.model;

import jakarta.persistence.*;

// a link table between users and courses that represent all the courses completed for that user
@Entity
public class CompletedCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int completedCoursedId;
    private int secondsElapsed; // time taken to do the course
    private int score; // how well they scored on the test
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "course_id")
    private Course course; // the course that was taken
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private User user; // the user that took the course

    // getters and setters

    public int getCompletedCoursedId() {
        return completedCoursedId;
    }

    public void setCompletedCoursedId(int completedCoursedId) {
        this.completedCoursedId = completedCoursedId;
    }

    public int getSecondsElapsed() {
        return secondsElapsed;
    }

    public void setSecondsElapsed(int secondsElapsed) {
        this.secondsElapsed = secondsElapsed;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
