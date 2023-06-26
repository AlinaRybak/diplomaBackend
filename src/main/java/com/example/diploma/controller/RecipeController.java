package com.example.diploma.controller;
import com.example.diploma.model.Recipe;
import com.example.diploma.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/recipes")
    public class RecipeController {
        private RecipeService recipeService;

        @Autowired
        public RecipeController(RecipeService recipeService) {
            this.recipeService = recipeService;
        }

        @GetMapping
        public ResponseEntity<List<Recipe>> getAllRecipes() {
            List<Recipe> recipes = recipeService.getAllRecipes();
            return ResponseEntity.ok(recipes);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Recipe> getAdviceById(@PathVariable("id") Long id) {
            Optional<Recipe> recipe = recipeService.getRecipeById(id);
            return recipe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public ResponseEntity<String> createRecipe(@RequestParam("title") String title,
                                                   @RequestParam("description") String description,
                                                   @RequestParam("image") MultipartFile image) {
            Recipe recipe = new Recipe();
            recipe.setTitle(title);
            recipe.setDescription(description);

            try {
                byte[] imageData = image.getBytes();
                recipe.setImage(imageData);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to read image file");
            }

            recipeService.saveRecipe(recipe);
            return ResponseEntity.ok("Recipe created successfully");
        }

        @ExceptionHandler(IOException.class)
        public ResponseEntity<String> handleIOException(IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to read image file");
        }

        @PutMapping("/{id}")
        public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") Long id, @RequestBody Recipe recipe) {
            Optional<Recipe> existingRecipe = recipeService.getRecipeById(id);
            if (existingRecipe.isPresent()) {
                recipe.setId(id);
                Recipe updatedRecipe = recipeService.saveRecipe(recipe);
                return ResponseEntity.ok(updatedRecipe);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteRecipe(@PathVariable("id") Long id) {
            recipeService.deleteRecipeById(id);
            return ResponseEntity.noContent().build();
        }
    }

