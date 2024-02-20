package org.example.java_mvc_base.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class User {

    @Id
    private String username;

    private int finalLeaguePosition;

    private int leagueId;

    private String leagueTier;

    private boolean usersleagueEnded;

    private int currentStreak;

    private int leagueXP;

    private int overallXp;

    @OneToOne
    @JoinColumn(name = "avatar_id") // This creates a column in the User table for the Avatar ID.
    private Avatar avatar;

    // Getters and setters for all fields

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFinalLeaguePosition() {
        return finalLeaguePosition;
    }

    public void setFinalLeaguePosition(int finalLeaguePosition) {
        this.finalLeaguePosition = finalLeaguePosition;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueTier() {
        return leagueTier;
    }

    public void setLeagueTier(String leagueTier) {
        this.leagueTier = leagueTier;
    }

    public boolean isUsersleagueEnded() {
        return usersleagueEnded;
    }

    public void setUsersleagueEnded(boolean usersleagueEnded) {
        this.usersleagueEnded = usersleagueEnded;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    public int getLeagueXP() {
        return leagueXP;
    }

    public void setLeagueXP(int leagueXP) {
        this.leagueXP = leagueXP;
    }

    public int getOverallXp() {
        return overallXp;
    }

    public void setOverallXp(int overallXp) {
        this.overallXp = overallXp;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }
}

