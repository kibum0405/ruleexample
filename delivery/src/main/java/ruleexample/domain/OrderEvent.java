package ruleexample.domain;

import java.util.*;
import lombok.*;
import ruleexample.domain.*;
import ruleexample.infra.AbstractEvent;

@Data
@ToString
public class OrderEvent extends AbstractEvent {

    private Long orderId;
    private Integer stock;
    private String name;
}
