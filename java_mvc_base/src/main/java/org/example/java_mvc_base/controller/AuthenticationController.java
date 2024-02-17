package org.example.java_mvc_base.controller;

import org.example.java_mvc_base.model.User;
import org.example.java_mvc_base.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
public class AuthenticationController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping("/authorization-code/callback")
    public String redirectLogin(OAuth2AuthenticationToken token){
        String name = (String) token.getPrincipal().getAttributes().get("given_name");
        User logged_in_user = userRepository.findUserByUsername(name);
        if (Objects.isNull(logged_in_user)){
            User new_user = new User();
            new_user.setUsername(name);
            userRepository.save(new_user);
        } else {
            logged_in_user.setLastLoggedIn();
            userRepository.save(logged_in_user);
        }
        return "redirect:/feed";
    }

}
