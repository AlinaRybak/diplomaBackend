package com.example.diploma.service;

import com.example.diploma.model.User;

public interface UserService {
    User registerUser(User user);
    User loginUser(String username, String password);
}

