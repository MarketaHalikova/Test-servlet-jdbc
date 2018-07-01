package com.marketahalikova.jdbctest.database;

import java.sql.*;

public class Database {

    public static final String DB_CONNECTION_STRING = "jdbc:mysql://127.0.0.1/jdbctest?useUnicode=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "admin";
    Connection connection;

    public Database(String dbConnectionString, String userName, String password) throws SQLException {


        connection = DriverManager.getConnection(dbConnectionString, userName, password);

    }

    public void destroy() throws SQLException {

        if (!connection.isClosed()) {

            connection.close();

        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("spustenoooooooo");
        Database database = new Database(
                DB_CONNECTION_STRING, USER_NAME, PASSWORD);

        int id = database.insert("INSERT INTO user (user_name, password) VALUES ('jan','23456')");
        System.out.println(id);
        database.destroy();
    }

    public int insert(String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.executeUpdate();
        ResultSet tableKeys = preparedStatement.getGeneratedKeys();

        tableKeys.next();

        int autoGeneratedID = tableKeys.getInt(1);

        return autoGeneratedID;

    }

    public ResultSet select(String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet result = preparedStatement.executeQuery(sql);

        return result;
    }


}
