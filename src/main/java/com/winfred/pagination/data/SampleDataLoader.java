package com.winfred.pagination.data;

import com.winfred.pagination.model.Address;
import com.winfred.pagination.model.Person;
import com.winfred.pagination.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class SampleDataLoader implements CommandLineRunner {

    @Autowired
    private final PersonRepository personRepository;
    private Logger logger = LoggerFactory.getLogger(SampleDataLoader.class);

    public SampleDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
       logger.info("Loading sample data....");

       Person person =new Person("Ned",
               "Vega",
               "0876532224",
               "ned.vega@gmail.com",
               new Address("Streeet",
                       "city",
                       "state",
                       "zip"));

       personRepository.save(person);

    }
}
