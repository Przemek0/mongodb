package com.example.mongodb;

import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import java.util.List;

public class DataSeed {

    private final PersonRepository personRepository;
    private final Logger logger;

    public DataSeed(PersonRepository personRepository, Logger logger) {
        this.personRepository = personRepository;
        this.logger = logger;
    }

    @PostConstruct
    public void createPerson() {
        final Person person = new Person();
        person.setName("Adam");
        person.setLastName("Nowak");
        final Person savedPerson = personRepository.save(person);
        logger.info(savedPerson.toString());
        final List<Person> all = personRepository.findAll();
        logger.info(all.toString());

    }
}
