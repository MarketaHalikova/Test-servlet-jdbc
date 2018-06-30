package com.marketahalikova.jdbctest.services;

import com.marketahalikova.jdbctest.model.User;

public class UserServiceImpl implements UserService {
    @Override
    public User getUserByNameByPassword(String name, String password) {
        return new User("Markétka", "12345");
    }
}
