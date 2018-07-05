package com.marketahalikova.jdbctest.repositories;

import com.marketahalikova.jdbctest.database.Database;
import com.marketahalikova.jdbctest.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryJdbc implements UserRepository {



    public Optional<User> getUserByNameByPassword(String name, String password) throws SQLException {

        List<String> params = new ArrayList<>();
        params.add(name);
        params.add(password);
        ResultSet resultSet = Database.getInstance().select("SELECT * FROM user WHERE user_name = ? AND password = ? ", params);
        if (resultSet == null) {
            return Optional.empty();
        }
        int count = 0;
        User user = null;
        while (resultSet.next()) {

            if (count == 0) {
                user = new User();
                user.setUserName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));

            }
            count++;
        }
        if(count==1 ){
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }
}
