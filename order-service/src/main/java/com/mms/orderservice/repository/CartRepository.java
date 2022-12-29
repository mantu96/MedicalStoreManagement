package com.mms.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mms.orderservice.entity.Cart;

@Repository
public interface CartRepository  extends JpaRepository<Cart, Long>{
    
  public Cart findCartByCartId(Long cartId);

  public Cart findCartByProductId(Long userId);

  public List<Cart> findCartByUserId(Long productId);
}
