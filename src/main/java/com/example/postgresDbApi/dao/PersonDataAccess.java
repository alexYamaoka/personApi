package com.example.postgresDbApi.dao;

import com.example.postgresDbApi.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccess implements PersonDao
{
    private JdbcTemplate jdbcTemplate;


    @Autowired
    public PersonDataAccess(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insertPerson(UUID id, Person person)
    {
        String sql = "INSERT INTO person ( id, name) VALUES ( " + id + ", " + person.getName() + ")";

        System.out.println("Insert person called");
        System.out.println("Person: " + person.getName());

        jdbcTemplate.update(
                "INSERT INTO person (id, name) VALUES (?, ?)",
                id, person.getName()
        );
        return true;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id)
    {
        return Optional.empty();
    }

    @Override
    public List<Person> selectAllPeople()
    {
        String sql = "SELECT id, name FROM person";
        List<Person> personList = jdbcTemplate.query(sql, ((resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(id, name);
        }));

        return personList;
    }

    @Override
    public boolean updatePersonById(UUID id, Person person)
    {
        return false;
    }

    @Override
    public boolean deletePersonById(UUID id)
    {
        String deleteQuery = "DELETE FROM person WHERE id = ?";
        jdbcTemplate.update(deleteQuery, id);

        return true;
    }
}
