package org.example.java_mvc_base.controller;

import org.example.java_mvc_base.model.DurationTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;

@Controller
public class DurationController {
    private String courseUrl;
    private DurationTracker durationTracker;
    //Constructor to instantiate durationTracker
    public DurationController(){
        this.durationTracker = new DurationTracker();
    }

    public void startCourse(String originalUrl){
        this.courseUrl = courseUrl;
    }
    public String saveStartTime(Instant startTime){
        DurationTracker session = new DurationTracker();
        session.setStartTime(startTime);
        return "redirect:/startCourse";
    }



    public String saveEndTime(Instant endTime){
        DurationTracker session = new DurationTracker();
        session.setEndTime(endTime);
        return "redirect:/endCourse";
    }
}
