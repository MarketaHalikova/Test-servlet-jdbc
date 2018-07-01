package com.marketahalikova.jdbctest.services;

import com.marketahalikova.jdbctest.model.User;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public Optional<User> getUserByNameByPassword(String name, String password) {
        return Optional.of(new User("Markétka", "12345"));
    }
}
