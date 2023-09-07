package com.example.diploma.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_order")
@Data
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Інші поля

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}



