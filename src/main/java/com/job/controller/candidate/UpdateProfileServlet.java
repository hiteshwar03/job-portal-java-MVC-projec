package com.job.controller.candidate;
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

@WebServlet("/candidate/update-candidate-profile")
public class UpdateProfileServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
			String phone=request.getParameter("phone");
			Long userid=Long.parseLong(request.getParameter("id"));
			
			System.out.println(userid+":"+phone);
			
			User user=new User();
			user.setPhone(phone);
			
			
			UserDao userDao=new UserDao();
			userDao.updateUser(userid,phone);
			
        	response.sendRedirect(request.getContextPath()+"/candidate/view_profile.jsp");
	}	 

}
