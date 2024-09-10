package com.job.controller;
import java.io.IOException;


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

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        
        response.sendRedirect("login.jsp");  
        
    }
}
