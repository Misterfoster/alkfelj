package com.alkfejl.hu.Beadando.models;

/**
 * Created by D on 2017. 12. 05..
 */
public class Recipe {
    private long id;
    private String name;
    private String directions;
    private String prepTime;
    private String cookTime;
    private String ownerName;

    public Recipe(long id, String name, String directions, String prepTime, String cookTime, String ownerName) {
        this.id = id;
        this.name = name;
        this.directions = directions;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.ownerName = ownerName;
    }
    public Recipe(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getPrepTimeInSeconds(){

        long seconds = 0;
        seconds+=Long.parseLong(prepTime.split(":")[2]);
        seconds+=Long.parseLong(prepTime.split(":")[1])*60;
        seconds+=Long.parseLong(prepTime.split(":")[0])*60*60;

        return seconds;
    }

public long getCookTimeInSeconds(){

        long seconds = 0;
        seconds+=Long.parseLong(cookTime.split(":")[2]);
        seconds+=Long.parseLong(cookTime.split(":")[1])*60;
        seconds+=Long.parseLong(cookTime.split(":")[0])*60*60;

        return seconds;
    }

    public long getFullTime(){
        return getPrepTimeInSeconds()+getCookTimeInSeconds();
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", directions='" + directions + '\'' +
                ", prepTime='" + prepTime + '\'' +
                ", cookTime='" + cookTime + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
