package com.vishnu.userservice.services;

import com.vishnu.userservice.entities.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface UserService {
    User getUser(String id);


    @Cacheable("AllUser")
    List<User> getAllUsers();

    @CachePut(value = "AllUser")
    User saveUser(User user);

}
