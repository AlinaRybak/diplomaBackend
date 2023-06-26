package com.example.diploma.repository;
import com.example.diploma.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    }


