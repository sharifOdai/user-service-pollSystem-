package com.UserService.controller;


import com.UserService.model.User;
import com.UserService.service.UserService;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user){
        userService.createUser(user);
        return ResponseEntity.ok("user create success");
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
        System.out.println("user update success");
    }

    @PutMapping("/register-user")
    public ResponseEntity<String> registerUser(@RequestParam (name = "userId") Long userId){
        Boolean isUserRegistered = userService.registerUser(userId).getStatus();
        if (!isUserRegistered){
            return ResponseEntity.ok("user with ID " + userId + " registered" );
        }else {
            return ResponseEntity.ok("user with ID " + userId + " is already registered ");
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long userId){
        userService.deleteUserById(userId);
        return ResponseEntity.ok("user delete success");
    }


    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) throws JsonProcessingException {
        User user = userService.getUserById(userId);
        System.out.println("Retrieved user: " + user); // Log the user data
        return user;
    }

    @GetMapping("/check-registration/{userId}")
    public ResponseEntity<Boolean> checkUserRegistration(@PathVariable Long userId){
        Boolean isUserRegistered = userService.isUserRegistered(userId);
        if (isUserRegistered){
            return ResponseEntity.ok(true);
        }else {
            return ResponseEntity.ok(false);

        }
    }
}
