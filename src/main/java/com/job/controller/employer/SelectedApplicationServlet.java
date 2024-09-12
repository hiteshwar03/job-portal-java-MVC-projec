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


@WebServlet("/employer/selected-applications")
public class SelectedApplicationServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        
      //selected applications
		ApplicationDao applicationDao=new ApplicationDao();
        List<Application> selectedApplications = applicationDao.getSelectedApplication();
        request.setAttribute("selectedApplications", selectedApplications);
        
        
        request.getRequestDispatcher("/employer/selected_application.jsp").forward(request, response);
        
    }
}