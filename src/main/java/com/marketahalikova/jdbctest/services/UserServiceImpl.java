package com.marketahalikova.jdbctest.services;

import com.marketahalikova.jdbctest.model.User;
import com.marketahalikova.jdbctest.repositories.UserRepository;
import com.marketahalikova.jdbctest.repositories.UserRepositoryJdbc;

import java.sql.SQLException;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl() throws SQLException {
        userRepository = new UserRepositoryJdbc();
    }

    @Override
    public Optional<User> getUserByNameByPassword(String name, String password) throws SQLException {
        return userRepository.getUserByNameByPassword(name, password) ;
    }
}
