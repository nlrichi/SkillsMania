package org.example.java_mvc_base.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Duration;
import java.time.Instant;

@Controller
public class DurationController {

    @GetMapping("/start-course-page")
    public String startPage(@RequestParam("course") String course) {
        return "startCourse";
    }//this is what happens when a user clicks a course link it redirects user to start page with button


    @PostMapping("/start-course")// this is what happens when the user clicks the start course button
    public String startCourse(@RequestParam("course") String course, HttpSession session) {
        try {
            // Record start time and store start time in session
            session.setAttribute("startTime", Instant.now());
            session.setAttribute("course",course);
            // Redirect to actual course page
            if (course.equals("web-developer") || course.equals("project-manager") ||
                    course.equals("it-support-technician") || course.equals("cybersecurity-analyst") || course.equals("data-analyst")) {
                // Construct the URL of the endCourse.jsp page
                String endCourseUrl = "/endCourse.jsp";
                // Construct the JavaScript to open the endCourse.jsp page in a new tab/window
                String script = "<script>window.open('" + endCourseUrl + "', '_blank');</script>";
                // Return the script along with the redirect to the actual course page
                return "redirect:https://skillsbuild.org/adult-learners/explore-learning/" + course + script;
            }else {
                //in case of invalid course ID
                return "error-page";
            }
        } catch (Exception e) {
            // Handle errors (e.g., invalid course ID)
            return "error-page";
        }
    }


    @PostMapping("/end-course")//this is what happens when a user clicks the end course button
    public String endCourse(HttpSession session) {
        try {
            // Retrieve start time from session
            Instant startTime = (Instant) session.getAttribute("startTime");
            session.removeAttribute("startTime");  // Remove start time from session

            // Record end time
            Instant endTime = Instant.now();

            // Calculate duration
            Duration duration = Duration.between(startTime, endTime);
            long durationTime = duration.getSeconds();

            session.setAttribute("duration", durationTime);

            return "redirect:/duration";//redirects user to the page that shows the duration of the course
        } catch (Exception e) {
            // Handle errors
            return "error-page";
        }
    }

}
