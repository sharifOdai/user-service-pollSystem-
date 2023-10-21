package com.UserService.controller;

import com.UserService.pollFiegnClient.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pollService")
public class pollServiceController {
    @Autowired
    private PollService pollService;

    @DeleteMapping("/delete-all-user-answers/{userId}")
    void deleteAllUserAnswersByUserId(@PathVariable Long userId){
        pollService.deleteAllUserAnswersByUserId(userId);
    }

}

