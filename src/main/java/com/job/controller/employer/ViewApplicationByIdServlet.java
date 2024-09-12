package com.job.controller.employer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.dao.ApplicationDao;
import com.job.model.Application;


@WebServlet("/employer/view-application")
public class ViewApplicationByIdServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		Long appid=Long.parseLong(request.getParameter("id"));
		
		ApplicationDao applicationDao=new ApplicationDao();
		Application application = applicationDao.getApplicationId(appid);

        
        request.setAttribute("application", application);
        request.getRequestDispatcher("/employer/view_application_by_id.jsp").forward(request, response);
        
    }
}