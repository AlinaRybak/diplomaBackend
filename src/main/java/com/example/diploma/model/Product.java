package com.example.diploma.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "text", columnDefinition="TEXT")
    private String description;
    @Lob
    private byte[] image;

    private double price;


}
