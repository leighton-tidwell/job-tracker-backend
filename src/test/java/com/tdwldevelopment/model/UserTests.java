package com.tdwldevelopment.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTests {

	private final User user;

	public UserTests() {
		this.user = new User("foo", "foo@bar.com");
	}

	@BeforeEach
	public void setUp() {
		user.setUsername("foo");
		user.setEmail("foo@bar.com");
	}
	
	@Test
	public void shouldGetEmail() {
		assertEquals("foo@bar.com", user.getEmail());
	}

	@Test
	public void shouldSetEmail() {
		user.setEmail("test@test.com");
		assertEquals("test@test.com", user.getEmail());
	}

	@Test
	public void shouldGetUsername() {
		assertEquals("foo",user.getUsername());
	}

	@Test
	public void shouldSetUsername() {
		user.setUsername("test");
		assertEquals("test", user.getUsername());
	}

}
