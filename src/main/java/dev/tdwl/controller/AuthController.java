package dev.tdwl.controller;


import com.mongodb.MongoException;
import dev.tdwl.model.AuthenticationRequest;
import dev.tdwl.model.CategoryLists;
import dev.tdwl.model.JwtResponse;
import dev.tdwl.model.User;
import dev.tdwl.repository.CategoryListsRepository;
import dev.tdwl.repository.UserRepository;
import dev.tdwl.security.jwt.JwtUtils;
import dev.tdwl.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class AuthController {

    private final CategoryListsRepository categoryRepo;
    private final UserRepository userRepo;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    @Autowired
    public AuthController(UserRepository repository, AuthenticationManager authenticationManager, PasswordEncoder encoder, JwtUtils jwtUtils, CategoryListsRepository categoryRepo) {
        this.authenticationManager = authenticationManager;
        this.userRepo = repository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
        this.categoryRepo = categoryRepo;
    }

    @GetMapping("/auth/check")
    public ResponseEntity<?> verifyLogin() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(userDetails);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt, user.getUsername(), user.getId()));
    }

    @PostMapping("/auth/signup")
    public ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest) {
        String email = authenticationRequest.getEmail();
        String password = authenticationRequest.getPassword();

        User newUser = new User(email, encoder.encode(password));

        try {
            userRepo.save(newUser);
            CategoryLists newList = new CategoryLists(newUser.getId(), Collections.emptyList());
            categoryRepo.save(newList);
        } catch (DuplicateKeyException | MongoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.ok("User registered successfully!");
    }
}
