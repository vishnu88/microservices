package com.order.order.event;

import com.order.order.dto.PaymentRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class PaymentEvent implements  Event {

    private UUID eventId = UUID.randomUUID();

    private Date date =  new Date();

    private PaymentRequestDto paymentRequest;

    private PaymentStatus paymentStatus;


    @Override
    public UUID getEventId() {
        return eventId;
    }

    @Override
    public Date getEventDate() {
        return date;
    }

    public PaymentEvent(PaymentRequestDto paymentRequest, PaymentStatus paymentStatus) {
        this.paymentRequest = paymentRequest;
        this.paymentStatus = paymentStatus;
    }

}
