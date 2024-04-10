package com.order.order.controller;


import com.order.order.dto.OrderRequestDto;
import com.order.order.entities.PurchaseOrder;
import com.order.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @PostMapping("/create")
    public PurchaseOrder createOrder(@RequestBody OrderRequestDto orderRequestDto){
        return orderService.createPurchase(orderRequestDto);
    }
    @GetMapping
    List<PurchaseOrder> getAllOreders(){
        return  orderService.getAllPurchaseOrder();
    }
}
