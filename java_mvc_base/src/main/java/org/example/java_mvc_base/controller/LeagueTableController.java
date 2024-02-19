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
        String fetched_name = (String) token.getPrincipal().getAttributes().get("given_name");
        User current_user = userRepo.findUserByUsername(fetched_name);
        if (Objects.isNull(current_user)){ //if the user is new add them to the database and set class defaults
            current_user = new User();
            current_user.setUsername(fetched_name);
            current_user.setOverallXp(0);
            current_user.setCurrentStreak(0);
            current_user = userRepo.save(current_user);
            List<LeagueTable> available_leagues = leagueRepo.findByTierNameAndDaysLeftAndMembersCountLessThan("Bronze", 7, 25);
            if (available_leagues.isEmpty()){ // if there are no available leagues for the promotes, this creates a new one of the lowest tier "Bronze"
                LeagueTable fresh_league = new LeagueTable();
                fresh_league.setTierName("Bronze");

                fresh_league = leagueRepo.save(fresh_league);
                fresh_league.getMembers().add(current_user);
                fresh_league = leagueRepo.save(fresh_league);
                current_user.setLeagueId(fresh_league.getLeagueId());
                userRepo.save(current_user);
                model.addAttribute("league", fresh_league);

            }else{

                Random random = new Random();
                int randomIndex = random.nextInt(available_leagues.size());
                LeagueTable random_select_league = available_leagues.get(randomIndex);
                random_select_league.getMembers().add(current_user);
                random_select_league.getMembers().sort(Comparator.comparingInt(User::getOverallXp));
                random_select_league = leagueRepo.save(random_select_league);
                current_user.setLeagueId(random_select_league.getLeagueId());
                userRepo.save(current_user);
                model.addAttribute("league", random_select_league);

            }

        }else{ //if the user exists, simply pull the data from the league they are in
            String logo_path;
            String tier = leagueRepo.findByLeagueId(current_user.getLeagueId()).getTierName();
            switch (tier){
                case "Artificial Champions":
                    logo_path = "A";
                    break;
                default:
                    logo_path = "K";
                    break;
            }
            if (current_user.isUsersleagueEnded()){

                //if the user's league ended since they last visited the leaderboard, they should
                //be redirected to "leagueTable/notification" to be notified
                // of their previous league outcome

                current_user.setUsersleagueEnded(false);
                int pos = current_user.getFinalLeaguePosition();
                current_user = userRepo.save(current_user);
                String suffix;
                if (Integer.toString(pos).length() == 1 || Integer.toString(pos).charAt(0) != '1'){
                    switch (Integer.toString(pos)){
                        case "1":
                            suffix = "st";
                            break;
                        case "2":
                            suffix = "nd";
                            break;
                        case "3":
                            suffix = "rd";
                            break;
                        default:
                            suffix = "th";
                    }
                }else{
                    suffix = "th";
                }
                if (current_user.getFinalLeaguePosition() <= 6) {

                    model.addAttribute("message",
                            "Congratulations! You finished " + pos + suffix +
                                    " and you were promoted to the " + tier
                                    + " league!");
                    model.addAttribute("situation", "good");

                }else if (current_user.getFinalLeaguePosition() <= 18){
                    model.addAttribute("message",
                            "Good job. You finished " + pos + suffix +
                                    " and kept your spot in the " + tier
                                    + " league");
                    model.addAttribute("situation", "good");
                }else{
                    model.addAttribute("message",
                            "Bad luck! You finished " + pos + suffix +
                                    " and you were relegated to the " + tier
                                    + " league");
                    model.addAttribute("situation", "bad");
                }
                model.addAttribute("logo", logo_path);
                return "leagueTable/notification";
            }

            LeagueTable user_league = leagueRepo.findByLeagueId(current_user.getLeagueId());
            user_league.getMembers().sort(Comparator.comparingInt(User::getOverallXp));
            model.addAttribute("league", user_league);
        }
        model.addAttribute("logged_users_uname", fetched_name);
        return "leagueTable/leagueTable";
    }
}
