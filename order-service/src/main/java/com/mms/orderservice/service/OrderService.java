package com.mms.orderservice.service;

import java.util.List;

import com.mms.orderservice.entity.Bill;
import com.mms.orderservice.entity.Cart;
import com.mms.orderservice.entity.Order;

/**
 * All the Business Logic will be applied in this class
 */
public interface OrderService {
    
    /**
    This Method is used to place Order in the System
    @param order details to be placed
    @return placed order details
     */
    public Order placeOrder(Order order);

    /**
     * This method is used to view the Order
     * @param orderId of the Order
     * @return the order details
     */
    public Order viewOrder(Long orderId);
    
    /**
     * This method is used to view all Order of a specific user
     * @param customerId of ther user
     * @return all the orders present
     */
    public List<Order> viewAllCustomerOrder(Long customerId);

    /**
     * This method is used to get all the orders available in the system
     * @return the list of orders
     */
    public List<Order> viewAllOrders();
    
    /**
     * This method is used to update the order
     * @param order to be updated
     * @return the updated order
     */
    public Order updateOrder(Order order);

    /**
     * This method is used to cancel the order
     * @param orderId  of the order
     */
    public void cancelOrder(Long orderId);

    /**
     * This method is used tp add the cart in the database
     * @param cart to be saved 
     * @return the saved cart
     */
    public Cart addToCart(Cart cart);

    /**
     * This method is used to view the cart drom the database
     * @param cartId of the Cart
     * @return the Cart
     */
    public Cart viewCart(Long cartId);

    /**
     * This method is used to view all the cart present for specifdic user
     * @param userId of the Customer
     * @return the list of the carts 
     */
    public List<Cart> viewAllCartByCustomer(Long userId);

    /**
     * This method is used to delete the cart from the Database
     * @param cartId of thr cart
     */
    public void deleteCart(Long cartId);

    /**
     * This method is used to view the Bill
     * @param orderId of the Bill
     * @return the bill
     */
    public Bill viewBill(Long orderId);
}

