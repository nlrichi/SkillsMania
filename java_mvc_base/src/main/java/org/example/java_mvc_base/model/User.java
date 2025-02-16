package org.example.java_mvc_base.model;


import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

import java.util.List;
import java.util.HashSet;
import java.util.Set;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    //raza comment
    @ElementCollection
    private Set<String> completedCourses = new HashSet<>();

    // Getters and setters for username and completedCourses
//raza comment
    public Set<String> getCompletedCourses() {
        return completedCourses;
    }
    //raza comment
    public void setCompletedCourses(Set<String> completedCourses) {
        this.completedCourses = completedCourses;
    }

    @Column(unique = true)
    private String username;
    private int currentStreak = 0;
    private int overallXp = 0;
    private Date lastLoggedIn = Date.valueOf(LocalDate.now());
    private int finalLeaguePosition;
    private int leagueId;
    private String leagueTier = "Bronze";
    private boolean usersleagueEnded;
    private int leagueXP = 0;
    @ManyToMany
    private List<Course> courses;
    @OneToOne
    @JoinColumn(name = "avatar_id") // This creates a column in the User table for the Avatar ID.
    private Avatar avatar;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserGoal> userGoals = new HashSet<>();

    private int totalCoin = 0; //This adds a new field totalCoins to the user entity the default value is 0.

    @OneToOne
    @JoinColumn(name = "badge_id")
    private Badge badge;

    public User() {}

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTotalCoin() {
        return totalCoin;
    }

    public void setTotalCoin(int totalCoin) {
        this.totalCoin = totalCoin;
    }


// Getters and setters for all fields


    public String getUsername() {
        return username;
    }

    public void setLastLoggedIn(Date lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
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

    public Set<UserGoal> getUserGoals() {
        return userGoals;
    }

    public void setUserGoals(Set<UserGoal> userGoals) {
        this.userGoals = userGoals;
    }

    public void addUserGoal(UserGoal userGoal) {
        userGoals.add(userGoal);
        userGoal.setUser(this);
    }

    public void removeUserGoal(UserGoal userGoal) {
        userGoals.remove(userGoal);
        userGoal.setUser(null);
    }

    public void incrementXp(int xp) {
        this.leagueXP += xp;
        this.overallXp += xp;
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

    public int getTotalCoins() {return totalCoin;}

    public void setTotalCoins(int totalCoin) {this.totalCoin = totalCoin;}
}
