package org.example.recipeapp.repository;

import org.example.recipeapp.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepositoryJpa extends JpaRepository<AppUser, UUID> {
    AppUser findUserByEmail(String email);
}
