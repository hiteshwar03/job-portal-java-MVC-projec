package com.job.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.job.dao.UserDao;
import com.job.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao=new UserDao();
        User loggedUser = userDao.loginUser(username, password);
        
        if(loggedUser!=null) {
        	HttpSession session=request.getSession();
        	session.setAttribute("user", loggedUser);
        	
        	System.out.println(loggedUser.getRole());
        	//if logged in user is employer
        	 if (loggedUser.getRole().equals("Employer")) {
                 RequestDispatcher dispatcher = request.getRequestDispatcher("employer/employer_dashboard.jsp");
                 dispatcher.forward(request, response); 
             } else if (loggedUser.getRole().equals("JobSeeker")) {
                 RequestDispatcher dispatcher = request.getRequestDispatcher("candidate/jobSeeker_dashboard.jsp");
                 dispatcher.forward(request, response); 
             } else {
                 response.sendRedirect("error.jsp");  
             }

//        	response.sendRedirect("/employer/employer_dashboard.jsp");
        }
        else {
            request.setAttribute("errorMessage", "Invalid username or password.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");  // Redirect back to login page
            dispatcher.forward(request, response);
        }
    }
}
