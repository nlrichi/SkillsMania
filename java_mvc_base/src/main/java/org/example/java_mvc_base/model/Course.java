package org.example.java_mvc_base.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Question> questions;
    @Column(unique = true)
    private String courseName;

    private String pic;

    @ManyToMany(mappedBy = "courses", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<User> courseTakers;

    @Column(unique = true)
    private String link;

    public Course(){}

    public String getLink() {
        return link;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Course(String courseName, String coursePic, String courseLink){
        this.courseName = courseName;
        this.pic = coursePic;
        this.link = courseLink;
    }
    public int getPopularity(){
        return courseTakers.size();
    }
    public List<User> getCourseTakers() {
        if (Objects.isNull(courseTakers)){
            courseTakers = new ArrayList<>();
        }
        return courseTakers;
    }

    public void setCourseTakers(List<User> courseTakers) {
        this.courseTakers = courseTakers;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseID) {
        this.courseId = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
