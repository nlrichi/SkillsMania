package org.example.java_mvc_base.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class LeagueTable {

    @Id
    private int leagueId;

    private String tier_name;

    private LocalDate LastCheckedDate = LocalDate.now();

    @OneToMany
    private List<User> members;

    private int days_left = 7;


    public LeagueTable() {

    }

    public LocalDate getLastCheckedDate() {
        return LastCheckedDate;
    }

    public void setLastCheckedDate() {
        LastCheckedDate = LocalDate.now();
    }

    public String getTier_name() {
        return tier_name;
    }

    public void setTier_name(String tier_name) {
        this.tier_name = tier_name;
    }

    public int getDays_left() {
        return days_left;
    }

    public void setDays_left(int days_left) {
        this.days_left = days_left;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int league_id) {
        this.leagueId = league_id;
    }

    public List<User> getMembers() {
        if (Objects.isNull(members)){
            members = new ArrayList<User>();
        }
        return members;
    }


    public void setMembers(List<User> members) {
        this.members = members;
    }
}

