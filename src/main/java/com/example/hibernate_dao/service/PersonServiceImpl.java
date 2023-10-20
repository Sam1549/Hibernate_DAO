package com.example.hibernate_dao.service;

import com.example.hibernate_dao.dao.PersonsDAO;
import com.example.hibernate_dao.models.Person;
import com.example.hibernate_dao.models.PersonalData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonsDAO personsDAO;

    @Override
    public List<Person> getPersonsByCity(String city) {
        return personsDAO.findPersonByCityOfLiving(city);
    }

    @Override
    public List<Person> getPersonsByAge(int age) {
        return personsDAO.findPersonByPersonalDataAgeBeforeOrderByPersonalDataAge(age);
    }

    @Override
    public List<Optional<Person>> getPersonsByNameAndSurname(String name, String surname) {
        return personsDAO.findPersonByPersonalData_NameAndPersonalData_Surname(name, surname);
    }

    @Override
    public void createNewPerson(Person person) {
        personsDAO.save(person);
    }

    @Override
    public void deletePerson(PersonalData personalData) {
        personsDAO.deleteById(personalData);
    }

    @Override
    public Optional<Person> findById(PersonalData personalData) {
        return personsDAO.findById(personalData);
    }

    @Override
    public Person getPersonByName(String name) {
        return personsDAO.getPersonByName(name);
    }
}
