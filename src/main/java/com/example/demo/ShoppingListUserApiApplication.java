package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import dao.DaoInterface;
import dao.UserDao;
import entities.User;

@SpringBootApplication
@ComponentScan(basePackages = {"dao", "entities", "webservices"})
public class ShoppingListUserApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingListUserApiApplication.class, args);
	}
	
	CommandLineRunner start() {
		return args -> {     };
	}
}

