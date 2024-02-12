package org.example.java_mvc_base.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class LeagueTable {

    @GeneratedValue
    @Id
    private int leagueId;

    private String tierName; //Tiers -> "Kings Intelligence", "Artificial champions", "Bronze"

    private LocalDate LastCheckedDate = LocalDate.now();

    @OneToMany
    private List<User> members;

    private int daysLeft = 7;

    private int membersCount;


    public LeagueTable() {

    }

    public LocalDate getLastCheckedDate() {
        return LastCheckedDate;
    }

    public void setLastCheckedDate() {
        LastCheckedDate = LocalDate.now();
    }

    public String getTierName() {
        return tierName;
    }

    public void setTierName(String tier_name) {
        this.tierName = tier_name;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int days_left) {
        this.daysLeft = days_left;
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

    public int getMembersCount() {
        return membersCount;
    }

    public void setMembers(List<User> members) {
        this.members = members;
        this.membersCount = members.size();
    }
}

