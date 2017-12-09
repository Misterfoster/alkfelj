package com.alkfejl.hu.Beadando.controllers;

import com.alkfejl.hu.Beadando.BeadandoApplication;
import com.alkfejl.hu.Beadando.models.FullRecipe;
import com.alkfejl.hu.Beadando.models.Recipe;
import com.alkfejl.hu.Beadando.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                "and 'bread' in (select i.name from ingredients i, rec_ing ri, recipes r where ri.ing_id = i.id and ri.rec_id = r.id)\n" +
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
}
