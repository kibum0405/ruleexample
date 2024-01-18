package ruleexample.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ruleexample.domain.*;
import ruleexample.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderEvent extends AbstractEvent {

    private Long orderId;
    private Integer stock;
    private String name;

    public OrderEvent(Order aggregate) {
        super(aggregate);
    }

    public OrderEvent() {
        super();
    }
}
//>>> DDD / Domain Event
