package com.tdwldevelopment.repository;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tdwldevelopment.jobtracker.JobtrackerApplication;
import com.tdwldevelopment.model.User;

@ContextConfiguration(classes = JobtrackerApplication.class)
@DataMongoTest(properties = {"spring.mongodb.embedded.version=4.0.2"})
@ExtendWith(SpringExtension.class)
public class UserRepositoryTest {
	
//	private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryTest.class);
	
	@Autowired
	UserRepository userRepo;
	
	@Before
	public void setUp() {
		userRepo.save(new User("foo", "foo@bar.com"));
	}
	
	
	@Test
	public void shouldGetAllUsers() {
		assertThat(userRepo.findAll()).isNotEmpty();
	}
}
