package com.job.controller.employer;

import java.io.IOException;

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


@WebServlet("/add-job")
public class AddJobServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String jobTitle = request.getParameter("jobTitle");
        String jobDesc = request.getParameter("jobDesc");  
        String location = request.getParameter("location");
        double salary =  Double.parseDouble(request.getParameter("salary"));
        String jobType = request.getParameter("jobType"); 
        String status = request.getParameter("status"); 
        
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
        
        JobDao jobDao=new JobDao();
        jobDao.addJob(job);
        
        RequestDispatcher dispatcher=request.getRequestDispatcher("employer/employer_dashboard.jsp");
        dispatcher.forward(request, response);
        
    }
}