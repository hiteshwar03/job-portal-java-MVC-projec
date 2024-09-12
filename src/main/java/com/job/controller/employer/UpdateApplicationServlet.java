package com.job.controller.employer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.job.dao.ApplicationDao;
import com.job.dao.JobDao;
import com.job.model.Application;
import com.job.model.Job;
import com.job.model.User;


@WebServlet("/employer/update-application")
public class UpdateApplicationServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long appid=Long.parseLong(request.getParameter("id"));
        String status=request.getParameter("applicationStatus");
        
        Application application=new Application();
        application.setStatus(status);
        
        ApplicationDao applicationDao=new ApplicationDao();
        applicationDao.updateApplication(application,appid);
		
   	 	response.sendRedirect(request.getContextPath()+"/employer/all-applications"); //context path= http://localhost:8080/jobPortal
	 
        
    }
}