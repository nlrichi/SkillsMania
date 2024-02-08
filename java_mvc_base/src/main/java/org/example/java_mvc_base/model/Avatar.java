package org.example.java_mvc_base.model;

import jakarta.persistence.*;

@Entity
public class Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String image; // URL or path to the image file
    private String name;
    private String description;

//    @OneToOne(mappedBy = "avatar")
//    private User user;

    // Constructors, getters, and setters
    public Avatar() {}

    public Avatar(String image, String name, String description) {
        this.image = image;
        this.name = name;
        this.description = description;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
