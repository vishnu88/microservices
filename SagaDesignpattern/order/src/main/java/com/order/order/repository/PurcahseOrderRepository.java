package com.order.order.repository;

import com.order.order.entities.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurcahseOrderRepository extends JpaRepository<PurchaseOrder,Integer> {
}
