package org.example.recipeapp.repository;

import org.example.recipeapp.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RecipeRepositoryJpa extends JpaRepository<Recipe, UUID> {

    @Query(value = "SELECT * FROM recipe", nativeQuery = true)
    List<Recipe> getAllRecipes();

    @Query(value = "SELECT * FROM recipe WHERE name ILIKE %?1% ", nativeQuery = true)
    List<Recipe> findRecipeByLike(String name);

    @Query(value = "SELECT * FROM recipe WHERE user_id = ?1", nativeQuery = true)
    List<Recipe> getRecipesByUser_id(UUID user_id);



}
