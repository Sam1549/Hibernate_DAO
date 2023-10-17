package com.example.hibernate_dao.dao;

import com.example.hibernate_dao.models.Person;
import com.example.hibernate_dao.models.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;


public interface PersonsDAO extends JpaRepository<Person, PersonalData> {
    List<Person> findPersonByCityOfLiving(String city);

    List<Person> findPersonByPersonalDataAgeBeforeOrderByPersonalDataAge(int age);

    List<Optional<Person>> findPersonByPersonalData_NameAndPersonalData_Surname(String name, String surname);

}
