package com.example.postgresDbApi.dao;

import com.example.postgresDbApi.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao
{
    boolean insertPerson(UUID id, Person person);

    default boolean insertPerson(Person person)
    {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    Optional<Person> selectPersonById(UUID id);

    List<Person> selectAllPeople();

    boolean updatePersonById(UUID id);

    boolean deletePersonById(UUID uuid);
}
