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

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public void changePassword(String newPassword) {
    }

    public boolean checkPassword(String passwordToCheck) {
        return passwordToCheck.equals(this.password);
    }

    public Profile getProfile() {
        return this.profile;
    }

    public void updateProfile(Profile newProfile) {
        this.profile = newProfile;
    }

    public void deleteAccount() {
    }
}