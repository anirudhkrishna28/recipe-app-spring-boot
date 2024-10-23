package org.example.recipeapp.services;

import org.example.recipeapp.Constants;
import org.example.recipeapp.models.AppUser;
import org.example.recipeapp.repository.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepositoryJpa userRepositoryJpa;

    public Pair<String, AppUser> addUser(AppUser user) {
        Optional<AppUser> existingUser = Optional.ofNullable(userRepositoryJpa.findUserByEmail(user.getEmail()));
        if (existingUser.isPresent()) {
            return Pair.of(Constants.USER_ALREADY_EXISTS,existingUser.get());
        }
        else{
            return Pair.of(Constants.USER_ADDED_SUCCESSFULLY,userRepositoryJpa.save(user));
        }
    }



}
