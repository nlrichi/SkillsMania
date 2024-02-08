package org.example.java_mvc_base.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationController {

    @RequestMapping("/authorization-code/callback")
    public String redirectLogin(OAuth2AuthenticationToken token){
        return "redirect:/feed";
    }

}
