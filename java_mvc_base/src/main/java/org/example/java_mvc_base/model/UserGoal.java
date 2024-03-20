package org.example.java_mvc_base.model;

import jakarta.persistence.*;

@Entity
public class UserGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userGoalId;

    private int progress = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goalId")
    private Goal goal;

    private boolean isCompleted = false;

    public UserGoal() {}

    // Getters and Setters

    public int getUserGoalId() {
        return userGoalId;
    }

    public void setUserGoalId(int userGoalId) {
        this.userGoalId = userGoalId;
    }

    public User getUser() {
        return user;
    }

    public void incrementProgress() {
        this.progress++;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }
    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}

