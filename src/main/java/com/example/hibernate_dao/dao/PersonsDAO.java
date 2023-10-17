package com.example.hibernate_dao.dao;

import com.example.hibernate_dao.models.Person;
import com.example.hibernate_dao.models.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface PersonsDAO extends JpaRepository<Person, PersonalData> {
    List<Person> findPersonByCityOfLiving(String city);

    List<Person> findPersonByPersonalDataAgeOrderByPersonalDataAsc(int age);

    List<Optional<Person>> findPersonByPersonalData_NameAAndPersonalData_Surname(String name, String surname);
}
