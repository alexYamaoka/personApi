package com.example.postgresDbApi.dao;

import com.example.postgresDbApi.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccess implements PersonDao
{
    @Override
    public boolean insertPerson(UUID id, Person person)
    {
        return false;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id)
    {
        return Optional.empty();
    }

    @Override
    public List<Person> selectAllPeople()
    {
        return null;
    }

    @Override
    public boolean updatePersonById(UUID id, Person person)
    {
        return false;
    }

    @Override
    public boolean deletePersonById(UUID id)
    {
        return false;
    }
}
