package org.example.java_mvc_base.controller;
//relevant imports as needed

import org.example.java_mvc_base.model.Course;
import jakarta.servlet.http.HttpSession;
import org.example.java_mvc_base.model.User;
import org.example.java_mvc_base.repo.CourseRepository;
import org.example.java_mvc_base.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Controller
public class WebController {
    //controller to return home when fist being launched
    @GetMapping("/")
    public String home () {
        return "home";
    }

    //controller to return the securedPage which then redirects to the Dashboard
    @GetMapping("/securedPage")
    public String securedPage() {
        return "securedPage";
    }

    @Autowired
    private CourseRepository c_repo;
    @Autowired
    private UserRepository userRepository;
    //Dashboard controller, this uses OAuth2 Token which is made when signing up to the SkillsMania
    //to retrieve info such as the username, email etc. Returns the dashboard JSP as requested.
    @GetMapping("/dashboard")
    @PreAuthorize("hasAuthority('SCOPE_profile')")
    public String userDetails(Model model, OAuth2AuthenticationToken token, HttpSession session) {


        String name = (String) token.getPrincipal().getAttributes().get("given_name");
        User loggedInUser = userRepository.findUserByUsername(name);
        if (Objects.isNull(loggedInUser)) {
            loggedInUser = new User();
            loggedInUser.setUsername(name);
            userRepository.save(loggedInUser);
        } else {
            loggedInUser.setLastLoggedIn();
            userRepository.save(loggedInUser);
        }

        // Set loggedInUser into the session
        session.setAttribute("loggedInUser", loggedInUser);

        model.addAttribute("streak", loggedInUser.getCurrentStreak());
        model.addAttribute("username", token.getPrincipal().getName());
        model.addAttribute("details", token.getPrincipal().getAttributes());
        model.addAttribute("principal_username",
                token.getPrincipal().getAttributes().get("given_name"));
        model.addAttribute("principal_email",
                token.getPrincipal().getAttributes().get("preferred_username"));
        model.addAttribute("totalCoin", loggedInUser.getTotalCoins());

        List<Course> courses = (List<Course>) c_repo.findAll();
        courses.sort(Comparator.comparingInt(Course::getPopularity));
        model.addAttribute("courses", courses);
        // Calculate the percentage of completed courses for the logged-in user
        // and add it to the model attribute
        double completionPercentage = calculateCompletionPercentage(loggedInUser);
        model.addAttribute("completionPercentage", completionPercentage);


        return "dashboard";
    }
    // function to calculate the completion percentage of courses for a user
    private double calculateCompletionPercentage(User user) {
        Set<String> completedCourses = user.getCompletedCourses(); //retrieve the completed courses of the user
        int totalCourses = 5; // as we have 5 courses in total
        int completedCount = completedCourses.size(); //retrieve count of completed courses
        return (double) completedCount / totalCourses * 100; //calculate and return the % of completion
    }

}
