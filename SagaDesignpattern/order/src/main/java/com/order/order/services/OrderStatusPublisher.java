package com.order.order.services;

import com.order.order.dto.OrderRequestDto;
import com.order.order.event.OrderEvent;
import com.order.order.event.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
public class OrderStatusPublisher {
    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;
    public  void  publishOrderEvent(OrderRequestDto orderRequestDto, OrderStatus orderStatus){
        OrderEvent event = new OrderEvent(orderRequestDto,orderStatus);
        //kafkaTemplate.send((Message<OrderEvent>) event);
        kafkaTemplate.send("order-event2",event.getEventId().toString(),event);
       // orderSink.tryEmitNext(event);
        System.out.println("***********Order Even Ho gaya Publish Bro");
    }
}
