package org.example.java_mvc_base.model;

import jakarta.persistence.*;

@Entity
public class CompletedCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int completedCoursedId;
    private int secondsElapsed;
    private int score;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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
