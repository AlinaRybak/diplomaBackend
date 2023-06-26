package com.example.diploma.controller;

import com.example.diploma.model.Product;
import com.example.diploma.service.ProductService;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ServletContext servletContext;

    @Autowired
    public ProductController(ProductService productService, ServletContext servletContext) {
        this.productService = productService;
        this.servletContext = servletContext;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestParam("title") String title,
                                                @RequestParam("description") String description,
                                                @RequestParam("image") MultipartFile image,
                                                @RequestParam("price") Double price) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);

        try {
            byte[] imageData = image.getBytes();
            product.setImage(imageData);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to read image file");
        }

        productService.saveProduct(product);
        return ResponseEntity.ok("Product created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        Optional<Product> existingProduct = productService.getProductById(id);
        if (existingProduct.isPresent()) {
            product.setId(id);
            Product updatedProduct = productService.saveProduct(product);
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
}
