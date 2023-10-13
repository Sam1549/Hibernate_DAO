package com.example.hibernate_dao.dao;

import com.example.hibernate_dao.models.Person;

import java.util.List;

public interface PersonsDAO {
   List<Person> getPersonsByCity(String city);
}
