package org.example.recipeapp.controllers;

import jakarta.websocket.server.PathParam;
import org.example.recipeapp.models.Recipe;
import org.example.recipeapp.models.ResponseEntity;
import org.example.recipeapp.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return new ResponseEntity<>("added recipe", HttpStatus.CREATED.toString(), recipeService.addRecipe(recipe));
    }

    @PutMapping("/update-recipe/")
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe) {
        return new ResponseEntity<>("updated successfuly", HttpStatus.OK.toString(), recipeService.updateRecipe(recipe.getRecipeId(), recipe));
    }
}
