package com.alkfejl.hu.Beadando.models;

import java.util.List;

/**
 * Created by D on 2017. 12. 05..
 */
public class IngredientConnection {
   private String id;
   private List<Ingredient> ingredients;

    public IngredientConnection(String id, List<Ingredient> ingredients) {
        this.id = id;
        this.ingredients = ingredients;
    }

    public IngredientConnection() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "IngredientConnection{" +
                "id='" + id + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
