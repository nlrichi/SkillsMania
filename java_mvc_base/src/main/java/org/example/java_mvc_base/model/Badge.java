package org.example.java_mvc_base.model;

import jakarta.persistence.*;


@Entity
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private String iconPath; // URL or path to the badge icon image

    @OneToOne(mappedBy = "badge")
    private User user;

    public Badge(){}

    public Badge(String iconPath, String name, String description, Boolean isLeader) {
        this.iconPath = iconPath;
        this.name = name;
        this.description = description;

    }

    //Getter and Setter methods


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}

