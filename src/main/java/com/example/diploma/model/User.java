package com.example.diploma.model;
import jakarta.persistence.*;
import lombok.Data;

    @Entity
    @Table(name = "users")
    @Data
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String phoneNumber;
        private String email;
        private String password;

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }

