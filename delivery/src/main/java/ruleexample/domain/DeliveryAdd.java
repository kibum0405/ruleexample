package ruleexample.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ruleexample.domain.*;
import ruleexample.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryAdd extends AbstractEvent {

    private Long deliveryId;
    private String stock;
    private String name;

    public DeliveryAdd(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryAdd() {
        super();
    }
}
//>>> DDD / Domain Event
