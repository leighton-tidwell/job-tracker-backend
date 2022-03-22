package dev.tdwl.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersTests {
    private final Users listOfUsers;

    public UsersTests() {
        this.listOfUsers = new Users();
    }

    @BeforeEach
    void init() {
        User user1 = new User("foo", "foo@bar.com");
        User user2 = new User("bar", "bar@foo.com");
        List<User> addedUsers = new ArrayList<>(Arrays.asList(user1, user2));
        listOfUsers.setUserList(addedUsers);
    }

    @Test
    void shouldGetListOfUsers() {
        assertEquals(2, listOfUsers.getUserList().size());
    }

    @Test
    void shouldGetEmptyList() {
        // test for if user list is null
        listOfUsers.setUserList(null);
        assertEquals(0, listOfUsers.getUserList().size());
    }

    @Test
    void shouldSetUserList() {
        User user3 = new User("test", "test@test.com");
        List<User> newList = new ArrayList<>(Collections.singletonList(user3));
        listOfUsers.setUserList(newList);

        assertEquals(1, listOfUsers.getUserList().size());
    }
}
