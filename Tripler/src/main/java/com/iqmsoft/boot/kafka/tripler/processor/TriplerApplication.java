package com.iqmsoft.boot.kafka.tripler.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

@Slf4j
@SpringBootApplication
@EnableBinding(Processor.class)
public class TriplerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TriplerApplication.class, args);
        log.info("start message triple processor from uppercased to transformed");
    }

    @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public String transform(String message) {
        return message + ", " + message + ", " + message;
    }
}
