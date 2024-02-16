package org.example.java_mvc_base.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class User {
    @Id
    private String username;
    @ManyToOne
    private LeagueTable league;

    private int currentStreak;

    private int overallXp;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LeagueTable getLeague() {
        return league;
    }

    public void setLeague(LeagueTable league) {
        this.league = league;
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
}
