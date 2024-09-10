package com.job.controller.employer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.job.dao.JobDao;
import com.job.model.Job;
import com.job.model.User;


@WebServlet("/add-job")
public class AddJobServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String jobTitle = request.getParameter("jobTitle");
        String jobDesc = request.getParameter("jobDesc");  
        String location = request.getParameter("location");
        double salary =  Double.parseDouble(request.getParameter("salary"));
        String jobType = request.getParameter("jobType"); 
        String status = request.getParameter("status"); 
        String experience = request.getParameter("experience"); 
        String requirement = request.getParameter("requirement"); 
        String responsibilities = request.getParameter("responsibilities"); 
        String benefits = request.getParameter("benefits"); 
        String openings = request.getParameter("openings"); 
        
        
        HttpSession session=request.getSession();
        User user =(User) session.getAttribute("user");
        
        Job job=new Job();
        job.setJobTitle(jobTitle);
        job.setJobDescription(jobDesc);
        job.setLocation(location);
        job.setSalary(salary);
        job.setJobType(jobType);
        job.setStatus(status);
        job.setEmployerId(user.getUserId());
        job.setExperience(experience);
        job.setRequirement(requirement);
        job.setResponisibilities(responsibilities);
        job.setBenefits(benefits);
        job.setVacancy(openings);
        
        JobDao jobDao=new JobDao();
        jobDao.addJob(job);
        
   	 	response.sendRedirect(request.getContextPath()+"/employer-dashboard"); //context path= http://localhost:8080/jobPortal
	 
        
    }
}