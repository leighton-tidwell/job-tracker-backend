package com.tdwldevelopment.controller;

import com.tdwldevelopment.model.User;
import com.tdwldevelopment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepo;

    @Autowired
    public UserController(UserRepository repository) {
        this.userRepo = repository;
    }


    @GetMapping("/getUsers")
    public List<User> getUsers() {
        System.out.println("invoked");
        return userRepo.findAll();
    }
}
