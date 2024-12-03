package com.example.tacocloudkafka.services.listeners;

import com.example.tacoclouddomain.entities.TacoOrder;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

//@Profile("kafka-listener")
@Component
public class OrderListenerKafka {

    private final KitchenListenerKafka kitchenListenerKafka;

    public OrderListenerKafka(KitchenListenerKafka kitchenListenerKafka) {
        this.kitchenListenerKafka = kitchenListenerKafka;
    }

    @KafkaListener(topics = "tacocloud.orders.topic")
    public void receiveOrder(@Payload TacoOrder order) {
        kitchenListenerKafka.displayOrder(order);
    }

}
