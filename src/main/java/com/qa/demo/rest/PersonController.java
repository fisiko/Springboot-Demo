package com.qa.demo.rest;

import com.qa.demo.entities.Person;
import com.qa.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class PersonController {

//    @Autowired
//    List<Person> people;
    @Autowired
    private PersonService service;

    public PersonController(PersonService service){
        this.service=service;
    }


    @GetMapping("/getAll")
    public List<Person> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/getPerson/{id}")
    public Person getPerson(@PathVariable int id) {
        return this.service.getPerson(id);
    }

    @PostMapping("/create")
    public Person createPerson (@RequestBody Person person){
        this.service.createPerson(person);
        return this.service.createPerson(person);

    }
    @DeleteMapping("/delete/{id}")
    public Person deletePerson (@PathVariable int id){

        return this.service.deletePerson(id);

    }
    @PatchMapping ("/update/{id}")
    public Person updatePerson (@PathVariable int id, @RequestParam(required = false) String name, @RequestParam(required = false) Integer age, @RequestParam(required = false) String job){

               return this.service.updatePerson(id, name, age, job);

    }
}
