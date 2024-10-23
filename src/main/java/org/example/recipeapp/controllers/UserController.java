package org.example.recipeapp.controllers;

import org.example.recipeapp.Constants;
import org.example.recipeapp.models.AppUser;
import org.example.recipeapp.models.ResponseEntity;
import org.example.recipeapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser user) {
        var response = userService.addUser(user);
        HttpStatus status = Constants.USER_ADDED_SUCCESSFULLY.equals(response.getFirst()) ? HttpStatus.CREATED : HttpStatus.CONFLICT;
        return new ResponseEntity<>(response.getFirst(),status.toString(), response.getSecond());
    }
}
