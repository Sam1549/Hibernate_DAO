package com.example.hibernate_dao.dao;

import com.example.hibernate_dao.models.Person;
import com.example.hibernate_dao.models.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;


public interface PersonsDAO extends JpaRepository<Person, PersonalData> {
    @Query("select p from Person p where p.cityOfLiving =:city")
    List<Person> findPersonByCityOfLiving(@Param("city") String city);

    @Query("select p from Person p where p.personalData.age < :age order by p.personalData.age")
    List<Person> findPersonByPersonalDataAgeBeforeOrderByPersonalDataAge(@Param("age") int age);

    @Query("select p from Person p where p.personalData.name = :name and p.personalData.surname = :surname")
    List<Optional<Person>> findPersonByPersonalData_NameAndPersonalData_Surname(@Param("name") String name, @Param("surname") String surname);

    @Query("select p from Person p where p.personalData.name = :name")
    Person getPersonByName(@Param("name") String name);
}
