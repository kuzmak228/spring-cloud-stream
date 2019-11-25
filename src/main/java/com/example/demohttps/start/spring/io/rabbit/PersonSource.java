package com.example.demohttps.start.spring.io.rabbit;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface PersonSource {

    String PERSON_OUTPUT = "person-out";
    String PERSON_INPUT = "person-in";

    String PERSON_OUTPUT_SECOND = "person-out-2";
    String PERSON_INPUT_SECOND = "person-in-2";

    @Output(PERSON_OUTPUT)
    MessageChannel personRegistration();

    @Input(PERSON_INPUT)
    SubscribableChannel personIn();

    @Output(PERSON_OUTPUT_SECOND)
    MessageChannel check();

    @Input(PERSON_INPUT_SECOND)
    SubscribableChannel check2();
}
