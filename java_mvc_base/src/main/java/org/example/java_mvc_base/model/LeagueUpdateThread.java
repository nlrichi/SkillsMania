package org.example.java_mvc_base.model;

import org.example.java_mvc_base.repo.LeagueTableRepository;
import org.example.java_mvc_base.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;

@Component
public class LeagueUpdateThread extends Thread { //background thread to manage real-time changes in league data

    @Autowired
    private LeagueTableRepository l_repo;

    @Autowired
    private UserRepository u_repo;
    private boolean running = false;

    public void setL_repo(LeagueTableRepository l_repo) {
        this.l_repo = l_repo;
    }

    public void assign_new_leagues(LeagueTable league){
        int count = 1;
        String promotion_tier = "Kings Intelligence";
        String relegation_tier = "Kings Intelligence";

        switch (league.getTierName()){ // promotion selection based on which tier the league is
            case "Bronze":
                promotion_tier = "Artificial Champions";
                break;
            case "Artificial Champions":
                promotion_tier = "Kings Intelligence";
                break;
            case "Kings Intelligence":
                promotion_tier = "Kings Intelligence";
                break;
        }

        switch (league.getTierName()){ // relegation selection based on which tier the league is
            case "Bronze":
                relegation_tier = "Bronze";
                break;
            case "Artificial Champions":
                relegation_tier = "Bronze";
                break;
            case "Kings Intelligence":
                relegation_tier = "Artificial Champions";
        }

        List<User> members = List.copyOf(league.getMembers());
        for (User user : members){
            user.setFinalLeaguePosition(count);

            //indicate that the user hasn't opened leaderboards since the league ended. Used
            //for leaderboard notification redirect
            user.setUsersleagueEnded(true);
            user.setLeagueXP(0);
            league.getMembers().remove(user);
            league = l_repo.save(league);
            if (count <= 6) {  //promote the top 6
                List<LeagueTable> available_leagues = l_repo.
                        findByTierNameAndDaysLeftAndMembersCountLessThan(promotion_tier, 7, 24); //test area
                LeagueTable fresh_league = null;
                fresh_league = getLeagueTable(promotion_tier, available_leagues);
                league.getMembers().remove(user);
                user.setLeagueId(fresh_league.getLeagueId());
                u_repo.save(user);

                if (! fresh_league.getMembers().contains(user)){
                    fresh_league.getMembers().add(user);
                }
                l_repo.save(fresh_league);
                //

            } else { //demote the rest

                //Max in each league is 24 members
                //find leagues that have less than or equal to that
                List<LeagueTable> available_leagues = l_repo.
                        findByTierNameAndDaysLeftAndMembersCountLessThan(relegation_tier, 7, 25);

                LeagueTable fresh_league = getLeagueTable(relegation_tier, available_leagues);
                fresh_league.getMembers().add(user);
                user.setLeagueId(fresh_league.getLeagueId());
                u_repo.save(user);
                fresh_league = l_repo.save(fresh_league);

            }
            count ++;
        }

    }

    private LeagueTable getLeagueTable(String promotion_tier, List<LeagueTable> available_leagues) {
        LeagueTable fresh_league;
        if (available_leagues.isEmpty()) {// if there are no available leagues for the promotes, this create a new one
            fresh_league = new LeagueTable(LocalDate.now());
            fresh_league.setTierName(promotion_tier);
        }else{
            Random random = new Random();
            int randomIndex = random.nextInt(available_leagues.size()); //select a random available one to add the users to
            fresh_league = available_leagues.get(randomIndex);
        }
        fresh_league = l_repo.save(fresh_league);
        return fresh_league;
    }

    @Override
    public void run(){
        while (running) {
            System.out.println("SLEEPING BEFORE CHECKING");
            try {
                sleep(60000); //check for changes every  minute
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Checking now");
            for (LeagueTable league : l_repo.findAll()) {
                league.setDaysLeft(league.getDaysLeft() - Period.between(league.getLastCheckedDate(), LocalDate.now()).getDays());
                league.setLastCheckedDate();
                league = l_repo.save(league);
                if (league.getDaysLeft() < 0){
                    assign_new_leagues(league); // reassign, promote, relegate members of each league, if time is up for the league

                }

            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
