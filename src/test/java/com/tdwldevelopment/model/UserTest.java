package com.tdwldevelopment.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserTest {
	
	@Test
	public void createUser() {
		User user = new User("foo", "foo@bar.com");
		assertEquals(user.getEmail(), "foo@bar.com");
		assertEquals(user.getUsername(), "foo");
	}
}
