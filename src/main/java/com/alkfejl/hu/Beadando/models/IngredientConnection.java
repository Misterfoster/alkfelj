package com.alkfejl.hu.Beadando.models;

/**
 * Created by D on 2017. 12. 05..
 */
public class IngredientConnection {
    private long recipeId;
    private long ingredientId;
    private int amount;
    private String unit;

    public IngredientConnection(long recipeId, long ingredientId, int amount, String unit) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.amount = amount;
        this.unit = unit;
    }

    public IngredientConnection() {
    }

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }

    public long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "IngredientConnection{" +
                "recipeId=" + recipeId +
                ", ingredientId=" + ingredientId +
                ", amount=" + amount +
                ", unit='" + unit + '\'' +
                '}';
    }
}
