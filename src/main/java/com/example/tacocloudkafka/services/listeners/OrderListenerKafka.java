package com.example.tacocloudkafka.services.listeners;

import com.example.tacoclouddomain.entities.TacoOrder;
import com.example.tacoclouddomain.kitchen.KitchenOrder;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

//@Profile("kafka-listener")
@Component
public class OrderListenerKafka {

    private final KitchenOrder kitchenOrder;

    public OrderListenerKafka(KitchenOrder kitchenOrder) {
        this.kitchenOrder = kitchenOrder;
    }

    @KafkaListener(topics = "tacocloud.orders.topic")
    public void receiveOrder(@Payload TacoOrder order) {
        kitchenOrder.displayOrder(order);
    }

}
