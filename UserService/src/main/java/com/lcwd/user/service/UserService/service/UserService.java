package com.lcwd.user.service.UserService.service;

import com.lcwd.user.service.UserService.entities.User;

import java.util.List;

public interface UserService {

    // user operations
    User saveUser(User user);
    // get all user
    List<User> getAllUser();

    // get single user of given userId
    User getUser(String userId);

    void deleteUser(String userId);
    void updateUser(String userId,User user);

}
