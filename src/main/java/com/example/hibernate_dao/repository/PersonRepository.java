package com.example.hibernate_dao.repository;

import com.example.hibernate_dao.dao.PersonsDAO;
import com.example.hibernate_dao.models.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonRepository implements PersonsDAO {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Person> getPersonsByCity(String city) {
        return entityManager.createQuery("select p from Person p where p.cityOfLiving = :city", Person.class)
                .setParameter("city", city)
                .getResultList();
    }
}
