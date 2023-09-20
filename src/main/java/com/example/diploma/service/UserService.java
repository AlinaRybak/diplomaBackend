package com.example.diploma.service;
import com.example.diploma.model.NewCompany;
import com.example.diploma.model.User;
import com.example.diploma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class UserService {
        private final UserRepository userRepository;

        @Autowired
        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public User save(User user) {
            return userRepository.save(user);
        }

    public List<User> getUsersInfo() {
        List<User> userInfoList = userRepository.findAll();

        return userInfoList;
    }

        public User registerUser(User user) {
            if (userRepository.findByEmail(user.getEmail()) != null) {
                throw new RuntimeException("A user with this email already exists");
            }

            return userRepository.save(user);
        }
    }

