package com.alkfejl.hu.Beadando;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {

    @RequestMapping("/")
    public String index() {
        return "welcome";
    }
    
    @RequestMapping("/recipes")
    public String recipes() {
        return "recipes";
    }
 
}