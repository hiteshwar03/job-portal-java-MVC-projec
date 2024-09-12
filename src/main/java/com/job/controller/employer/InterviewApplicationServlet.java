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


@WebServlet("/employer/interview-applications")
public class InterviewApplicationServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        //interviewed application
		ApplicationDao applicationDao=new ApplicationDao();
        List<Application> interviewApplications = applicationDao.getInterviewedApplication();
        request.setAttribute("interviewApplications", interviewApplications);
        
        
        request.getRequestDispatcher("/employer/interview_application.jsp").forward(request, response);
        
    }
}