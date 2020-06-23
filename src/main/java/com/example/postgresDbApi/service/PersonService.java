package com.example.postgresDbApi.service;

import com.example.postgresDbApi.dao.PersonDao;
import com.example.postgresDbApi.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// where the business logic is placed

@Service
public class PersonService
{
    private PersonDao personDao;

    public PersonService(@Qualifier("fakeDao") PersonDao personDao)
    {
        this.personDao = personDao;
    }

    public boolean addPerson(Person person)
    {
        return personDao.insertPerson(person);
    }

    public Optional<Person> getPersonById(UUID id)
    {
        return personDao.selectPersonById(id);
    }

    public List<Person> getAllPeople()
    {
        return personDao.selectAllPeople();
    }

    public boolean updatePerson(UUID id, Person person)
    {
        return personDao.updatePersonById(id, person);
    }

    public boolean deletePerson(UUID id)
    {
        return personDao.deletePersonById(id);
    }
}
