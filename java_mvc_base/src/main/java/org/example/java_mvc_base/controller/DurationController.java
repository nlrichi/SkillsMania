package org.example.java_mvc_base.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.example.java_mvc_base.model.Course;
import org.example.java_mvc_base.model.User;
import org.example.java_mvc_base.repo.CourseRepository;
import org.example.java_mvc_base.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

import org.example.java_mvc_base.model.User;
import org.example.java_mvc_base.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.example.java_mvc_base.model.User;
import org.example.java_mvc_base.model.UserGoal;
import org.example.java_mvc_base.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import org.springframework.stereotype.Controller;
import org.example.java_mvc_base.repo.UserGoalRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.util.Objects;

import java.util.Set;


@Controller
public class DurationController {



    @Autowired
    private CourseRepository courseRepo;



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGoalRepository userGoalRepository;


    @GetMapping("/start-course-page")//
    public String startPage(@RequestParam("course") String course, Model model) {
        model.addAttribute("course", course);
        return "startCourse";
    }//when a user clicks a course link it redirects user to the start course page


    @PostMapping("/start-button")// this is what happens when the user clicks the start course button

    public String startCourse(@RequestParam("course") String course, HttpSession session, OAuth2AuthenticationToken token) {
        // Record start time and store start time in session
        session.setAttribute("startTime", Instant.now());
        System.out.println("Setting startTime in session: " + Instant.now());
        session.setAttribute("course", course);
        // Redirect to actual course page
        if (course.equals("web-developer") || course.equals("project-manager") ||
                course.equals("it-support-technician") || course.equals("cybersecurity-analyst") || course.equals("data-analyst")) {


            //find the course which has the target endpoint as its link
            String raw_endpoint = "/start-course-page?course=";
            Course target_course_object = courseRepo.findByLink(raw_endpoint + course);

            String fetched_name = (String) token.getPrincipal().getAttributes().get("given_name");
            User current_user = userRepository.findUserByUsername(fetched_name);
            if (Objects.isNull(current_user)){
                current_user = new User();
                current_user.setUsername(fetched_name);
                current_user = userRepository.save(current_user);
            }

            //Engage the course and the user in a many-to-many relationship if the
            // user isn't already in the course's list of takers

            if (! target_course_object.getCourseTakers().contains(current_user)){
                target_course_object.getCourseTakers().add(current_user);
                current_user.getCourses().add(target_course_object);
                courseRepo.save(target_course_object);
                userRepository.save(current_user);
            }

            // Set a brief pause to allow the client-side code to open the end-course tab before redirecting
            try {
                Thread.sleep(100); // 100 milliseconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "redirect:https://skillsbuild.org/adult-learners/explore-learning/" + course;// redirect to the course page following ibm skillbuild url format
        } else {
            // in case of invalid course ID
            return "redirect:/error-page";
        }
    }



    @PostMapping("/end-button")//this is what happens when a user clicks the end course button






    public String endCourse(HttpSession session, Model model, OAuth2AuthenticationToken token) {

        String username = (String) token.getPrincipal().getAttributes().get("given_name");
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            return "redirect:/error-page";
        }


        // Retrieve start time from session
        Instant startTime = (Instant) session.getAttribute("startTime");
        if (startTime == null) {
            return "redirect:/error-page";
        }
        // Record end time
        Instant endTime = Instant.now();
        // Calculate duration
        Duration duration = Duration.between(startTime, endTime);
        long durationSeconds = duration.getSeconds(); // Get duration in seconds
        session.setAttribute("duration", durationSeconds);
        model.addAttribute("startTime", DateTimeFormatter.ISO_INSTANT.format(startTime));//format start and end time
        model.addAttribute("endTime", DateTimeFormatter.ISO_INSTANT.format(endTime));





        //raza comment
        //String username = (String) session.getAttribute("username");
        User loggedInUser = userRepository.findUserByUsername(username);

        // Retrieve logged-in user from session
        //User loggedInUser = (User) session.getAttribute("loggedInUser");

        // Check if logged-in user is null
        if (loggedInUser == null) {
            // Handle case when user is not logged in
            return "redirect:/error-page";
        }
        String completedCourse = (String) session.getAttribute("course");

        //raza comment
        Set<String> completedCourses = loggedInUser.getCompletedCourses();
        completedCourses.add((String) session.getAttribute("course"));
        loggedInUser.setCompletedCourses(completedCourses);
        userRepository.save(loggedInUser);


        List<UserGoal> activeGoals = userGoalRepository.findByUserAndIsCompleted(user, false);
        for (UserGoal userGoal : activeGoals) {
            updateGoalProgress(userGoal);
        }


        return "duration"; // Directly return the view name, assuming model attributes are accessible
    }

    private void updateGoalProgress(UserGoal userGoal) {
        // Increment progress
        userGoal.incrementProgress(); // This method needs to be added to UserGoal to manage progress

        // Check if the goal is completed
        if (userGoal.getProgress() >= userGoal.getGoal().getTargetCount()) {
            userGoal.setIsCompleted(true);
            userGoal.getUser().incrementXp(userGoal.getGoal().getXpReward()); // Increment XP for the user
            userRepository.save(userGoal.getUser());
            System.out.println("XP GIVEN. NOW EQUALS " + userGoal.getUser().getOverallXp());
        }

        userGoalRepository.save(userGoal);
    }


    @GetMapping("/show-duration")//after a user completes a course they are redirected to the duration page if duration time is not null
    public String showDuration(HttpSession session, Model model) {
        Long durationSeconds = (Long) session.getAttribute("duration");
        if (durationSeconds == null) {
            //handle missing start time
            return "redirect:/error-page";
        }
        model.addAttribute("duration", durationSeconds);
        return "duration";
    }


    //mapping request for when the end course button is clicked, it redirects to endCourse.jsp
    @GetMapping("/end-course")
    public String showEndCoursePage() {
        return "endCourse";
    }

    // mapping to display error-page whenever an error occurs
    @GetMapping("/error-page")
    public String errorPage() {
        return "errorPage";
    }
}

