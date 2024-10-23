package org.example.recipeapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntity<T> {
    private String message;
    private String status;
    private T data;

}
