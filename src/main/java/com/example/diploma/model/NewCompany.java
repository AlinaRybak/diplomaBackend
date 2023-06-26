package com.example.diploma.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "companies")
@Data
public class NewCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
}
