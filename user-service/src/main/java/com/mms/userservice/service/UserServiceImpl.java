package com.mms.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.userservice.entity.User;
import com.mms.userservice.exception.UserAlreadyExistsException;
import com.mms.userservice.exception.UserNotFoundException;
import com.mms.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(User user) {

        // Checking if user with username exists
        User existedUser =userRepository.findByUsername(user.getUsername());
       
        if(existedUser != null){
            //Throw UsernameAlradyExistsException
            throw new UserAlreadyExistsException("user with username "+user.getUsername() + " already Exists");
        }

        return userRepository.save(user);
    }

    @Override
    public User updateuser(User user) {

        // Checking if user Exists
        User oldUser = userRepository.findByUsername(user.getUsername());
            user.setUserId(oldUser.getUserId());
            oldUser =user;
            return userRepository.save(oldUser);

    }

    @Override
    public User findUser(String username) {
        // Checking if user Exists
        User existedUser = userRepository.findByUsername(username);
        if(existedUser == null){

            //Throw UserNotFoundException
            throw new  UserNotFoundException("user not found with username "+username);
        }
        return existedUser;
    }

    @Override
    public List<User> findAllUser() {
        // Fetching all users
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public void deleteUser(String username) {
        // TODO Auto-generated method stub
        User fetchedUser = userRepository.findByUsername(username);

        if(fetchedUser == null){

            //Throw UserNotFoundException
            throw new  UserNotFoundException("user not found with username "+username);
        }
        userRepository.delete(fetchedUser);
    }
    
}
