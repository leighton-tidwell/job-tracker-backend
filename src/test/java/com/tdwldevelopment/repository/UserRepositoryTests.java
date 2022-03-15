package com.tdwldevelopment.repository;

import com.tdwldevelopment.jobtracker.JobTrackerApplication;
import com.tdwldevelopment.model.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = JobTrackerApplication.class)
@DataMongoTest(properties = {"spring.mongodb.embedded.version=4.0.2"})
@ExtendWith(SpringExtension.class)
public class UserRepositoryTests {

	private final UserRepository userRepo;

	@Autowired
	public UserRepositoryTests(UserRepository repository) {
		this.userRepo = repository;
	}
	
	@BeforeEach
	void init() {
		User user = new User("foo", "foo@bar.com");
		userRepo.save(user);
	}

	@Test
	void shouldGetAllUsers() {
		assertFalse(userRepo.findAll().isEmpty());
	}

	@Test
	void shouldGetUserByEmail() {
		User find = userRepo.findUserByEmail("foo@bar.com");
		assertEquals("foo@bar.com", find.getEmail());
	}

	@Test
	void shouldReturnUserCount() {
		assertEquals(1, userRepo.count());
	}

	@Test
	void shouldReturnAllUsers() {
		List<User> list = userRepo.findAll();
		assertEquals(1, list.size());
	}

	@AfterEach
	void afterEachTest() {
		userRepo.deleteAll();
	}
}
