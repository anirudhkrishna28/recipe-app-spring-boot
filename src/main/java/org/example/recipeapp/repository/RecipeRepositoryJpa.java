package org.example.recipeapp.repository;

import org.example.recipeapp.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepositoryJpa extends JpaRepository<Recipe, Long> {

    @Query(value = "SELECT * FROM recipe", nativeQuery = true)
    List<Recipe> getAllRecipes();

    @Query(value = "SELECT * FROM recipe WHERE name ILIKE %?1% ", nativeQuery = true)
    List<Recipe> findRecipeByLike(String name);

    Recipe updateRecipeByRecipeId(Long recipe_id, Recipe recipe);



}
