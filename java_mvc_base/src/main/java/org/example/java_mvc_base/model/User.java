package org.example.java_mvc_base.model;


import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(unique = true)
    private String username;
    private int currentStreak = 0;
    private int overallXp = 0;
    private Date lastLoggedIn = Date.valueOf(LocalDate.now());
    private int finalLeaguePosition;
    private int leagueId;
    private String leagueTier;
    private boolean usersleagueEnded;
    private int leagueXP;
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

    public Date getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn() {
        LocalDate today = LocalDate.now();
        LocalDate dayAfterLastLogin = this.lastLoggedIn.toLocalDate().plusDays(1);

        if (today.equals(dayAfterLastLogin)) {
            this.setCurrentStreak(this.currentStreak + 1);
        } else if (today.isAfter(dayAfterLastLogin)) {
            this.setCurrentStreak(0);
        }
        this.lastLoggedIn = Date.valueOf(LocalDate.now());
    }
}
