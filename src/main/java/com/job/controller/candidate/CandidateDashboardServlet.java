package com.job.controller.candidate;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.job.dao.CompanyDao;
import com.job.dao.JobDao;
import com.job.dao.UserDao;
import com.job.model.Company;
import com.job.model.Job;
import com.job.model.User;


@WebServlet("/candidate-dashboard")
public class CandidateDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	HttpSession session=request.getSession();
	 	User user=(User) session.getAttribute("user");
	 	
    	CompanyDao companyDao=new CompanyDao();
		Company company= companyDao.isCompanyExist(user.getUserId());
    	
		JobDao jobDao=new JobDao();
		List<Job> allJobsWithCompany = jobDao.getAllJobsWithCompany();
		


		request.setAttribute("allJobs", allJobsWithCompany);
    	
        RequestDispatcher dispatcher=request.getRequestDispatcher("candidate/jobSeeker_dashboard.jsp");
        dispatcher.forward(request, response);
        
    }
}