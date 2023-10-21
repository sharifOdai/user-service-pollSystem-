package com.UserService.repository;


import com.UserService.model.User;

public interface UserRepository {
    Long createUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);
    User getUserById(Long id);
    User registerUser(Long userId);

}
