package com.iqmsoft.boot.kafka.uppercaser.processor;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

import com.iqmsoft.boot.kafka.api.Message;

@Slf4j
@SpringBootApplication
@EnableBinding(Processor.class)
public class UpperCaserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpperCaserApplication.class, args);
        log.info("start upper-casing process from messages to uppercased");
    }

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Message toUpperCase(String message) {
        return new Message().setGreeting(message.toUpperCase());
    }
}
