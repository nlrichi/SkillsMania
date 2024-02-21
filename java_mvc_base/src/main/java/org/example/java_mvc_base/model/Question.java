package org.example.java_mvc_base.model;

import jakarta.persistence.*;

import java.util.List;
// represents the questions of a course
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course; // the course the questions are part of
    private String questionText; // the question that will be displayed
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Choice> choices; // the different answer for the multiple choice questions

    // getters and setters
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
