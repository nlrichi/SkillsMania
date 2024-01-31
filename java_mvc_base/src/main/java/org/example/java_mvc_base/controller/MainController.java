package org.example.java_mvc_base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping ("/")
    public String login(){
        return "feed";
    }

    @RequestMapping("/profile")
    public String viewProfile(){
        return "dashboard";
    }

}
