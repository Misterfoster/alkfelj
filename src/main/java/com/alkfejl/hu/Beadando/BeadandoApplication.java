package com.alkfejl.hu.Beadando;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BeadandoApplication {
    private static final Logger log = LoggerFactory.getLogger(BeadandoApplication.class);
    

	public static void main(String[] args) {
		SpringApplication.run(BeadandoApplication.class, args);
	}

}
