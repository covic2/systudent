package com.systudent.component;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoggerProducer {
	//private static final Logger LOGGER = LoggerFactory.getLogger(LoggerProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public LoggerProducer(@Qualifier("kafkaStringTemplate") KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        this.kafkaTemplate.send("message-db", message);
    }
}
