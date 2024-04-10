package com.order.order.event;

import com.order.order.dto.OrderRequestDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
public class OrderEvent implements Event {

    private UUID eventId = UUID.randomUUID();

    private Date date =  new Date();
    private OrderRequestDto orderRequest;
    private OrderStatus orderStatus;

    @Override
    public UUID getEventId() {
        return eventId;
    }

    @Override
    public Date getEventDate() {
        return date;
    }

    public OrderEvent(OrderRequestDto orderRequest, OrderStatus orderStatus) {
        this.orderRequest = orderRequest;
        this.orderStatus = orderStatus;
    }
}
