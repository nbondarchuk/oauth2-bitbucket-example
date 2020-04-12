package com.nbondarchuk.oauth2.service;

import com.nbondarchuk.oauth2.model.User;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Nikolay Bondarchuk
 * @since 2020-04-05
 */
public class UserServiceImpl implements UserService {

    private static final AtomicLong userIdCounter = new AtomicLong();

    private final Map<String, User> userStore = new ConcurrentHashMap<>();

    @Override
    public User create(User user) {
        user.setId(userIdCounter.incrementAndGet());
        userStore.put(user.getLogin(), user);
        return user;
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return Optional.ofNullable(userStore.get(login));
    }
}
