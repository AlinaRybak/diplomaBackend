package com.example.diploma.repository;

import com.example.diploma.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
        User findByEmail(String email);

    User findByNameAndPassword(String name, String password);

}


