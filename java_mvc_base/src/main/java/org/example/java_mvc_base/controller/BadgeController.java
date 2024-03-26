package org.example.java_mvc_base.controller;

import org.example.java_mvc_base.model.Badge;
import org.example.java_mvc_base.model.User;
import org.example.java_mvc_base.repo.BadgeRepository;
import org.example.java_mvc_base.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BadgeController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping ("/user/profile")
    public String viewUserProfile(OAuth2AuthenticationToken token, Model model) {
        String given_name = (String) token.getPrincipal().getAttributes().get("given_name");
        User user = userRepository.findUserByUsername(given_name);
        if (user != null) {
            userRepository.save(user);
            model.addAttribute("user", user);
            return "userProfile";
        } else {

            return "userNotFound";
        }

    }
}
