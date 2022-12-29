package com.mms.userservice.service;

import java.util.List;

import com.mms.userservice.entity.User;

/**
 * This is the Service Layer which contains all the Business Logics
 * @author Mantu
 */
public interface UserService {
    
    /**
     * This method is used to register the new User in the System
     * @param user to be saved
     * @return the registered user
     */
    public User registerUser(User user);

    /**
     * This method is used to update the existing user in the system
     * @param user to be updated
     * @return the updated user
     */
    public User updateuser(User user);

    /**
     * This method is used to find the user 
     * @param username of the user
     * @return the user
     */
    public User findUser(String username);

    /**
     * This method is used to find all the users present in the system 
     * @return
     */
    public List<User> findAllUser();

    /**
     * This method is used to delete the user from the system
     * @param username of the user
     */
    public void deleteUser(String username);

}
