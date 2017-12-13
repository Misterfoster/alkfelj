package com.alkfejl.hu.Beadando.controllers;

import com.alkfejl.hu.Beadando.BeadandoApplication;
import com.alkfejl.hu.Beadando.models.FullRecipe;
import com.alkfejl.hu.Beadando.models.Ingredient;
import com.alkfejl.hu.Beadando.models.Recipe;
import com.alkfejl.hu.Beadando.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by D on 2017. 12. 05..
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class RecipeController {
    private static final Logger log = LoggerFactory.getLogger(RecipeController.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/recipes")
    public List<Recipe> getRecipes() {

        log.info("Querying for recipes");

        String query="SELECT r.id, r.name as recipe_name, r.directions, r.preptime, r.cooktime, u.username as recipe_by from ingredients i, rec_ing ri, recipes r, users u\n" +
                "where 1=1\n" +
                "and u.id = r.owner_id\n" +
                //"and r.id = 1\n"+
                "group by r.name";

        List<Recipe> recipes = new ArrayList<>();
        jdbcTemplate.query(query,
                (rs, rowNum) ->
                        new Recipe(rs.getLong("id"), rs.getString("recipe_name"), rs.getString("directions"),
                                rs.getString("preptime"), rs.getString("cooktime"),rs.getString("recipe_by"))
        ).forEach(recipe -> {
            log.info(recipe.toString());
            recipes.add(recipe);
        });
        return recipes;
    }

    @RequestMapping(value="/queryByIngredient", method = RequestMethod.POST)
    public List<Recipe> queryForRecipes(@RequestBody List<Ingredient> ingredientParam) {

        log.info("Querying for recipes by ingredients");

        String query = "SELECT r.id, r.name as recipe_name, r.directions, r.preptime, r.cooktime, u.username as recipe_by from ingredients i, rec_ing ri, recipes r, users u\n" +
                        "where 1=1\n" +
                        "and u.id = r.owner_id\n" +
                        "and ri.rec_id = r.id\n" +
                        "and ri.ing_id = i.id\n";

                for (Ingredient i : ingredientParam){
                    query+= "and r.id in (select r.id from ingredients i, rec_ing ri, recipes r where 1=1 and i.name like '%"+ i.getName() + "%' and ri.rec_id = r.id and ri.ing_id = i.id)\n";
                }

                query+="group by r.name";

        log.info("running query: " + query);

        List<Recipe> recipes = new ArrayList<>();
        jdbcTemplate.query(query,
                (rs, rowNum) ->
                        new Recipe(rs.getLong("id"), rs.getString("recipe_name"), rs.getString("directions"),
                                rs.getString("preptime"), rs.getString("cooktime"),rs.getString("recipe_by"))
        ).forEach(recipe -> {
            log.info(recipe.toString());
            recipes.add(recipe);
        });
        return recipes;
    }

    @RequestMapping("/getrecipebyid")
    public Recipe getRecipeById(@RequestBody String id) {

        log.info("Querying for recipes with id:"+id);

        String query="SELECT r.id, r.name as recipe_name, r.directions, r.preptime, r.cooktime, u.username as recipe_by from ingredients i, rec_ing ri, recipes r, users u\n" +
                "where 1=1\n" +
                "and u.id = r.owner_id\n" +
                "and r.id = "+id+"\n"+
                "group by r.name";

        log.info("the query is: "+query);
        List<Recipe> recipes = new ArrayList<>();
        jdbcTemplate.query(query,
                (rs, rowNum) ->
                        new Recipe(rs.getLong("id"), rs.getString("recipe_name"), rs.getString("directions"),
                                rs.getString("preptime"), rs.getString("cooktime"),rs.getString("recipe_by"))
        ).forEach(recipe -> {
            log.info(recipe.toString());
            recipes.add(recipe);
        });
        return recipes.get(0);
    }


    @RequestMapping(value="/getingredientsbyrecid",method = RequestMethod.POST)
    public List<Ingredient> getIngredientsByRecipeId(@RequestBody String id) {

        log.info("Querying for ingredients with id:"+id);

        String query="select  i.name, ri.amount, ri.unit  from ingredients i, recipes r, rec_ing ri " +
                    "where ri.rec_id=r.id and ri.ing_id=i.id and r.id="+id;

        log.info("the query is: "+query);
        List<Ingredient> ingredients = new ArrayList<>();
        jdbcTemplate.query(query,
                (rs, rowNum) ->
                        new Ingredient(rs.getString("name"),rs.getString("unit"),rs.getInt("amount"))
        ).forEach(recipe -> {
            log.info(recipe.toString());
            ingredients.add(recipe);
        });
        return ingredients;
    }

    @RequestMapping(value="/getingredients",method = RequestMethod.GET)
    public List<String> getIngredientsByRecipeId() {

        log.info("Querying for all ingredients");

        String query="SELECT * from ingredients";

        log.info("the query is: "+query);
        List<String> ingredients = new ArrayList<>();
        jdbcTemplate.query(query,
                (rs, rowNum) ->
                        rs.getString("name")
        ).forEach(ing -> {
            log.info(ing);
            ingredients.add(ing);
        });
        return ingredients;
    }

}
