package com.marketahalikova.jdbctest.repositories;

import com.marketahalikova.jdbctest.model.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserRepository {
    Optional<User> getUserByNameByPassword(String name, String password) throws SQLException;
}
