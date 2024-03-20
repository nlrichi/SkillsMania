package org.example.java_mvc_base.repo;

import org.example.java_mvc_base.model.Goal;
import org.example.java_mvc_base.model.LeagueTable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GoalRepository extends CrudRepository<Goal, Long> {
}
