package io.aiven.quickstart.service;

import io.aiven.quickstart.elevator.ElevatorData;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AlertEmitter {
    @Value("${kafka.topics.elevatorAlarm}")
    private String topic;

    @Autowired
    private KafkaProducer<String, ElevatorData> kafkaProducer;

    public void send(String uuid, ElevatorData data) {
        final ProducerRecord<String, ElevatorData> record = new ProducerRecord<>(topic, uuid, data);
        kafkaProducer.send(record);
    }
}
