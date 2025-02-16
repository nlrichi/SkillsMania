package org.example.java_mvc_base.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

// represents the different choices in multiple choice questions
@Entity
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int choiceId;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question; // the question that the choice belongs to
    private String choiceText; // what the choice will say
    private boolean isTrue; // true if the choice is correct for the question

    // getters and setters

    public int getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(int choiceId) {
        this.choiceId = choiceId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }

    public boolean getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }
}
