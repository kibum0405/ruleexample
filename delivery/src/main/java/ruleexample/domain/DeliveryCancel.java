package ruleexample.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ruleexample.domain.*;
import ruleexample.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryCancel extends AbstractEvent {

    private Long deliveryId;
    private Integer stock;
    private String name;

    public DeliveryCancel(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryCancel() {
        super();
    }
}
//>>> DDD / Domain Event
