package io.aiven.quickstart.elevator;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ElevatorData {
    private String elevatorId;
    private String location;
    private String timestamp;
    private boolean userInitiated;
}
