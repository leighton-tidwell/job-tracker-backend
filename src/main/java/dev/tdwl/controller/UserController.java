package dev.tdwl.controller;

import dev.tdwl.model.User;
import dev.tdwl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepo;

    @Autowired
    public UserController(UserRepository repository) {
        this.userRepo = repository;
    }


    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/users/id/{id}")
    public User getUserById(@PathVariable("id") String id) {
        return userRepo.findUserById(id);
    }
}
