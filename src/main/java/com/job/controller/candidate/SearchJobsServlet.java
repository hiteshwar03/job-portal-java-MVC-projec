package com.job.controller.candidate;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.job.dao.ApplicationDao;
import com.job.dao.CandidateDao;
import com.job.dao.CompanyDao;
import com.job.dao.JobDao;
import com.job.model.Application;
import com.job.model.Candidate;
import com.job.model.Job;
import com.job.model.User;


@WebServlet("/candidate/search-jobs")
public class SearchJobsServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword=request.getParameter("keyword");
		
    	HttpSession session=request.getSession();
	 	User user=(User) session.getAttribute("user");
	 	
    	CompanyDao companyDao=new CompanyDao();
		companyDao.isCompanyExist(user.getUserId());
    	
		JobDao jobDao=new JobDao();
		List<Job> allSearchJobs = jobDao.getAllJobsWithKeyword(keyword);
		


		request.setAttribute("allJobs", allSearchJobs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/candidate/searched_jobs.jsp");//forward request attribute value
		dispatcher.forward(request, response);
		
    }
}