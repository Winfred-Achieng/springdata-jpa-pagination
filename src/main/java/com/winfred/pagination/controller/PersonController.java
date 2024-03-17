package com.winfred.pagination.controller;

import com.winfred.pagination.model.Person;
import com.winfred.pagination.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/people/{page}/{size}")
    public Page<Person> findAll(@PathVariable int page,@PathVariable int size){
        PageRequest pr = PageRequest.of(page,size);
        return personRepository.findAll(pr);
    }
}
