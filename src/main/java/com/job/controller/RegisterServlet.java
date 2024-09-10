package com.job.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.dao.UserDao;
import com.job.model.User;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String username = request.getParameter("username");
        String password = request.getParameter("password");  
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");  
        String role = request.getParameter("role");  
        
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRole(role);
        
        UserDao userDao=new UserDao();
        boolean res = userDao.addUser(user);
        
        if(res) {
        	System.out.println("user added");
        }
        else {
        	System.out.println("error");
        }
        
        RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
        
    }
}
