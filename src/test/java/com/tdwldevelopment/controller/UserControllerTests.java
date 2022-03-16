package com.tdwldevelopment.controller;

import com.tdwldevelopment.model.User;
import com.tdwldevelopment.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTests {

    @InjectMocks
    UserController userController;

    @Mock
    UserRepository userRepository;

    @Test
    public void shouldReturnAllUsers() {
        User user1 = new User("foo", "foo@bar.com");
        User user2 = new User("bar", "bar@foo.com");
        List<User> listOfUsers = new ArrayList<User>();
        listOfUsers.addAll(Arrays.asList(user1, user2));

        when(userRepository.findAll()).thenReturn(listOfUsers);

        List<User> users = userController.getUsers();

        assertThat(users.size()).isEqualTo(2);
    }

}