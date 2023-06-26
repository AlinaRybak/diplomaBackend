package com.example.diploma.service;
import com.example.diploma.model.Recipe;
import com.example.diploma.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    public Recipe saveRecipe(Recipe advice) {
        return recipeRepository.save(advice);
    }

    public void deleteRecipeById(Long id) {
        recipeRepository.deleteById(id);
    }

}
