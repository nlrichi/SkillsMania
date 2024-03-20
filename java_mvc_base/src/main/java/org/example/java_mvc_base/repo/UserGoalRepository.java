package org.example.java_mvc_base.repo;

import org.example.java_mvc_base.model.Goal;
import org.example.java_mvc_base.model.User;
import org.example.java_mvc_base.model.UserGoal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserGoalRepository extends CrudRepository<UserGoal, Integer> {
    List<UserGoal> findByUser(User user);

    List<UserGoal> findByUserAndIsCompleted(User user, boolean isCompleted);

    Optional<UserGoal> findByUserAndGoal(User user, Goal goal);
}
