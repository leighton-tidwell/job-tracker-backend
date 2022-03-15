package com.tdwldevelopment.repository;

import com.tdwldevelopment.jobtracker.JobTrackerApplication;
import com.tdwldevelopment.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = JobTrackerApplication.class)
@DataMongoTest(properties = {"spring.mongodb.embedded.version=4.0.2"})
@ExtendWith(SpringExtension.class)
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepo;
	
	@BeforeEach
	public void setUp() {
		userRepo.save(new User("foo", "foo@bar.com"));
	}

	@Test
	public void shouldGetAllUsers() {
		assertFalse(userRepo.findAll().isEmpty());
	}

	@Test
	public void shouldGetUserByEmail() {
		User find = userRepo.findUserByEmail("foo@bar.com");
		assertEquals("foo@bar.com", find.getEmail());
	}
}
