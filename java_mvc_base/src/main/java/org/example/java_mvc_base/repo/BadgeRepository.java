package org.example.java_mvc_base.repo;

import org.example.java_mvc_base.model.Badge;
import org.springframework.data.repository.CrudRepository;

public interface BadgeRepository extends CrudRepository<Badge, Integer> {
    Badge findById(long id);
}
