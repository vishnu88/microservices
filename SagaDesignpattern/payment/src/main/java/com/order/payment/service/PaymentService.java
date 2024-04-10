package com.order.payment.service;


import com.order.order.dto.OrderRequestDto;
import com.order.order.dto.PaymentRequestDto;
import com.order.order.event.OrderEvent;
import com.order.order.event.PaymentEvent;
import com.order.order.event.PaymentStatus;
import com.order.payment.entity.UserBalance;
import com.order.payment.entity.UserTransaction;
import com.order.payment.repository.UserBalanceRepository;
import com.order.payment.repository.UserTransactionRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PaymentService {

    @Autowired
    UserBalanceRepository userBalanceRepository;
    @Autowired
    UserTransactionRepository userTransactionRepository;
    @PostConstruct
    public void intUserBalance(){
        userBalanceRepository.saveAll(Stream.of(new UserBalance(101,3000),
                new UserBalance(101,3000),
                new UserBalance(102,4300),
                new UserBalance(103,20000),
                new UserBalance(104,999)).collect(Collectors.toList()));
    }

    @Transactional
    public PaymentEvent newOrderEvent(OrderEvent orderEvent) {
        System.out.println("***********Order Ko Suna Jaa raha ***");
        OrderRequestDto orderRequestDto = orderEvent.getOrderRequest();
        PaymentRequestDto paymentRequestDto = new PaymentRequestDto(orderRequestDto.getOrderId(),orderRequestDto.getUserId(),orderRequestDto.getAmount());

        return userBalanceRepository.findById(orderRequestDto.getUserId()).filter(ub -> ub.getPrice()>orderRequestDto.getAmount()).map(ub->{
            ub.setPrice(ub.getPrice()-orderRequestDto.getAmount());
            userTransactionRepository.save(new UserTransaction(orderRequestDto.getUserId(),orderRequestDto.getOrderId(),orderRequestDto.getAmount()));
            return new PaymentEvent(paymentRequestDto,  PaymentStatus.PAYMENT_COMPLETED);
        }).orElse(new PaymentEvent(paymentRequestDto,PaymentStatus.PAYMENTED_FAILED));
    }

    @Transactional
    public void cancelOrderEvent(OrderEvent orderEvent) {
        userTransactionRepository.findById(orderEvent.getOrderRequest().getOrderId()).
                ifPresent(ut->{userTransactionRepository.delete(ut);
                    userTransactionRepository.findById(ut.getUserId()).
                            ifPresent(ub->ub.setAmount(ub.getAmount()+ut.getAmount()));
                });
    }
}
