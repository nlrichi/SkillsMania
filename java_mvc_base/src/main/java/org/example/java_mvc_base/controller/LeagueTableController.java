package org.example.java_mvc_base.controller;

import org.example.java_mvc_base.model.LeagueTable;
import org.example.java_mvc_base.model.User;
import org.example.java_mvc_base.repo.LeagueTableRepository;
import org.example.java_mvc_base.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
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
        if (Objects.isNull(current_user)){ //if the user is new, add them to the database and set class defaults
            current_user = new User();
            current_user.setUsername(fetched_name);
            current_user.setOverallXp(0);
            current_user.setCurrentStreak(0);
            current_user.setLeagueXP(2000);
            current_user = userRepo.save(current_user);
            current_user = findNewLeague(model, current_user);
            current_user = userRepo.save(current_user);

        } else { //if the user exists, simply pull the data from the league they are in
            LeagueTable user_league = leagueRepo.findByLeagueId(current_user.getLeagueId());
            if (user_league == null) {
                // Handle the scenario where the league is not found
                current_user = findNewLeague(model, current_user);

                current_user = userRepo.save(current_user);
                user_league = leagueRepo.findByLeagueId(current_user.getLeagueId());
                current_user.setLeagueXP(2000);
                current_user = userRepo.save(current_user);
                user_league = leagueRepo.findByLeagueId(current_user.getLeagueId());
            } else if (current_user.isUsersleagueEnded()) {
                current_user.setUsersleagueEnded(false);
                current_user = userRepo.save(current_user);
                String prefix;
                String pos = Integer.toString(current_user.getFinalLeaguePosition());
                if (pos.length() == 1 || pos.charAt(0) != '1'){
                    switch (current_user.getFinalLeaguePosition()){
                        case 1:
                            prefix = "st";
                            break;
                        case 2:
                            prefix = "nd";
                            break;
                        case 3:
                            prefix = "rd";
                            break;
                        default:
                            prefix = "th";
                    }
                }else {
                    prefix = "4th";
                }

                String logo_path;

                switch (current_user.getLeagueTier()){
                    case "Kings Intelligence":
                        logo_path = "K";
                        break;
                    default:
                        logo_path = "A";
                        break;

                }
                String promotion_tier;

                switch (current_user.getLeagueTier()) { // promotion selection based on which tier the league is
                    case "Bronze":
                        promotion_tier = "Artificial Champions";
                        break;
                    case "Artificial Champions":
                        promotion_tier = "Kings Intelligence";
                        break;
                    default:
                        promotion_tier = "Kings Intelligence";
                        break;
                }

                if (current_user.getFinalLeaguePosition() <= 6){
                    model.addAttribute("situation", "good");
                    model.addAttribute("logo", logo_path);
                    String message = "Congratulations! You finished " + pos + prefix + " and got" +
                            " promoted to the " + promotion_tier + " league";
                    model.addAttribute("message", message);
                }
                else{
                    model.addAttribute("situation", "bad");
                    model.addAttribute("logo", logo_path);
                    String message = "Bad luck! You finished " + pos + prefix + " and got" +
                            " promoted to the " + current_user.getLeagueTier() + " league";
                    model.addAttribute("message", message);
                }
                return "notification";

            }
            // Proceed with existing logic if league is found
            user_league.getMembers().sort(Comparator.comparingInt(User::getOverallXp));
            model.addAttribute("league", user_league);
        }

        model.addAttribute("logged_users_uname", fetched_name);
        model.addAttribute("currentAvatar", current_user.getAvatar());
        model.addAttribute("principal_username",
                token.getPrincipal().getAttributes().get("given_name"));
        return "leagueTable"; // Make sure this is the correct view name for your leaderboard
    }

    public User findNewLeague(Model model, User current_user){
        List<LeagueTable> available_leagues = leagueRepo.findByTierNameAndDaysLeftAndMembersCountLessThan("Bronze", 7, 25);
        if (available_leagues.isEmpty()){ // if there are no available leagues, this creates a new one of the lowest tier "Bronze"
            LeagueTable fresh_league = new LeagueTable();
            fresh_league.setTierName("Bronze");
            fresh_league = leagueRepo.save(fresh_league);
            fresh_league.getMembers().add(current_user);
            fresh_league = leagueRepo.save(fresh_league);
            current_user.setLeagueId(fresh_league.getLeagueId());

            current_user.setLeagueTier(fresh_league.getTierName());

            current_user = userRepo.save(current_user);
            model.addAttribute("league", fresh_league);
        } else {
            Random random = new Random();
            int randomIndex = random.nextInt(available_leagues.size());
            LeagueTable random_select_league = available_leagues.get(randomIndex);
            random_select_league.getMembers().add(current_user);
            random_select_league.getMembers().sort(Comparator.comparingInt(User::getOverallXp));
            random_select_league = leagueRepo.save(random_select_league);
            current_user.setLeagueId(random_select_league.getLeagueId());

            current_user.setLeagueTier(random_select_league.getTierName());

            current_user = userRepo.save(current_user);
            model.addAttribute("league", random_select_league);
        }
        return current_user;
    }
}