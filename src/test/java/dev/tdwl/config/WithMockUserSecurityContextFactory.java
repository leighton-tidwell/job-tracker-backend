package dev.tdwl.config;

import dev.tdwl.model.User;
import dev.tdwl.services.UserDetailsImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

public class WithMockUserSecurityContextFactory implements WithSecurityContextFactory<WithMockUser> {

    @Override
    public SecurityContext createSecurityContext(WithMockUser customUser) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        User testUser = new User("test@test.com");
        testUser.setId("testId");
        UserDetailsImpl principal = UserDetailsImpl.build(testUser);

        Authentication auth = new UsernamePasswordAuthenticationToken(principal, "password", principal.getAuthorities());
        context.setAuthentication(auth);
        return context;
    }
}
