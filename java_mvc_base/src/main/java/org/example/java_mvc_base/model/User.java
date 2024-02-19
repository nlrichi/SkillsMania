package org.example.java_mvc_base.model;


import jakarta.persistence.*;

@Entity
public class User {
    @Id
    private String username;
//    @ManyToOne
//    private LeagueTable league;

    @OneToOne
    @JoinColumn(name = "avatar_id") // This creates a column in the User table for the Avatar ID.
    private Avatar avatar;


    private int currentStreak;

    private int overallXp;

//    public LeagueTable getLeague() {
//        return league;
//    }
//
//    public void setLeague(LeagueTable league) {
//        this.league = league;
//    }

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

    public void setUsername(String username) {
        this.username = username;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

}
