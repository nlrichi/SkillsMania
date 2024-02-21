package org.example.java_mvc_base.repo;


import org.example.java_mvc_base.model.User;
import org.springframework.data.repository.CrudRepository;



// go access users from other java beans
public interface UserRepository extends CrudRepository<User, String> {
    User findUserByUsername(String name);
}

