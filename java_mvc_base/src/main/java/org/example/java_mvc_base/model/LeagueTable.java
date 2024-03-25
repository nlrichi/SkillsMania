package org.example.java_mvc_base.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
public class LeagueTable {


    @GeneratedValue
    @Id
    private int leagueId;

    private String tierName; //Tiers -> "Kings Intelligence", "Artificial Champions", "Bronze" in order

    private LocalDate LastCheckedDate = LocalDate.of(2024, 02, 13); //test area

    @JoinColumn
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    private List<User> members = new ArrayList<User>(); //league has a list of member users competing

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

        members.sort(Comparator.comparingInt(User::getLeagueXP).reversed());
        //The user on top of the leaderboard is given a crown to highlight that they're in the lead
        if(members.get(0).getAvatar().getImage().equals("/images/Avatar1.png")) {
            members.get(0).getAvatar().setImage("/images/Avatar1_Leader.png");
        }
        else if (members.get(0).getAvatar().getImage().equals("/images/Avatar2.png")) {
            members.get(0).getAvatar().setImage("/images/Avatar2_leader.png");
        }
        else if (members.get(0).getAvatar().getImage().equals("/images/Avatar3.png")) {
            members.get(0).getAvatar().setImage("/images/Avatar3_Leader.png");
        }
        return members;
    }


    public LeagueTable(LocalDate date){
        LastCheckedDate = date;
    }

    public int getMembersCount() {
        return membersCount;
    }

    public void setMembers(List<User> members) {
        this.members = members;
        this.membersCount = members.size();
    }
}

