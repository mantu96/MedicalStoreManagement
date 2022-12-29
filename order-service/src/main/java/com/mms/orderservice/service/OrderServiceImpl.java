package com.mms.orderservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.orderservice.entity.Bill;
import com.mms.orderservice.entity.Cart;
import com.mms.orderservice.entity.Order;
import com.mms.orderservice.exception.CartAlreadyExistsException;
import com.mms.orderservice.exception.CartNotFoundException;
import com.mms.orderservice.exception.OrderNotFoundException;
import com.mms.orderservice.repository.BillRepository;
import com.mms.orderservice.repository.CartRepository;
import com.mms.orderservice.repository.OrderRepository;

@Service
public class OrderServiceImpl  implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BillRepository billRepository ;

    @Override
    public Order placeOrder(Order order) {

        // saving the order to database
        Order placedOrder = orderRepository.save(order);

        //Generating Bill
        Bill bill = new Bill();
        bill.setOrderId(placedOrder.getOrderId());
        bill.setBillAmount(placedOrder.getTotalAmount());

        //to get the product name from the product service
        //by using the order Object
        //bill.setParticular();

        billRepository.save(bill);

        //Returning the order
        return placedOrder;
    }

    @Override
    public Order viewOrder(Long orderId) {
        // Fetching order from database
        Order fetchedOrder = orderRepository.findOrderByOrderId(orderId);
        
        //Checking if Order Exists
        if(fetchedOrder == null){
            throw new OrderNotFoundException("Order not found with orderId : "+orderId);
        }

        //Returning the Order
        return fetchedOrder;
    }

    @Override
    public List<Order> viewAllCustomerOrder(Long customerId) {
        // Fetching Order List from database
        List<Order> orders = new ArrayList<>();
        orders = orderRepository.findOrderByUserId(customerId);
        
        //Returning Order List
        return orders;
    }

    @Override
    public List<Order> viewAllOrders() {
        // Fetching All Order Listfrom database
        List<Order> orders = new ArrayList<>();
        orders = orderRepository.findAll();

        //Returning Order List
        return orders;
    }

    @Override
    public Order updateOrder(Order order) {
        // Updating the Order
        Order updatedOrder = orderRepository.save(order);

        //Returning Updated Order
        return updatedOrder;
    }

    @Override
    public void cancelOrder(Long orderId) {
        // Fetching Order from database
        Order order = orderRepository.findOrderByOrderId(orderId);

        //Checking if Order Exists
        if(order == null){
            throw new OrderNotFoundException("Order not found with Order Id : "+orderId);
        } 

        //Deleting the Order
        orderRepository.deleteById(orderId);
        
    }

    @Override
    public Cart addToCart(Cart cart) {
       
        Cart fetchedCart =  cartRepository.findCartByProductId(cart.getProductId());
        if(fetchedCart != null){
            //Throw CartAlreadyExistsException
            throw  new CartAlreadyExistsException("Product Item Already Exists in the Cart");
        }
        // Saving Cart to Database
        Cart savedCart = cartRepository.save(cart);

        //Returning Saved Cart 
        return savedCart;
    }

    @Override
    public Cart viewCart(Long cartId) {
        // Fetching Cart
        Cart fetchedCart = cartRepository.findCartByCartId(cartId);

        //Checking if Cart Exists
        if(fetchedCart == null){
            //Throw CartNotFoundException
            throw  new CartNotFoundException("Cart with Id "+ cartId+" does not Exists");
        }
        //Returning Cart 
        return fetchedCart;
    }

    @Override
    public List<Cart> viewAllCartByCustomer(Long userId) {
        // Fetching Cart
        List<Cart> cart = cartRepository.findCartByUserId(userId);

        //Returning Cart
        return cart;
    }

    @Override
    public void deleteCart(Long cartId) {
        // Fetching Cart
        Cart fetchedCart = cartRepository.findCartByCartId(cartId);

        //Checking if CartExists
        if(fetchedCart == null){
            //CartNotFoundException
            throw  new CartNotFoundException("Cart with Id "+ cartId+" does not Exists");
        }
        
        //Deleting the Cart
        cartRepository.deleteById(cartId);
    }

    @Override
    public Bill viewBill(Long orderId) {
        // Fetching the Bill
        Bill bill =  billRepository.findBillByorderId(orderId);

        //Returning Bill
        return bill;
    }
    

}
