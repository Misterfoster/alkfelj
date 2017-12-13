package com.alkfejl.hu.Beadando.models;

/**
 * Created by D on 2017. 12. 05..
 */
public class Ingredient {
    private String id;
    private String name;
    private String unit;
    private double amount;

    public Ingredient(String name, String unit, double amount) {
        this.name = name;
        this.unit = unit;
        this.amount = amount;
    }

    public Ingredient(String id, String name, String unit, double amount) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ingredient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", amount=" + amount +
                '}';
    }
}
