package org.example.java_mvc_base.model;

import org.example.java_mvc_base.repo.LeagueTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Component
public class LeagueUpdateThread extends Thread {


    private LeagueTableRepository l_repo;
    private boolean running = false;

    @Autowired
    public LeagueUpdateThread(LeagueTableRepository repo){
        l_repo = repo;
    }


    @Override
    public void run(){
        while (running) {
            for (LeagueTable league : l_repo.findAll()) {
                league.setDaysLeft(league.getDaysLeft() - Period.between(LocalDate.now(), league.getLastCheckedDate()).getDays());
                league.setLastCheckedDate();
                l_repo.save(league);
            }
            System.out.println("SLEEPING AFTER CHECKING");
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
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
