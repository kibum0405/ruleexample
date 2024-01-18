package ruleexample.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ruleexample.config.kafka.KafkaProcessor;
import ruleexample.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderEvent'"
    )
    public void wheneverOrderEvent_DeliverUpdate(
        @Payload OrderEvent orderEvent
    ) {
        OrderEvent event = orderEvent;
        System.out.println(
            "\n\n##### listener DeliverUpdate : " + orderEvent + "\n\n"
        );

        // Comments //
        //name : 오니기리, 초밥, 우동stock : 10개, 40개, 30개주문 주문이 시작되면 deliverAdd에 주문 개수가 생성되고 취소되면 다시 stock가 증가 1414141

        // Sample Logic //
        Delivery.deliverUpdate(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
