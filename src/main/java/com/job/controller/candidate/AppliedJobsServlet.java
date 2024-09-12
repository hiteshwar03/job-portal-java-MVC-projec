package com.job.controller.candidate;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
import com.job.dao.JobDao;
import com.job.model.Application;
import com.job.model.Candidate;
import com.job.model.Job;
import com.job.model.User;


@WebServlet("/candidate/applied-jobs")
public class AppliedJobsServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	HttpSession session=request.getSession();
    	User user=(User) session.getAttribute("user");
    	
    	
    			  
    	  ApplicationDao applicationDao=new ApplicationDao();
    	  List<Application> allApplicationsById = applicationDao.getAllApplicationsById(user.getUserId());

    	  List<Job> jobs=new ArrayList<Job>();
    	  for(Application application:allApplicationsById) {
    		  Long jobId = application.getJob().getJobId();
    		  
    		  //fetch all jobs
    		  JobDao jobDao=new JobDao();
    		  Job jobById = jobDao.getJobById(jobId);
    		  
    		  jobs.add(jobById);
    	  }
    	 
    	  request.setAttribute("jobs", jobs);
    	  request.getRequestDispatcher("/candidate/applied_jobs.jsp").forward(request, response);
    	      	  
        
    }
}