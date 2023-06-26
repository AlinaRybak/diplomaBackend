package com.example.diploma.model;
import jakarta.persistence.*;
import jakarta.servlet.ServletContext;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

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
