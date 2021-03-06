package com.marketahalikova.jdbctest.services;

import com.marketahalikova.jdbctest.model.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserByNameByPassword(String name, String password) throws SQLException;
}
