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

import java.util.*;


@Controller
public class LeagueTableController {
    @Autowired
    UserRepository userRepo;

    @Autowired
    LeagueTableRepository leagueRepo;

    @RequestMapping("/leaderboard")
    public String viewLeagueTable(Model model, OAuth2AuthenticationToken token){
        String fetched_name = token.getPrincipal().getName();
        User current_user = userRepo.findUserByUsername(fetched_name);
        if (Objects.isNull(current_user)){
            current_user = new User();
            current_user.setUsername(fetched_name);
            current_user.setOverallXp(0);
            current_user.setCurrentStreak(0);
            current_user = userRepo.save(current_user);
            List<LeagueTable> available_leagues = leagueRepo.findByTierNameAndDaysLeftAndMembersCountLessThan("Bronze", 7, 25);
            if (available_leagues.isEmpty()){
                LeagueTable fresh_league = new LeagueTable();
                fresh_league.setTierName("Bronze");
                fresh_league.setDaysLeft(7);

                fresh_league = leagueRepo.save(fresh_league);
                fresh_league.getMembers().add(current_user);
                fresh_league = leagueRepo.save(fresh_league);
                current_user.setLeague(fresh_league);
                userRepo.save(current_user);
                model.addAttribute("league", fresh_league);

            }else{

                Random random = new Random();
                int randomIndex = random.nextInt(available_leagues.size());
                LeagueTable random_select_league = available_leagues.get(randomIndex);
                random_select_league.getMembers().add(current_user);
                random_select_league.getMembers().sort(Comparator.comparingInt(User::getOverallXp));
                random_select_league = leagueRepo.save(random_select_league);
                current_user.setLeague(random_select_league);
                userRepo.save(current_user);
                model.addAttribute("league", random_select_league);

            }

        }else{
            LeagueTable user_league = current_user.getLeague();
            user_league.getMembers().sort(Comparator.comparingInt(User::getOverallXp));
            model.addAttribute("league", user_league);
        }

        return "leagueTable/leagueTable";
    }
}
