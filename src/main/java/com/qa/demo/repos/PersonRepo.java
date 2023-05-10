package com.qa.demo.repos;

import com.qa.demo.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

}
