package com.example.postgresDbApi.dao;

import com.example.postgresDbApi.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FakePersonDataAccess implements PersonDao
{
    private List<Person> personDB = new ArrayList<>();


    @Override
    public boolean insertPerson(UUID id, Person person)
    {
        Person newPerson = new Person(id, person.getName());
        return true;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id)
    {
        return personDB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public List<Person> selectAllPeople()
    {
        return personDB;
    }

    @Override
    public boolean updatePersonById(UUID id, Person person)
    {
        return selectPersonById(id)
                .map(p -> {
                    int indexOfPersonToUpdate = personDB.indexOf(p);

                    if (indexOfPersonToUpdate >= 0)
                    {
                        personDB.set(indexOfPersonToUpdate, new Person(id, person.getName()));
                        return true;
                    }
                    return false;

                }).orElse(false);
    }

    @Override
    public boolean deletePersonById(UUID id)
    {
        Optional<Person> deletePerson = selectPersonById(id);

        if (deletePerson.isEmpty())
        {
            return false;
        }

        personDB.remove(deletePerson.get());

        return true;
    }
}
