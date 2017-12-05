package com.alkfejl.hu.Beadando.controllers;

import com.alkfejl.hu.Beadando.BeadandoApplication;
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

    @RequestMapping("/debug/recipes")
    public List<Recipe> getRecipes() {

        log.info("Querying for recipes");

        List<Recipe> recipes = new ArrayList<>();
        jdbcTemplate.query(
                "SELECT id, name, directions, preptime, cooktime,owner_id FROM recipes",
                (rs, rowNum) ->
                        new Recipe(rs.getLong("id"), rs.getString("name"), rs.getString("directions"),
                                rs.getString("preptime"), rs.getString("cooktime"),rs.getLong("owner_id"))
        ).forEach(recipe -> {
            log.info(recipe.toString());
            recipes.add(recipe);
        });
        return recipes;
    }


}
