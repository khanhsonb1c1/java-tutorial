package com.example.demo_CRUL.service;

import com.example.demo_CRUL.dto.request.UserCreationRequest;
import com.example.demo_CRUL.dto.request.UserUpdateRequest;
import com.example.demo_CRUL.entity.User;
import com.example.demo_CRUL.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setBirthDate(request.getBirthDate());

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public  User findUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    public User updateUser(String userId, UserUpdateRequest request) {
        User user = findUserById(userId);

        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setBirthDate(request.getBirthDate());

        return userRepository.save(user);

    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
