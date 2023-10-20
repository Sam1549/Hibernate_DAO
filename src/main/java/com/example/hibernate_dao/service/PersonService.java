package com.example.hibernate_dao.service;

import com.example.hibernate_dao.models.Person;
import com.example.hibernate_dao.models.PersonalData;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getPersonsByCity(String city);

    List<Person> getPersonsByAge(int age);

    List<Optional<Person>> getPersonsByNameAndSurname(String name, String surname);

    void createNewPerson(Person person);

    void deletePerson(PersonalData personalData);

    Optional<Person> findById(PersonalData personalData);

    Person getPersonByName(String name);
}
