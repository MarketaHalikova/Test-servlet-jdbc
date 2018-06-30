package com.marketahalikova.jdbctest.controllers;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProjectDetailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String address;

        if (req.getParameter("btn_logout") != null) {
            address = "login.jsp";
        } else if (req.getParameter("btn_back") != null){
            address = "projectList.jsp";
        } else {
            address = "error.jsp";
        }


        RequestDispatcher requestDispatcher = req.getRequestDispatcher(address);
        requestDispatcher.forward(req, resp);
    }
}

