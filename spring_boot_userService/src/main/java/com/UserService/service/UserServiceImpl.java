package com.UserService.service;

import com.UserService.model.User;
import com.UserService.pollFiegnClient.PollService;
import com.UserService.repository.UserRepository;
import org.apache.tomcat.jni.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{



    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PollService pollService;


    @Override
    public Long createUser(User user) {

        return userRepository.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);

    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteUserById(id);
        pollService.deleteAllUserAnswersByUserId(id);

    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User registerUser(Long userId) {
        return userRepository.registerUser(userId);
    }

    @Override
    public Boolean isUserRegistered(Long userId) {

        User user = userRepository.getUserById(userId);
        return user != null && user.getStatus();
    }

}
