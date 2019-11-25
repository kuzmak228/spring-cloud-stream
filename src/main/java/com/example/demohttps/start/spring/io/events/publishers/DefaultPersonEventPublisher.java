package com.example.demohttps.start.spring.io.events.publishers;

import com.example.demohttps.start.spring.io.models.PersonChangedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class DefaultPersonEventPublisher implements PersonEventPublisher {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultPersonEventPublisher.class);

    private final ApplicationEventPublisher eventPublisher;

    public DefaultPersonEventPublisher(final ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void publishEvent(final PersonChangedEvent pce) {
        LOGGER.info("Publishing event {}", pce.getClass().getSimpleName());
        eventPublisher.publishEvent(pce);
    }

}
