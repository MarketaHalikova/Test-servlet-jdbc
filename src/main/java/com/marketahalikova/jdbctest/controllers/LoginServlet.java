package com.marketahalikova.jdbctest.controllers;


import com.marketahalikova.jdbctest.model.User;
import com.marketahalikova.jdbctest.services.UserService;
import com.marketahalikova.jdbctest.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String password = req.getParameter("inputPassword");
        System.out.println( "password:" + password + "  username:" + userName);
        System.out.println(String.format("username: %s   password: %s", userName, password));


        User user = userService.getUserByNameByPassword(userName, password);

        if(user != null){
            System.out.println("jsme dobrý");
            resp.sendRedirect("projectList.jsp");

        } else {
            resp.sendRedirect("error.jsp");
        }

    }
}

