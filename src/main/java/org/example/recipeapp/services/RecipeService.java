package org.example.recipeapp.services;

import org.example.recipeapp.models.Recipe;
import org.example.recipeapp.repository.RecipeRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return recipeRepositoryJpa.save(recipe);
    }

    public Recipe updateRecipe(Long recipe_id, Recipe recipe) {
        return recipeRepositoryJpa.updateRecipeByRecipeId(recipe_id, recipe);
    }
}
