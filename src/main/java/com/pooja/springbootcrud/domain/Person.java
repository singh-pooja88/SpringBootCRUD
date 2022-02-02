package com.pooja.springbootcrud.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @Column(name="person_id")
    private Integer personId;
    @Column(name="person_name")
    private String name;
    private String address;
    private String nationality;
    private String profession;

    public Person() {

    }

    public Person(Integer id, String name, String address, String nationality, String profession) {
        this.personId = id;
        this.name = name;
        this.address = address;
        this.nationality = nationality;
        this.profession = profession;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
