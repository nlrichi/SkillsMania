package org.example.java_mvc_base.controller;

import org.example.java_mvc_base.model.Avatar;
import org.example.java_mvc_base.model.User;
import org.example.java_mvc_base.repo.AvatarRepository;
import org.example.java_mvc_base.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/avatars")
public class AvatarController {

    @Autowired
    private AvatarRepository avatarRepository;

    @Autowired
    private UserRepository userRepository;

    // Displays all avatars for selection and the current user's selected avatar.
    @GetMapping
    public String listAvatars(Model model, OAuth2AuthenticationToken token) {
        String username = (String) token.getPrincipal().getAttributes().get("given_name");
        User currentUser = userRepository.findUserByUsername(username);

        model.addAttribute("avatars", avatarRepository.findAll());
        model.addAttribute("currentAvatar", currentUser.getAvatar());
        return "avatarSelection";
    }

    // Allows the user to select an avatar and saves the selection.
    @GetMapping("/select/{id}")
    public String selectAvatar(@PathVariable("id") Long id, OAuth2AuthenticationToken token) {
        String username = (String) token.getPrincipal().getAttributes().get("given_name");
        User user = userRepository.findUserByUsername(username);
        Avatar avatar = avatarRepository.findById(id).orElse(null);
        if (user != null && avatar != null) {
            user.setAvatar(avatar);
            userRepository.save(user);
        }
        return "redirect:/avatars";
    }

}


