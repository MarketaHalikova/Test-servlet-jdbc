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
import java.util.List;

public class ProjectDetailServlet extends HttpServlet {

    private ProjectService projectService = new ProjectServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String address;

        if (req.getParameter("btn_logout") != null) {
            address = "login.jsp";
        } else if (req.getParameter("btn_back") != null){


            List<Project> projects = projectService.findAll();

            req.setAttribute("projects", projects);
            address = "projectList.jsp";
        } else {
            address = "error.jsp";
        }


        RequestDispatcher requestDispatcher = req.getRequestDispatcher(address);
        requestDispatcher.forward(req, resp);
    }
}

