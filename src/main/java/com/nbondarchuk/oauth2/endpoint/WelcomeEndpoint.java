package com.nbondarchuk.oauth2.endpoint;

import com.nbondarchuk.oauth2.model.User;
import com.nbondarchuk.oauth2.security.MyOAuth2User;
import com.nbondarchuk.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Nikolay Bondarchuk
 * @since 2020-04-05
 */
@Path("/")
public class WelcomeEndpoint {

    @Autowired
    private UserService userService;

    @GET
    public String welcome() {
        User currentUser = getCurrentUser();
        return String.format("Welcome, %s! (user id: %s, user login: %s)",
                currentUser.getName(), currentUser.getId(), currentUser.getLogin());
    }

    public User getCurrentUser() {
        return userService.findByLogin(getAuthenticatedUser().getName()).orElseThrow(() -> new RuntimeException("No user logged in."));
    }

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    private MyOAuth2User getAuthenticatedUser() {
        return (MyOAuth2User) getAuthentication().getPrincipal();
    }
}
