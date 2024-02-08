package org.example.java_mvc_base.repo;

import org.example.java_mvc_base.model.LeagueTable;
import org.springframework.data.repository.CrudRepository;


public interface LeagueTableRepository extends CrudRepository<LeagueTable, Integer> {

    public LeagueTable findByLeague_id(int id);
}
