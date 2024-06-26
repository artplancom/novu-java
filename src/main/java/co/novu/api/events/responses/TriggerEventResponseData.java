package co.novu.api.events.responses;

import java.util.List;

import lombok.Data;

@Data
public class TriggerEventResponseData {
    private boolean acknowledged;
    private String status;
    private String transactionId;
    private List<String> error;
}
