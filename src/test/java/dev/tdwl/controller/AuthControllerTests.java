package dev.tdwl.controller;

import dev.tdwl.config.WithMockUser;
import dev.tdwl.model.Category;
import dev.tdwl.model.CategoryLists;
import dev.tdwl.model.User;
import dev.tdwl.repository.CategoryListsRepository;
import dev.tdwl.repository.UserRepository;
import dev.tdwl.security.WebSecurityConfig;
import dev.tdwl.security.jwt.AuthEntryPointJwt;
import dev.tdwl.security.jwt.JwtUtils;
import dev.tdwl.services.UserDetailsImpl;
import dev.tdwl.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AuthController.class)
@ContextConfiguration(classes = {AuthController.class, UserService.class, AuthEntryPointJwt.class})
@Import(WebSecurityConfig.class)
public class AuthControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PasswordEncoder encoder;

    @MockBean
    private JwtUtils jwtUtils;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private CategoryListsRepository categoryRepo;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testAuthenticationCheckInvalid() {
        try {
            mockMvc.perform(get("/auth/check")).andExpect(status().isUnauthorized()).andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @WithMockUser
    void testAuthenticationCheckValid() {
        try {
            mockMvc.perform(get("/auth/check").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testLogin() {
        User testUser = new User("test@test.com", "testPassword");
        testUser.setId("testId");
        UserDetailsImpl userDetails = UserDetailsImpl.build(testUser);
        Authentication authentication = mock(Authentication.class);

        when(authentication.isAuthenticated()).thenReturn(true);
        when(authentication.getPrincipal()).thenReturn(userDetails);
        when(authenticationManager.authenticate(Mockito.any())).thenReturn(authentication);
        when(jwtUtils.generateJwtToken(Mockito.any())).thenReturn("testJwt");

        String content = "{\"email\":\"test@test.com\",\"password\":\"testPassword\"}";
        String expectedJson = "{\"email\":\"test@test.com\",\"id\":\"testId\",\"accessToken\":\"testJwt\",\"tokenType\":\"Bearer\"}";

        try {
            MvcResult result = mockMvc.perform(post("/auth/login")
                            .with(csrf())
                            .content(content)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();

            String actualJson = result.getResponse().getContentAsString();

            assertEquals(expectedJson, actualJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSignup() {
        User testUser = new User("test@test.com", "testPassword");
        testUser.setId("testId");

        Category category = new Category();

        CategoryLists list = new CategoryLists("testId", new ArrayList<>(Arrays.asList(category)));

        when(encoder.encode(Mockito.anyString())).thenReturn("testPassword");
        when(userRepository.save(Mockito.any(User.class))).thenReturn(testUser);
        when(categoryRepo.save(Mockito.any(CategoryLists.class))).thenReturn(list);

        String content = "{\"email\":\"test@test.com\",\"password\":\"testPassword\"}";

        try {
            MvcResult result = mockMvc.perform(post("/auth/signup")
                            .with(csrf())
                            .content(content)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();

            String response = result.getResponse().getContentAsString();

            assertEquals("User registered successfully!", response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
