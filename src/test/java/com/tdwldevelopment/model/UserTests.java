package com.tdwldevelopment.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests {

    private final User user;

    public UserTests() {
        this.user = new User("foo", "foo@bar.com");
        user.setId("test");
    }

    @BeforeEach
    void init() {
        user.setUsername("foo");
        user.setEmail("foo@bar.com");
    }

    @Test
    void shouldGetId() {
        assertEquals("test", user.getId());
    }

    @Test
    void shouldSetId() {
        user.setId("foo");
        assertEquals("foo", user.getId());
    }

    @Test
    void shouldGetEmail() {
        assertEquals("foo@bar.com", user.getEmail());
    }

    @Test
    void shouldSetEmail() {
        user.setEmail("test@test.com");
        assertEquals("test@test.com", user.getEmail());
    }

    @Test
    void shouldGetUsername() {
        assertEquals("foo", user.getUsername());
    }

    @Test
    void shouldSetUsername() {
        user.setUsername("test");
        assertEquals("test", user.getUsername());
    }

}
