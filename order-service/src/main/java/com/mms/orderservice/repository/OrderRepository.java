package com.mms.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mms.orderservice.entity.Order;

/**
 * This is the Repository Layer used to interact with the database
 */
@Repository
public interface OrderRepository  extends JpaRepository< Order,Long >{
 
    public Order findOrderByOrderId(long orderId);

    public List<Order> findOrderByUserId(long userId);

}
