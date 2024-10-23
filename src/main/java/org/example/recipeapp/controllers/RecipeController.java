package org.example.recipeapp.controllers;

import jakarta.websocket.server.PathParam;
import org.example.recipeapp.Constants;
import org.example.recipeapp.models.Recipe;
import org.example.recipeapp.models.ResponseEntity;
import org.example.recipeapp.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/all-recipes")
    @Cacheable(value = "all_recipes", key = "#root.methodName")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return new ResponseEntity<>("fetched all recipes", HttpStatus.OK.toString(), recipeService.getAllRecipes());
    }

    @GetMapping("/get-recipe-by-name")
    @Cacheable(value = "recipe_by_name", key = "#name")
    public ResponseEntity<List<Recipe>> getRecipeByName(@PathParam("name") String name) {
        return new ResponseEntity<>("fetched recipe by name", HttpStatus.OK.toString(), recipeService.getRecipesByName(name));
    }

    @PostMapping("/add-recipe")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        Recipe response =  recipeService.addRecipe(recipe);
        String message = response != null ? Constants.RECIPE_ADDED_SUCCESSFULLY : Constants.RECIPE_ALREADY_EXISTS;
        return new ResponseEntity<>(message, HttpStatus.CREATED.toString(),response);
    }

    @PutMapping("/update-recipe")
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe) {
        return new ResponseEntity<>("updated successfuly", HttpStatus.OK.toString(), recipeService.updateRecipe(recipe.getRecipeId(), recipe));
    }

    @DeleteMapping("/delete-recipe/{recipe_id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable("recipe_id") UUID recipe_id) {
        recipeService.deleteRecipe(recipe_id);
        return new ResponseEntity<>("deleted successfuly", HttpStatus.OK.toString(), null);
    }
}
