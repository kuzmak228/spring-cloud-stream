package com.example.demohttps.start.spring.io.models;

public class PersonChangedEvent {

    private Person person;

    public PersonChangedEvent(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
