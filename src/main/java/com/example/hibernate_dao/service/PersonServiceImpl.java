package com.example.hibernate_dao.service;

import com.example.hibernate_dao.dao.PersonsDAO;
import com.example.hibernate_dao.models.Person;
import com.example.hibernate_dao.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonsDAO personsDAO;

    @Override
    public List<Person> getPersonsByCity(String city) {
        return personsDAO.getPersonsByCity(city);
    }
}
