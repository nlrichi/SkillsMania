package org.example.java_mvc_base.controller;

import org.example.java_mvc_base.model.Goal;
import org.example.java_mvc_base.repo.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/goals")
public class GoalController {

    @Autowired
    private GoalRepository goalRepository;

    @GetMapping("/list")
    public String listGoals(Model model, OAuth2AuthenticationToken token) {
        List<Goal> goals = StreamSupport.stream(goalRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        model.addAttribute("goals", goals);

        String username = (String) token.getPrincipal().getAttributes().get("given_name");
        model.addAttribute("username", username);
        return "list-goals"; // The path to the JSP file inside /WEB-INF/views
    }

}

