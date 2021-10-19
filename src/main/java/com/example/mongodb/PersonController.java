package com.example.mongodb;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public ResponseEntity<List<Person>> readPersons() {
        final List<Person> all = personRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        final Person save = personRepository.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }
}
