/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkfejl.hu.Beadando;

import com.alkfejl.hu.Beadando.models.User;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author D
 */
@RestController
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(BeadandoApplication.class);
    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping("/users")
    public List<User> getUsers() {

        log.info("Querying for users");

        List<User> users = new ArrayList<User>();
        jdbcTemplate.query(
                "SELECT id, username, password FROM users",
                (rs, rowNum) -> new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"))
        ).forEach(user -> { log.info(user.toString());
                            users.add(user);
        });
        return users;
    }
}
