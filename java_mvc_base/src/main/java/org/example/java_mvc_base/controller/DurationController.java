package org.example.java_mvc_base.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

@Controller
public class DurationController {

    @GetMapping("/start-course-page")
    public String startPage(@RequestParam("course") String course, Model model) {
        model.addAttribute("course", course);
        return "startCourse";
    }


    @PostMapping("/start-button")
    public String startCourse(@RequestParam("course") String course, HttpSession session, HttpServletResponse response) {
        session.setAttribute("startTime", Instant.now());
        System.out.println("Setting startTime in session: " + Instant.now());
        session.setAttribute("course", course);

        if (course.equals("web-developer") || course.equals("project-manager") ||
                course.equals("it-support-technician") || course.equals("cybersecurity-analyst") || course.equals("data-analyst")) {
            // Set a brief pause to allow the client-side code to open the end-course tab before redirecting
            try {
                Thread.sleep(100); // 100 milliseconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "redirect:https://skillsbuild.org/adult-learners/explore-learning/" + course;
        } else {
            // in case of invalid course ID
            return "redirect:/error-page"; // Make sure you have a view or a controller method to handle "/error-page"
        }
    }



    @PostMapping("/end-button")
    public String endCourse(HttpSession session, Model model) {
        Instant startTime = (Instant) session.getAttribute("startTime");
        if (startTime == null) {
            return "redirect:/error-page";
        }
        Instant endTime = Instant.now();
        Duration duration = Duration.between(startTime, endTime);
        long durationSeconds = duration.getSeconds(); // Get duration in seconds
        session.setAttribute("duration", durationSeconds);
        model.addAttribute("startTime", DateTimeFormatter.ISO_INSTANT.format(startTime));
        model.addAttribute("endTime", DateTimeFormatter.ISO_INSTANT.format(endTime));
        return "duration"; // Directly return the view name, assuming model attributes are accessible
    }


    @GetMapping("/show-duration")
    public String showDuration(HttpSession session, Model model) {
        Long durationSeconds = (Long) session.getAttribute("duration");
        if (durationSeconds == null) {
            return "redirect:/error-page";
        }
        model.addAttribute("duration", durationSeconds);
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

