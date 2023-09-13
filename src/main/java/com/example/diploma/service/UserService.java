package com.example.diploma.service;

import com.example.diploma.exception.UserNotFoundException;
import com.example.diploma.exception.UserRegistrationException;
import com.example.diploma.model.User;
import com.example.diploma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserRegistrationException("A user with this email already exists");
        }
        userRepository.save(user);
        return user;
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("No user found with this ID"));
    }

    public User updateUser(Long userId, User updatedUser) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("No user found with this ID"));

        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setName(updatedUser.getName());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());

        userRepository.save(existingUser);
        return existingUser;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

