package dev.tdwl.controller;

import dev.tdwl.model.CategoryLists;
import dev.tdwl.model.User;
import dev.tdwl.repository.CategoryListsRepository;
import dev.tdwl.repository.UserRepository;
import dev.tdwl.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepo;
    private final CategoryListsRepository categoryRepo;

    @Autowired
    public UserController(UserRepository repository, CategoryListsRepository categoryRepo) {
        this.userRepo = repository;
        this.categoryRepo = categoryRepo;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/users/id/{id}")
    public User getUserById(@PathVariable("id") String id) {
        return userRepo.findUserById(id);
    }

    @GetMapping("/users/categories")
    public CategoryLists getUserLists() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return categoryRepo.findListsById(userDetails.getId());
    }

    @PostMapping("/users/categories")
    public ResponseEntity<?> updateUserLists(@RequestBody CategoryLists lists) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String listUserId = lists.getUserId();
        String loginUserId = userDetails.getId();

        if (listUserId.equals(loginUserId)) {
            categoryRepo.save(lists);
            return ResponseEntity.ok(lists);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
