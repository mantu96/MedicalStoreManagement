package com.mms.orderservice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mms.orderservice.entity.Bill;
import com.mms.orderservice.entity.Cart;
import com.mms.orderservice.entity.Order;
import com.mms.orderservice.service.OrderService;

@RequestMapping("/orderservice/api")
@RestController
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    /*
     * ---------------------------------------------------------------------------
     *                             ORDER MANAGEMENT
     * ---------------------------------------------------------------------------
     */

    @PostMapping("/placeorder")
    public ResponseEntity<?> placeOrder(@RequestBody Order order){

        Order savedOrder = orderService.placeOrder(order);
        return new ResponseEntity<Order> (savedOrder,HttpStatus.CREATED);
    }

    @GetMapping("vieworder/{id}")
    public ResponseEntity<?> getOrder(@PathVariable Long id){

        Order order = orderService.viewOrder(id);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @GetMapping("all/{userId}")
    public ResponseEntity<?> viewCustomersOrder(@PathVariable Long userId){

        List<Order> orders = orderService.viewAllCustomerOrder(userId);
        
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);

    }
    @GetMapping("/allorders")
    public ResponseEntity<?> viewAllOrders(){

        List<Order> orders = orderService.viewAllOrders();
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateOrder(@RequestBody Order order){

        Order updatedOrder = orderService.updateOrder(order);
        return new ResponseEntity<Order>(updatedOrder, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<?> cancelOrder(@PathVariable Long orderId){

        orderService.cancelOrder(orderId);
        return new ResponseEntity<String>("Order deleted Successfully"+ orderId, HttpStatus.OK);
    }

     /*
     * ---------------------------------------------------------------------------
     *                          CART & BILL MANAGEMENT
     * ---------------------------------------------------------------------------
     */

    @PostMapping("/addcart")
    public ResponseEntity<?> addToCart(@RequestBody Cart cart){
        Cart savedCart = orderService.addToCart(cart);
        return new ResponseEntity<Cart>(savedCart, HttpStatus.CREATED);
    }

    @GetMapping("/viewcart/{cartId}")
    public ResponseEntity<?> viewCart(@PathVariable Long cartId){

        Cart fetchedCart = orderService.viewCart(cartId);
        return new ResponseEntity<Cart>(fetchedCart, HttpStatus.OK);
    }

    @GetMapping("/viewall/{userId}")
    public ResponseEntity<?> viewAllCart(@PathVariable Long userId){

        List<Cart> carts = orderService.viewAllCartByCustomer(userId);
        return new ResponseEntity<List<Cart>>(carts, HttpStatus.OK);
    }

    @DeleteMapping("/deletecart/{cartId}")
    public ResponseEntity<?> deleteCart(@PathVariable Long cartId){
        orderService.deleteCart(cartId);
        return new ResponseEntity<String>("Cart deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("/viewbill/{orderId}")
    public ResponseEntity<?> viewBill(@PathVariable Long orderId){

        Bill bill = orderService.viewBill(orderId);
        return new ResponseEntity<Bill>(bill,HttpStatus.OK);  
    }

}

