package com.mms.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mms.userservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    public User findByUsername(String username);

    public void deleteByUsername(String username);

    public List<User> findAll();
}
