package com.example.diploma.service;
import com.example.diploma.model.User;
import com.example.diploma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
    public class UserService {
        private final UserRepository userRepository;

        @Autowired
        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public User save(User user) {
        if (user.getPhoneNumber() == null || user.getPhoneNumber().isEmpty()) {
            user.setPhoneNumber("DEFAULT_PHONE_NUMBER");
        }
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

    public Optional<User> getUserById(Long id) {

        return userRepository.findById(id);
    }

    public User findByNameAndPassword(String name, String password) {
        return userRepository.findByNameAndPassword(name, password);
    }
    }

