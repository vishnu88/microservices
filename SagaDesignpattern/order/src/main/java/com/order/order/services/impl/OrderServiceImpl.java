package com.order.order.services.impl;

import com.order.order.dto.OrderRequestDto;
import com.order.order.entities.PurchaseOrder;
import com.order.order.event.OrderStatus;
import com.order.order.repository.PurcahseOrderRepository;
import com.order.order.services.OrderService;
import com.order.order.services.OrderStatusPublisher;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    PurcahseOrderRepository repository;
    @Autowired
    private OrderStatusPublisher orderStatusPublisher;

    @Transactional
    @Override
    public PurchaseOrder createPurchase(OrderRequestDto orderRequestDto) {
        PurchaseOrder order =  repository.save(convertDtoToEntity(orderRequestDto));
        orderRequestDto.setOrderId(order.getId());
        //Produce Kafka event with status ORDER_CREATEd
        orderStatusPublisher.publishOrderEvent(orderRequestDto,OrderStatus.ORDER_CREATED);
        return order;
    }

    public List<PurchaseOrder> getAllPurchaseOrder(){
         return repository.findAll();
    }

    private PurchaseOrder convertDtoToEntity(OrderRequestDto orderRequestDto) {
        PurchaseOrder po = new PurchaseOrder();
        po.setProductId(orderRequestDto.getProductId());
        po.setUserId(orderRequestDto.getUserId());
        po.setOrderStatus(OrderStatus.ORDER_CREATED);
        po.setPrice(orderRequestDto.getAmount());
        return  po;
    }
}
