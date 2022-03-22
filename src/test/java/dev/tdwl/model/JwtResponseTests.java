package dev.tdwl.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JwtResponseTests {
    private final JwtResponse res;

    public JwtResponseTests() {
        this.res = new JwtResponse("testToken", "testEmail", "testId");
    }

    @BeforeEach
    void init() {
        res.setEmail("testEmail");
        res.setId("testId");
        res.setAccessToken("testToken");
        res.setTokenType("testType");
    }

    @Test
    void shouldGetId() {
        assertEquals("testId", res.getId());
    }

    @Test
    void shouldSetId() {
        res.setId("fooId");
        assertEquals("fooId", res.getId());
    }

    @Test
    void shouldGetEmail() {
        assertEquals("testEmail", res.getEmail());
    }

    @Test
    void shouldSetEmail() {
        res.setEmail("fooEmail");
        assertEquals("fooEmail", res.getEmail());
    }

    @Test
    void shouldGetAccessToken() {
        assertEquals("testToken", res.getAccessToken());
    }

    @Test
    void shouldSetAccessToken() {
        res.setAccessToken("fooToken");
        assertEquals("fooToken", res.getAccessToken());
    }

    @Test
    void shouldGetTokenType() {
        assertEquals("testType", res.getTokenType());
    }

    @Test
    void shouldSetTokenType() {
        res.setTokenType("fooType");
        assertEquals("fooType", res.getTokenType());
    }
}
