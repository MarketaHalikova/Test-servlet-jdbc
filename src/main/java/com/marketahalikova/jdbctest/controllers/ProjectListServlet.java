package com.marketahalikova.jdbctest.controllers;


import com.marketahalikova.jdbctest.model.Project;
import com.marketahalikova.jdbctest.services.ProjectService;
import com.marketahalikova.jdbctest.services.ProjectServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ProjectListServlet extends HttpServlet {

    private ProjectService projectService;

    public ProjectListServlet() throws SQLException {
        projectService= new ProjectServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String address;
        if (req.getParameter("btn_logout") != null) {
            address = "login.jsp";
        } else if (req.getParameter("btn_project") != null){
            String value = (req.getParameter("btn_project"));
            Project project = null;
            try {
                project = projectService.findById(Long.valueOf(value)).get();
            } catch (SQLException e) {
                throw new IOException(e);
            }
            req.setAttribute("project", project);

            address = "projectDetail.jsp";
        } else {
            address = "error.jsp";
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(address);
        requestDispatcher.forward(req, resp);
    }
}

