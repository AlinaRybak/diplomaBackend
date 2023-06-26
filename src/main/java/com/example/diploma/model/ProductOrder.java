package com.example.diploma.model;
import jakarta.persistence.*;
import lombok.Data;

    @Entity
    @Table(name = "order_product")
    @Data
    public class ProductOrder {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;
        private double price;
        private int count;
    }


