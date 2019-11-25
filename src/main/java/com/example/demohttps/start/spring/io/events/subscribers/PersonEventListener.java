package com.example.demohttps.start.spring.io.events.subscribers;

import com.example.demohttps.start.spring.io.models.PersonChangedEvent;

public interface PersonEventListener {

    void createPerson(PersonChangedEvent personChangedEvent);
}
