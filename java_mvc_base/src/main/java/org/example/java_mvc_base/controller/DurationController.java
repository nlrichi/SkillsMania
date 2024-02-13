package org.example.java_mvc_base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DurationController {

    @GetMapping("/course-start")
    public String startPage() {
        return "startCourse";
    }

    @PostMapping("/start-course")
    public String startCourse(@RequestParam String courseId, RedirectAttributes redirectAttrs) {
        try {
            // Record start time
            long startTime = System.currentTimeMillis();

            // Store start time in session
            session.setAttribute("startTime", startTime);

            // Redirect to actual course page
            return "redirect:https://skillsbuild.org/course/" + courseId;
        } catch (Exception e) {
            // Handle errors (e.g., invalid course ID)
            return "error-page";
        }
    }

    @GetMapping("/course-end")
    public String endPage() {
        long startTime = (long) session.getAttribute("startTime");
        if (startTime == 0) {
            // Handle missing start time
            return "error-page";
        }
        return "endCourse";
    }

    @PostMapping("/end-course")
    public String endCourse() {
        try {
            // Retrieve start time from session
            long startTime = (long) session.getAttribute("startTime");
            session.removeAttribute("startTime");  // Remove start time from session

            // Record end time
            long endTime = System.currentTimeMillis();

            // Calculate duration
            long duration = endTime - startTime;

            return "course-result";
        } catch (Exception e) {
            // Handle errors
            return "error-page";
        }
    }

}
