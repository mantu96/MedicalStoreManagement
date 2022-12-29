package com.mms.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mms.orderservice.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    
    public Bill findBillByorderId(Long orderId);
}
