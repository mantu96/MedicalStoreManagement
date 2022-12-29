package com.mms.userservice.web;

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

import com.mms.userservice.entity.User;
import com.mms.userservice.service.UserService;

@RestController
@RequestMapping("/userservice/api")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        User registeredUser = userService.registerUser(user);
        return new ResponseEntity<User>(registeredUser, HttpStatus.CREATED);
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        User updatedUser = userService.updateuser(user);
        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<?> findUser(@PathVariable String username){
        User fetchedUser = userService.findUser(username);
        return new ResponseEntity<User>(fetchedUser, HttpStatus.OK);
    }

    @GetMapping("/allusers")
    public ResponseEntity<?> findAllUsers(){
        List<User> users = userService.findAllUser();
        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username){
        
        userService.deleteUser(username);
        return new ResponseEntity<String>("User "+username+" deleted Successfully",HttpStatus.OK);
    }
}
