package com.pooja.springbootcrud.controller;

import com.pooja.springbootcrud.domain.Person;
import com.pooja.springbootcrud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Integer personId) {
        Person person = personService.getPerson(personId);
        if (person != null)
            return new ResponseEntity<Person>(person, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        return personService.listAll();
    }

    @PostMapping("/person")
    public void createPerson(@RequestBody Person person) {
        personService.savePerson(person);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity updatePerson(@RequestBody Person person, @PathVariable("id") Integer personId) {
        personService.updatePerson(person);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity deletePerson(@PathVariable("id") Integer personId) {
        personService.deletePerson(personId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
