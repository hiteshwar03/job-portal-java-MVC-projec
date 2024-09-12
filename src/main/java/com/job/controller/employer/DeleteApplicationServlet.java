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
import com.job.model.Job;
import com.job.model.User;


@WebServlet("/employer/delete-application")
public class DeleteApplicationServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        int appid = Integer.parseInt(request.getParameter("id"));
  
        ApplicationDao applicationDao=new ApplicationDao();
        applicationDao.deleteApplicationById(appid);
                
        request.getRequestDispatcher("/employer/applications").forward(request, response);
        
    }
}