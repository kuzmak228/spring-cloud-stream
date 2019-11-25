package com.example.demohttps.start.spring.io.controllers;

import com.example.demohttps.start.spring.io.models.Person;
import com.example.demohttps.start.spring.io.rabbit.PersonSource;
import com.example.demohttps.start.spring.io.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(PersonSource.class)
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    private final PersonService personService;

    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("create-person")
    public void test(@RequestParam("firstName") final String firstName,
                     @RequestParam("lastName") final String lastName) {
        personService.createPerson(firstName, lastName);
    }

    @StreamListener(PersonSource.PERSON_INPUT)
    @SendTo(PersonSource.PERSON_OUTPUT_SECOND)
    Person getAndPublishToNext(@Payload final Person person) {
        LOGGER.info("Listener {} got message with payload {}", PersonSource.PERSON_INPUT, person);
        person.setLastName("CHANGING_LAST_NAME");
        return person;
    }

    @StreamListener(PersonSource.PERSON_INPUT_SECOND)
    void get(@Payload Person person) {
        LOGGER.info("Listener {} got message with payload {}", PersonSource.PERSON_INPUT_SECOND, person);
    }

}
