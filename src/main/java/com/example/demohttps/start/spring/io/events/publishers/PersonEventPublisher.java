package com.example.demohttps.start.spring.io.events.publishers;

import com.example.demohttps.start.spring.io.models.PersonChangedEvent;

public interface PersonEventPublisher {

    void publishEvent(PersonChangedEvent personChangedEvent);
}
