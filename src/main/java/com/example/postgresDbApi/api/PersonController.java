package com.example.postgresDbApi.api;

import com.example.postgresDbApi.model.Person;
import com.example.postgresDbApi.service.PersonService;

import java.util.List;
import java.util.UUID;

public class PersonController
{
    private PersonService personService;


    public PersonController(PersonService personService)
    {
        this.personService = personService;
    }


    public void addPerson(Person person)
    {
        personService.addPerson(person);
    }


    public Person getPersonById(UUID id)
    {
        return personService.getPersonById(id).orElse(null);
    }


    public List<Person> getAllPeople()
    {
        return personService.getAllPeople();
    }


    public void updatePerson(UUID id, Person person)
    {
        personService.updatePerson(id, person);
    }


    public void deletePersonById(UUID id)
    {
        personService.deletePerson(id);
    }
}
