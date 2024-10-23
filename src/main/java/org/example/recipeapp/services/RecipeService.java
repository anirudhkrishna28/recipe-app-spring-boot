package org.example.recipeapp.services;

import jakarta.transaction.Transactional;
import org.example.recipeapp.models.Recipe;
import org.example.recipeapp.repository.RecipeRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeService {


    @Autowired
    private RecipeRepositoryJpa recipeRepositoryJpa;

    public List<Recipe> getAllRecipes() {
        return recipeRepositoryJpa.getAllRecipes();
    }

    public List<Recipe> getRecipesByName(String name) {
        return recipeRepositoryJpa.findRecipeByLike(name);
    }

    public Recipe addRecipe(Recipe recipe) {
      List<Recipe> recipesByUser_id = recipeRepositoryJpa.getRecipesByUser_id(recipe.getUser_id());

        if(recipesByUser_id.stream().anyMatch(r -> r.getName().equalsIgnoreCase(recipe.getName()))) {
            return null;
        }
        else{
           return recipeRepositoryJpa.save(recipe);
        }
    }

    public Recipe updateRecipe(UUID recipe_id, Recipe recipe) {
        Optional<Recipe> existingRecipe = recipeRepositoryJpa.findById(recipe_id);
        if (existingRecipe.isPresent()) {
            Recipe existing = existingRecipe.get();
            existing.setRecipeId(recipe.getRecipeId());
            existing.setName(recipe.getName());
            existing.setIngredients(recipe.getIngredients());
            existing.setInstructions(recipe.getInstructions());
            existing.setCooking_time(recipe.getCooking_time());
            existing.setCreated_at(new Date());
            existing.setImage_url(recipe.getImage_url());
            existing.setTags(recipe.getTags());
            existing.setUser_id(recipe.getUser_id());
            return recipeRepositoryJpa.save(existing);
        }
            return recipeRepositoryJpa.save(recipe);
    }
    @Transactional
    public void deleteRecipe(UUID recipe_id) {
        recipeRepositoryJpa.deleteById(recipe_id);
    }
}
