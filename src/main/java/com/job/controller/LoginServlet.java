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

import com.job.dao.CompanyDao;
import com.job.dao.UserDao;
import com.job.model.Company;
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
        	User user=(User)session.getAttribute("user");
        	
        	System.out.println(loggedUser.getRole());
        	//if logged in user is employer
        	 if (loggedUser.getRole().equals("Employer")) {
        		 
        		 CompanyDao companyDao=new CompanyDao();
        		 Company companyExist = companyDao.isCompanyExist(user.getUserId());
        		 
        		 //if company is already added
        		 if(companyExist!=null)
        			 response.sendRedirect(request.getContextPath()+"/employer-dashboard"); //context path= http://localhost:8080/jobPortal
    			 
        		         		 
//        		 if company not already added(register company)
        		 else
        			 response.sendRedirect("employer/add_company.jsp");
        		 
        		 
             } else if (loggedUser.getRole().equals("JobSeeker")) {
            	 response.sendRedirect("candidate/jobSeeker_dashboard.jsp");
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
