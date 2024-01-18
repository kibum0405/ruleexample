package ruleexample.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import ruleexample.DeliveryApplication;
import ruleexample.domain.DeliveryAdd;
import ruleexample.domain.DeliveryCancel;

@Entity
@Table(name = "Delivery_table")
@Data
//<<< DDD / Aggregate Root
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deliveryId;

    private Integer stock;

    private String name;

    private List<Chicken> chickens;

    @PostPersist
    public void onPostPersist() {
        DeliveryAdd deliveryAdd = new DeliveryAdd(this);
        deliveryAdd.publishAfterCommit();

        DeliveryCancel deliveryCancel = new DeliveryCancel(this);
        deliveryCancel.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void deliverUpdate(OrderEvent orderEvent) {
        //implement business logic here:

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        DeliveryAdd deliveryAdd = new DeliveryAdd(delivery);
        deliveryAdd.publishAfterCommit();
        DeliveryCancel deliveryCancel = new DeliveryCancel(delivery);
        deliveryCancel.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderEvent.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            DeliveryAdd deliveryAdd = new DeliveryAdd(delivery);
            deliveryAdd.publishAfterCommit();
            DeliveryCancel deliveryCancel = new DeliveryCancel(delivery);
            deliveryCancel.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
