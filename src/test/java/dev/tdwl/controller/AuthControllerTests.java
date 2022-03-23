package dev.tdwl.controller;

import dev.tdwl.config.WithMockUser;
import dev.tdwl.repository.CategoryListsRepository;
import dev.tdwl.repository.UserRepository;
import dev.tdwl.security.jwt.JwtUtils;
import dev.tdwl.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {AuthController.class, UserService.class})
@AutoConfigureMockMvc
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
            mockMvc.perform(get("/auth/check").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
