package org.example.java_mvc_base.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Duration;
import java.time.Instant;

@Controller
public class DurationController {

    @GetMapping("/start-course-page")
    public String startPage(@RequestParam("course") String course, Model model) {
        model.addAttribute("course", course);
        return "startCourse";
    }

    @PostMapping("/start-button")
    public String startCourse(@RequestParam("course") String course, HttpSession session) {
        session.setAttribute("startTime", Instant.now());
        session.setAttribute("course", course);
        if (course.equals("web-developer") || course.equals("project-manager") ||
                course.equals("it-support-technician") || course.equals("cybersecurity-analyst") || course.equals("data-analyst")) {
            // Redirecting to the course page, assuming you handle the opening of endCourse.jsp in a new tab on the client side
            return "redirect:https://skillsbuild.org/adult-learners/explore-learning/" + course;
        } else {
            // in case of invalid course ID
            return "redirect:/error-page"; // Make sure you have a view or a controller method to handle "/error-page"
        }
    }

    @PostMapping("/end-button")
    public String endCourse(HttpSession session) {
        Instant startTime = (Instant) session.getAttribute("startTime");
        session.removeAttribute("startTime");
        Instant endTime = Instant.now();
        Duration duration = Duration.between(startTime, endTime);
        long durationTime = duration.getSeconds();
        session.setAttribute("duration", durationTime);
        return "redirect:/show-duration"; // Redirect to a controller method that shows the duration
    }

    @GetMapping("/show-duration")
    public String showDuration(HttpSession session, Model model) {
        Long duration = (Long) session.getAttribute("duration");
        if (duration == null) {
            return "redirect:/error-page"; // Handle missing duration case
        }
        model.addAttribute("duration", duration);
        return "duration"; // Ensure you have "durationPage.jsp" to display the duration
    }

    @GetMapping("/end-course")
    public String showEndCoursePage() {
        return "endCourse"; // Make sure "endCourse.jsp" exists under /src/main/webapp/WEB-INF/views/ or similar
    }

    // Optional: Add a method for "/error-page" if you don't have it yet
    @GetMapping("/error-page")
    public String errorPage() {
        return "errorPage"; // Ensure you have an "errorPage.jsp" view
    }
}

