package com.job.controller.employer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.dao.ApplicationDao;
import com.job.model.Application;


@WebServlet("/employer/view-application")
public class ViewApplicationServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		ApplicationDao applicationDao=new ApplicationDao();
		List<Application> allApplication = applicationDao.getAllApplication();
		
        request.setAttribute("allApplication", allApplication);
        request.getRequestDispatcher("/employer/view_application.jsp").forward(request, response);
        
    }
}