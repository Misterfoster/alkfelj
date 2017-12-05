package com.alkfejl.hu.Beadando.models;

import java.util.List;
import java.util.Map;

/**
 * Created by D on 2017. 12. 06..
 */
public class FullRecipe {

    private String name;
    private String directions;
    private Map<Ingredient,IngredientConnection> ingredients;
    private String owner;
    private List<Comment> comments;
    private Recipe recipe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Map<Ingredient, IngredientConnection> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<Ingredient, IngredientConnection> ingredients) {
        this.ingredients = ingredients;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
