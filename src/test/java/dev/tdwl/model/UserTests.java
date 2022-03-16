package dev.tdwl.model;

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
        user.setEmail("foo@bar.com");
        user.setPassword("foo");
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
    void shouldGetPassword() {
        assertEquals("foo", user.getPassword());
    }

    @Test
    void shouldSetPassword() {
        user.setPassword("test");
        assertEquals("test", user.getPassword());
    }

}
