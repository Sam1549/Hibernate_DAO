package com.example.hibernate_dao.controller;

import com.example.hibernate_dao.models.Person;
import com.example.hibernate_dao.models.PersonalData;
import com.example.hibernate_dao.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonsController {

    private final PersonService personService;

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personService.getPersonsByCity(city);
    }

    @GetMapping("/by-age")
    public List<Person> getPersonsByAge(@RequestParam int age) {
        return personService.getPersonsByAge(age);
    }

    @GetMapping("/by-name-surname")
    public List<Optional<Person>> getPersonsByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personService.getPersonsByNameAndSurname(name, surname);
    }

    @PostMapping("/create")
    public void createNewPerson(@RequestBody Person person) {
        personService.createNewPerson(person);
    }

    @PostMapping("/delete")
    public void deletePerson(@RequestBody PersonalData personalData) {
        personService.deletePerson(personalData);
    }

    @PostMapping("/by-personalData")
    public Optional<Person> findByID(@RequestBody PersonalData personalData) {
        return personService.findById(personalData);
    }


}
