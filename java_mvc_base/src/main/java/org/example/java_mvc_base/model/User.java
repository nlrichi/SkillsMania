package org.example.java_mvc_base.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class User {


    @Id
    private String username;

    private int leagueId;

    private String leagueTier;

    private boolean usersleagueEnded;

    private int currentStreak;

    private int overallXp;

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    public int getOverallXp() {
        return overallXp;
    }

    public void setOverallXp(int overallXp) {
        this.overallXp = overallXp;
    }

    public String getUsername() {
        return username;
    }

    public boolean isUsersleagueEnded() {
        return usersleagueEnded;
    }

    public void setUsersleagueEnded(boolean usersleagueEnded) {
        this.usersleagueEnded = usersleagueEnded;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
