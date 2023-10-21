package com.UserService.service;

import com.UserService.model.User;

public interface UserService {


    Long createUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);

    User getUserById(Long id);
    User registerUser(Long userId);

    Boolean isUserRegistered(Long userId);

}
