package dev.tdwl.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {

    @PostMapping("/auth/login")
    public Map<String, Object> login(@RequestBody Map<String, Object> payload) {
        return payload;
    }

    @PostMapping("/auth/signup")
    public String signUp(@RequestBody String email, @RequestBody String password) {
        return email + password;
    }
}
