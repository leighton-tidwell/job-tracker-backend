package dev.tdwl.repository;

import dev.tdwl.jobtracker.JobTrackerApplication;
import dev.tdwl.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
        User user = new User("foo@bar.com", "foo");
        user.setId("test");
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
    void shouldGetUserById() {
        User find = userRepo.findUserById("test");
        assertEquals("test", find.getId());
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
