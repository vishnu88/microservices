package com.vishnu.userservice.services.impl;

import com.vishnu.userservice.entities.User;
import com.vishnu.userservice.exception.ResourceNotFoundException;
import com.vishnu.userservice.repositories.UserRepository;
import com.vishnu.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println("this is cashe*********");
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
       String randomId = UUID.randomUUID().toString();
       user.setUserId(randomId);
        return userRepository.save(user);
    }
}
