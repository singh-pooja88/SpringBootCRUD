package com.pooja.springbootcrud.repositories;

import com.pooja.springbootcrud.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
