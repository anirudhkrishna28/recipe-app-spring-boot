package org.example.recipeapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String user_id;
    private String username;
    private String password;
    private List<String> recipe_ids;
}
