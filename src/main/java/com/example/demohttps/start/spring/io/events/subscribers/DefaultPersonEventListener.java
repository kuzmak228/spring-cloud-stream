package com.example.demohttps.start.spring.io.events.subscribers;

import com.example.demohttps.start.spring.io.models.PersonChangedEvent;
import com.example.demohttps.start.spring.io.rabbit.PersonSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static org.springframework.messaging.support.MessageBuilder.withPayload;

@Component
public class DefaultPersonEventListener implements PersonEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultPersonEventListener.class);

    private final PersonSource personSource;

    public DefaultPersonEventListener(final PersonSource personSource) {
        this.personSource = personSource;
    }

    @Override
    @EventListener
    public void createPerson(final PersonChangedEvent personChangedEvent) {
        LOGGER.info("Got event {}", personChangedEvent.getClass().getSimpleName());
        personSource
                .personRegistration()
                .send(withPayload(personChangedEvent.getPerson()).build());
    }
}
