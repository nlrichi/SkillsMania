package org.example.java_mvc_base.controller;

import org.example.java_mvc_base.model.Goal;
import org.example.java_mvc_base.model.User;
import org.example.java_mvc_base.model.UserGoal;
import org.example.java_mvc_base.repo.GoalRepository;
import org.example.java_mvc_base.repo.UserGoalRepository;
import org.example.java_mvc_base.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GoalRepository goalRepository;
    @Autowired
    private UserGoalRepository userGoalRepository;

    @PostMapping("/setGoal")
    public String setGoal(@RequestParam Long goalId, Principal principal, RedirectAttributes redirectAttributes) {
        String username = principal.getName(); // Assuming the username is the same as the principal name
        User user = userRepository.findUserByUsername(username);

        Goal selectedGoal = goalRepository.findById((goalId))
                .orElseThrow(() -> new RuntimeException("Goal not found"));

        UserGoal userGoal = new UserGoal();
        userGoal.setUser(user);
        userGoal.setGoal(selectedGoal);
        userGoal.setCompleted(false); // Initially, the goal is not completed
        userGoalRepository.save(userGoal);

        return "redirect:/users/" + username + "/goals"; // Redirect to the page showing the user's goals
    }


    @GetMapping("/{username}/goals")
    public String listUserGoals(@PathVariable String username, Model model) {
        User user = userRepository.findUserByUsername(username);
        List<UserGoal> userGoals = userGoalRepository.findByUser(user);
        model.addAttribute("userGoals", userGoals);
        return "user-goals";
    }
}


