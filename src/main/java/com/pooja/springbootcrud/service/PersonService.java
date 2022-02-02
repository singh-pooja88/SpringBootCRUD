package com.pooja.springbootcrud.service;

import com.pooja.springbootcrud.domain.Person;
import com.pooja.springbootcrud.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> listAll() {
       return personRepository.findAll();
    }

    public Person getPerson(Integer id) {
        try {
            return personRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }

    public void updatePerson(Person newPerson) {
        Optional<Person> oldData = personRepository.findById(newPerson.getPersonId());
        if (oldData.isPresent()) {
            Person old = oldData.get();
            old.setName(newPerson.getName());
            old.setAddress(newPerson.getAddress());
            old.setProfession(newPerson.getProfession());
            old.setNationality(newPerson.getNationality());
            personRepository.save(old);
        }
    }

}
