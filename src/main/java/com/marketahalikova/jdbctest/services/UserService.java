package com.marketahalikova.jdbctest.services;

import com.marketahalikova.jdbctest.model.User;

public interface UserService {

    User getUserByNameByPassword(String name, String password);
}
