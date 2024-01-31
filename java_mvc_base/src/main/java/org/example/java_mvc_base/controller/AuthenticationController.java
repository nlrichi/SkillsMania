package org.example.java_mvc_base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationController {

    @RequestMapping("success-login")
    public String redirectLogin(){
        return "redirect:/feed";
    }
}
