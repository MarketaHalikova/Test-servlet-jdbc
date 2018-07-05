package com.marketahalikova.jdbctest.controllers;


import com.marketahalikova.jdbctest.model.Project;
import com.marketahalikova.jdbctest.model.User;
import com.marketahalikova.jdbctest.services.ProjectService;
import com.marketahalikova.jdbctest.services.ProjectServiceImpl;
import com.marketahalikova.jdbctest.services.UserService;
import com.marketahalikova.jdbctest.services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LoginServlet extends HttpServlet {

    private UserService userService;
    private ProjectService projectService;

    public LoginServlet() throws SQLException {
        userService = new UserServiceImpl();
        projectService = new ProjectServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String password = req.getParameter("inputPassword");

        Optional<User> user = null;
        try {
            user = userService.getUserByNameByPassword(userName, password);
        } catch (SQLException e) {
             resp.sendRedirect("error.jsp");
             return;
        }

        if (user.isPresent()) {
            req.getSession().setAttribute("userLogged", user.get());
            List<Project> projects = null;
            try {
                projects = projectService.findAll();
            } catch (SQLException e) {
               throw new IOException(e);
            }

            req.setAttribute("projects", projects);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("projectList.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("error.jsp");
        }

    }
}

