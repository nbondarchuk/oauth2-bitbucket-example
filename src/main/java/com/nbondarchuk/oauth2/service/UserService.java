package com.nbondarchuk.oauth2.service;

import com.nbondarchuk.oauth2.model.User;

import java.util.Optional;

/**
 * @author Nikolay Bondarchuk
 * @since 2020-04-05
 */
public interface UserService {

    User create(User user);

    Optional<User> findByLogin(String login);
}
