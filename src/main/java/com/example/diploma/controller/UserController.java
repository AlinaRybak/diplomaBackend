package com.example.diploma.controller;
import com.example.diploma.model.NewCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.diploma.service.UserService;
import com.example.diploma.model.User;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/register")
    public ResponseEntity<List<User>> getUsersInfo() {
        List<User> userInfoList = userService.getUsersInfo();
        return ResponseEntity.ok(userInfoList);
    }

}


