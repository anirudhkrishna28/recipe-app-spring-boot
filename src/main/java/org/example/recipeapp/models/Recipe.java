package org.example.recipeapp.models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Transactional
public class Recipe implements Serializable {

    private String name;
    @Id
    @GeneratedValue
    private UUID recipeId;
    private String ingredients;
    private String instructions;
    private String image_url;
    private String cooking_time;
    private UUID user_id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    @PrePersist
    protected void onCreate() {
        created_at = new Date();
    }
    @ElementCollection
    private List<String> tags;

}
