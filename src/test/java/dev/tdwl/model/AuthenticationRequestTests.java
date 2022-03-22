package dev.tdwl.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthenticationRequestTests {

    private final AuthenticationRequest authReq;

    public AuthenticationRequestTests() {
        this.authReq = new AuthenticationRequest();
    }

    @BeforeEach
    void init() {
        authReq.setEmail("test@email.com");
        authReq.setPassword("testPassword");
    }

    @Test
    void shouldGetEmail() {
        assertEquals("test@email.com", authReq.getEmail());
    }

    @Test
    void shouldSetEmail() {
        authReq.setEmail("foo@bar.com");
        assertEquals("foo@bar.com", authReq.getEmail());
    }

    @Test
    void shouldGetPassword() {
        assertEquals("testPassword", authReq.getPassword());
    }

    @Test
    void shouldSetPassword() {
        authReq.setPassword("fooPass");
        assertEquals("fooPass", authReq.getPassword());
    }
}
