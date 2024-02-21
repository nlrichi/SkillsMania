package org.example.java_mvc_base.repo;

import org.example.java_mvc_base.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, String>  {
    
}
