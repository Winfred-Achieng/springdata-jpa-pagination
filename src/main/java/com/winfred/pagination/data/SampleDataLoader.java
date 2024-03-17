package com.winfred.pagination.data;

import com.github.javafaker.Faker;
import com.winfred.pagination.model.Address;
import com.winfred.pagination.model.Person;
import com.winfred.pagination.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;


@Component
public class SampleDataLoader implements CommandLineRunner {

    @Autowired
    private final PersonRepository personRepository;
    @Autowired
    private final Faker faker;
    private Logger logger = LoggerFactory.getLogger(SampleDataLoader.class);

    public SampleDataLoader(PersonRepository personRepository, Faker faker ) {
        this.personRepository = personRepository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {
       logger.info("Loading sample data....");

        List<Person> people = IntStream.rangeClosed(1,100)
                .mapToObj(i -> new Person(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.phoneNumber().cellPhone(),
                        faker.internet().emailAddress(),new Address(
                                faker.address().streetAddress(),
                                faker.address().city(),
                                faker.address().state(),
                                faker.address().zipCode()
                )

                ))
                .toList();

        personRepository.saveAll(people);
    }
}
