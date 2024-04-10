package com.order.order.services;

import com.order.order.dto.OrderRequestDto;
import com.order.order.entities.PurchaseOrder;

import java.util.List;

public interface OrderService {

    PurchaseOrder createPurchase(OrderRequestDto orderRequestDto);
    List<PurchaseOrder> getAllPurchaseOrder();
}
