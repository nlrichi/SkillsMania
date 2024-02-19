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
    UserRepository u_repo;




    @RequestMapping("/authorization-code/callback")
    public String redirectLogin(OAuth2AuthenticationToken token){
        String username = (String) token.getPrincipal().getAttributes().get("given_name");
        User currentUser = u_repo.findUserByUsername(username);
        if (Objects.isNull(currentUser)){
            User newUser = new User();
            newUser.setUsername(username);
            // Set any default or fetched values for the new user
            u_repo.save(newUser);
            // Optionally set the newUser as the currentUser in the session or security context here
        }
        return "redirect:/feed";
    }



}

