package ruleexample.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import ruleexample.UserApplication;
import ruleexample.domain.OrderEvent;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private Integer stock;

    private String name;

    @PostPersist
    public void onPostPersist() {
        OrderEvent orderEvent = new OrderEvent(this);
        orderEvent.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = UserApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }
}
//>>> DDD / Aggregate Root
