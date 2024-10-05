package com.example.demo_CRUL.controller;

import com.example.demo_CRUL.dto.request.UserCreationRequest;
import com.example.demo_CRUL.dto.request.UserUpdateRequest;
import com.example.demo_CRUL.entity.User;
import com.example.demo_CRUL.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable String userId) {
        return userService.findUserById(userId);
    }

    @PostMapping("/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }

}
