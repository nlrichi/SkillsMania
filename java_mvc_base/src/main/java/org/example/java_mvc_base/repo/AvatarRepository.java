package org.example.java_mvc_base.repo;

import org.example.java_mvc_base.model.Avatar;
import org.springframework.data.repository.CrudRepository;

public interface AvatarRepository extends CrudRepository<Avatar, Long> {
}
