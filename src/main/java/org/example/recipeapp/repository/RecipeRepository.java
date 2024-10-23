//package org.example.recipeapp.repository;
//
//import lombok.extern.slf4j.Slf4j;
//import org.example.recipeapp.models.Recipe;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Repository;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Slf4j
//@Repository
//public class RecipeRepository {
//
//    private static final Logger log = LoggerFactory.getLogger(RecipeRepository.class);
//
//    @Autowired
//    Environment env;
//
//    public List<Recipe> getAllRecipes() {
//        String query = "SELECT * FROM recipes";
//        List<Recipe> recipes = new ArrayList<>();
//        try (Connection connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"), env.getProperty("spring.datasource.password"))) {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            log.info("query {}", query);
//
//            while(resultSet.next()){
//                Recipe recipe = new Recipe();
//                recipe.setName(resultSet.getString("name"));
//                recipe.setRecipe_id(resultSet.getString("recipe_id"));
//                recipe.setIngredients(resultSet.getString("ingredients"));
//                recipe.setInstructions(resultSet.getString("instructions"));
//                recipe.setImage_url(resultSet.getString("image_url"));
//                recipe.setCooking_time(resultSet.getString("cooking_time"));
//                recipe.setUser_id(resultSet.getString("user_id"));
//                recipe.setCreated_at(new Date(resultSet.getTimestamp("created_at").getTime()));
//                recipes.add(recipe);
//            }
//
//            log.info("recipes of size {}", recipes.size());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return recipes;
//    }
//}
