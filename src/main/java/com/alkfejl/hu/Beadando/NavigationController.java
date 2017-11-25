package com.alkfejl.hu.Beadando;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class NavigationController {

    @RequestMapping("/")
    public String index() {
        return "Hello world!";
    }
 
}
