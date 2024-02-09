package org.example.java_mvc_base.model;

import org.example.java_mvc_base.repo.LeagueTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.Period;

@Service
public class LeagueUpdateThread extends Thread {
    @Autowired
    LeagueTableRepository l_repo;

    public void run(){
        while (true) {
            for (LeagueTable league : l_repo.findAll()) {
                league.setDays_left(league.getDays_left() - Period.between(LocalDate.now(), league.getLastCheckedDate()).getDays());
                league.setLastCheckedDate();
                l_repo.save(league);
            }
            try {
                sleep(60000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
