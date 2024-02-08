package org.example.java_mvc_base.controller;

import org.example.java_mvc_base.model.LeagueTable;
import org.example.java_mvc_base.model.User;
import org.example.java_mvc_base.repo.LeagueTableRepository;
import org.example.java_mvc_base.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LeagueTableController {
    @Autowired
    UserRepository userRepo;

    @Autowired
    LeagueTableRepository leagueRepo;

    @RequestMapping("/leaderboard")
    public String viewLeagueTable(Model model, OAuth2AuthenticationToken token){
        User current_user = userRepo.findUserByName(token.getPrincipal().getName());
        model.addAttribute("league", current_user.getLeague());
        return "leagueTable";
    }
}
