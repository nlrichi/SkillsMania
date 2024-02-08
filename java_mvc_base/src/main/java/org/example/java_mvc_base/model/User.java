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



    public LeagueTable getLeague() {
        return league;
    }

    public void setLeague(LeagueTable league) {
        this.league = league;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
