package org.example.java_mvc_base.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goalId;
    private String description;
    private String goalType; // e.g., "daily", "weekly", "once"
    private int targetCount;
    private int xpReward; // XP to be rewarded upon goal completion

    public Goal() {}

    public Goal(String description, String goalType, int targetCount, int xpReward) {
        this.description = description;
        this.goalType = goalType;
        this.targetCount = targetCount;
        this.xpReward = xpReward;
    }

    // Getters and Setters
    public Long getGoalId() { return goalId; }
    public void setGoalId(Long goalId) { this.goalId = goalId; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getGoalType() { return goalType; }
    public void setGoalType(String goalType) { this.goalType = goalType; }
    public int getTargetCount() { return targetCount; }
    public void setTargetCount(int targetCount) { this.targetCount = targetCount; }
    public int getXpReward() { return xpReward; }
    public void setXpReward(int xpReward) { this.xpReward = xpReward; }
}




