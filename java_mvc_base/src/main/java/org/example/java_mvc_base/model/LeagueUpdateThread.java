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
public class LeagueUpdateThread extends Thread {

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

        switch (league.getTierName()){
            case "Bronze":
                promotion_tier = "Artificial champions";
                break;
            case "Artificial champions":
                promotion_tier = "Kings Intelligence";
                break;
            case "Kings Intelligence":
                promotion_tier = "Kings Intelligence";
                break;
        }

        switch (league.getTierName()){
            case "Bronze":
                relegation_tier = "Bronze";
                break;
            case "Artificial champions":
                relegation_tier = "Bronze";
                break;
            case "Kings Intelligence":
                relegation_tier = "Artificial champions";
        }
        List<User> members = List.copyOf(league.getMembers());

        for (User user : members){
            league.getMembers().remove(user);
            league = l_repo.save(league);
            if (count <= 1) {  //promote the top 3
                List<LeagueTable> available_leagues = l_repo.
                        findByTierNameAndDaysLeftAndMembersCountLessThan(promotion_tier, 7, 24); //test area
                LeagueTable fresh_league = null;
                if (available_leagues.isEmpty()) {
                    fresh_league = new LeagueTable(LocalDate.now());
                    fresh_league.setTierName(promotion_tier);
                }else{
                    Random random = new Random();
                    int randomIndex = random.nextInt(available_leagues.size());
                    fresh_league = available_leagues.get(randomIndex);
                }
                fresh_league = l_repo.save(fresh_league);
                league.getMembers().remove(user);
                user.setLeagueId(fresh_league.getLeagueId());
                u_repo.save(user);

                if (! fresh_league.getMembers().contains(user)){
                    fresh_league.getMembers().add(user);
                }
                l_repo.save(fresh_league);
                // if (18 >= count )

            } else  {
                List<LeagueTable> available_leagues = l_repo.
                        findByTierNameAndDaysLeftAndMembersCountLessThan(relegation_tier, 7, 24);
                LeagueTable fresh_league;
                if (available_leagues.isEmpty()) {
                    fresh_league = new LeagueTable(LocalDate.now());
                    fresh_league.setTierName(relegation_tier);
                }else{
                    Random random = new Random();
                    int randomIndex = random.nextInt(available_leagues.size());
                    fresh_league = available_leagues.get(randomIndex);
                }

                fresh_league = l_repo.save(fresh_league);
                fresh_league.getMembers().add(user);
                user.setLeagueId(fresh_league.getLeagueId());
                u_repo.save(user);
                fresh_league = l_repo.save(fresh_league);

            }
            count ++;
        }
        //l_repo.delete(league);

    }

    @Override
    public void run(){
        while (running) {
            System.out.println("SLEEPING BEFORE CHECKING");
            try {
                sleep(90000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Checking now");
            for (LeagueTable league : l_repo.findAll()) {
                league.setDaysLeft(league.getDaysLeft() - Period.between(league.getLastCheckedDate(), LocalDate.now()).getDays());
                league.setLastCheckedDate();
                league = l_repo.save(league);
                if (league.getDaysLeft() < 0){
                    assign_new_leagues(league);

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
