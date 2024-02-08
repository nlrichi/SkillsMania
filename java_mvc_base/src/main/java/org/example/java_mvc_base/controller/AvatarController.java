package org.example.java_mvc_base.controller;

import org.example.java_mvc_base.repo.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/avatars")
public class AvatarController {

    @Autowired
    private AvatarRepository avatarRepository;

    @GetMapping
    public String listAvatars(Model model) {
        model.addAttribute("avatars", avatarRepository.findAll());
        return "avatarSelection";
    }
}

