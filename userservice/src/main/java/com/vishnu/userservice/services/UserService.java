package com.vishnu.userservice.services;

import com.vishnu.userservice.entities.User;

import java.util.List;

public interface UserService {
    User getUser(String id);
    List<User> getAllUsers();

    User saveUser(User user);

}
