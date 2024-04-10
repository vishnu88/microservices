package com.order.payment.config;
import com.google.gson.Gson;
import com.order.order.event.OrderEvent;
import com.order.order.event.OrderStatus;
import com.order.order.event.PaymentEvent;
import com.order.payment.service.PaymentService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;
import java.util.function.Function;

@Configuration
public class PaymentConsumerConfig {

    @Autowired
    PaymentService paymentService;

    @KafkaListener(topics = "order-event2",groupId = "group-1")
    public void updatePayment(String message){

        System.out.println("**************88"+message);

    }

    private Mono<PaymentEvent> processPayment (OrderEvent orderEvent) {

     if(OrderStatus.ORDER_CREATED.equals(orderEvent.getOrderStatus()))
     {

         return Mono.fromSupplier(()->this.paymentService.newOrderEvent(orderEvent));
     }
     else{
       return Mono.fromRunnable(()->this.paymentService.cancelOrderEvent(orderEvent));
     }

    }
}
