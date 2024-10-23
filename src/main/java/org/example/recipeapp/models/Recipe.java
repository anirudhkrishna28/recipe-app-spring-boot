package org.example.recipeapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Recipe implements Serializable {

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recipeId;
    private String ingredients;
    private String instructions;
    private String image_url;
    private String cooking_time;
    private String user_id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    @PrePersist
    protected void onCreate() {
        created_at = new Date();
    }
    @ElementCollection
    private List<String> tags;

}
