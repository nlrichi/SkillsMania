package org.example.java_mvc_base.controller;

import org.springframework.ui.Model;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String home () {
        return "home";
    }

    @GetMapping("/securedPage")
    public String securedPage() {
        return "securedPage";
    }

    @RequestMapping("/feed")
    public String feed(){return "feed";}

    @GetMapping("/dashboard")
    @PreAuthorize("hasAuthority('SCOPE_profile')")
    public String userDetails(Model model, OAuth2AuthenticationToken token) {
        model.addAttribute("username", token.getPrincipal().getName());
        model.addAttribute("details", token.getPrincipal().getAttributes());
        model.addAttribute("principal_username",
                token.getPrincipal().getAttributes().get("given_name"));
        model.addAttribute("principal_email",
                token.getPrincipal().getAttributes().get("preferred_username"));
        return "dashboard";
    }

}
