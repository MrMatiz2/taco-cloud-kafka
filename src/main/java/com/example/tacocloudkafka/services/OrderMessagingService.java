package com.example.tacocloudkafka.services;

import com.example.tacoclouddomain.entities.TacoOrder;

public interface OrderMessagingService {

    void sendOrder(TacoOrder tacoOrder);

}
