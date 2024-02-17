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
    private int avatar = 0;
    private Date lastLoggedIn = Date.valueOf(LocalDate.now());
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
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
