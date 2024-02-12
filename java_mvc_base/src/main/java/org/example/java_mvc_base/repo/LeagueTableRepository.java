package org.example.java_mvc_base.repo;

import org.example.java_mvc_base.model.LeagueTable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface LeagueTableRepository extends CrudRepository<LeagueTable, Integer> {

    public LeagueTable findByLeagueId(int id);

    public List<LeagueTable> findByTierNameAndDaysLeftAndMembersCountLessThan(String tier_name, int daysLeft, int count);
}
