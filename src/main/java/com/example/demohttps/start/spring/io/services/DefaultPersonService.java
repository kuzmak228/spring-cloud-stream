package com.example.demohttps.start.spring.io.services;

import com.example.demohttps.start.spring.io.events.publishers.PersonEventPublisher;
import com.example.demohttps.start.spring.io.models.Person;
import com.example.demohttps.start.spring.io.models.PersonChangedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DefaultPersonService implements PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultPersonService.class);

    private final PersonEventPublisher personEventPublisher;

    public DefaultPersonService(PersonEventPublisher personEventPublisher) {
        this.personEventPublisher = personEventPublisher;
    }

    @Override
    public Person createPerson(String firstName, String lastName) {
        LOGGER.info("Creating a person with first name {} and last name {}", firstName, lastName);
        final var person = new Person(firstName, lastName);
        personEventPublisher.publishEvent(new PersonChangedEvent(person));
        return person;
    }
}
