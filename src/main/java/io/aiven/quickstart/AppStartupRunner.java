package io.aiven.quickstart;

import io.aiven.quickstart.elevator.ElevatorData;
import io.aiven.quickstart.service.AlertEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class AppStartupRunner implements ApplicationRunner {

    @Autowired
    private AlertEmitter alertEmitter;

    @Override
    public void run(ApplicationArguments args) {
        final String uuid = UUID.randomUUID().toString();
        final ElevatorData data = ElevatorData.builder()
                .elevatorId("123456")
                .location("Robert Robertson, 1234 NW Bobcat Lane, St. Robert, MO 65584-5678")
                .timestamp(LocalDateTime.now().toString())
                .build();
        alertEmitter.send(uuid, data);
    }
}
