package org.example.java_mvc_base.controller;
//relevant imports as needed
import org.example.java_mvc_base.model.User;
import org.example.java_mvc_base.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

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
    private UserRepository userRepository;
    //Dashboard controller, this uses OAuth2 Token which is made when signing up to the SkillsMania
    //to retrieve info such as the username, email etc. Returns the dashboard JSP as requested.
    @GetMapping("/dashboard")
    @PreAuthorize("hasAuthority('SCOPE_profile')")
    public String userDetails(Model model, OAuth2AuthenticationToken token) {

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
        model.addAttribute("streak", loggedInUser.getCurrentStreak());
        model.addAttribute("username", token.getPrincipal().getName());
        model.addAttribute("details", token.getPrincipal().getAttributes());
        model.addAttribute("principal_username",
                token.getPrincipal().getAttributes().get("given_name"));
        model.addAttribute("principal_email",
                token.getPrincipal().getAttributes().get("preferred_username"));
        return "dashboard";
    }

}
