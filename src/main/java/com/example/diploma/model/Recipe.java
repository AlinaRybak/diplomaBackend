package com.example.diploma.model;
import jakarta.persistence.*;
import lombok.Data;


    @Entity
    @Table(name = "recipes")
    @Data
    public class Recipe {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;

        @Column(name = "text", columnDefinition="TEXT")
        private String description;
        @Lob
        private byte[] image;
}
