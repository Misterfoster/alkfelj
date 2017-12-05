/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkfejl.hu.Beadando.controllers;

import com.alkfejl.hu.Beadando.BeadandoApplication;
import com.alkfejl.hu.Beadando.BeadandoApplication;
import com.alkfejl.hu.Beadando.models.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author D
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(BeadandoApplication.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/debug/users")
    public List<User> getUsers() {

        log.info("Querying for users");

        List<User> users = new ArrayList<User>();
        jdbcTemplate.query(
                "SELECT id, username, password FROM users",
                (rs, rowNum) -> new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"))
        ).forEach(user -> {
            log.info(user.toString());
            users.add(user);
        });
        return users;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void addUser(@RequestBody User userParam) {
        String username = userParam.getUsername();
        String password = userParam.getPassword();
        log.info("Adding user: " + username + " " + password);

        String insertQuery = "INSERT INTO `alkfejl`.`users`(`username`,`password`)VALUES('%s','%s');";
        insertQuery = String.format(insertQuery, username, password);

        jdbcTemplate.execute(insertQuery);

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean login(@RequestBody User userParam) {
        String username = userParam.getUsername();
        String password = userParam.getPassword();
        log.debug("Trying to login user: " + username + " " + password);

        String query = "SELECT * FROM users where username='%s'";
        User user;
        try {
            user = jdbcTemplate.queryForObject(String.format(query, username), new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
        } catch (EmptyResultDataAccessException e){
            log.info("User not found");
            return false;
        }
        
        return password.equals(user.getPassword());

    }
}
