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


@WebServlet("/view-job-details")
public class ViewJobDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	int jobid=Integer.parseInt(request.getParameter("id"));
    	
    	JobDao jobDao=new JobDao();
    	Job jobById = jobDao.getJobById(jobid);


		request.setAttribute("job", jobById);
    	
        RequestDispatcher dispatcher=request.getRequestDispatcher("candidate/view_job_details.jsp");
        dispatcher.forward(request, response);
        
    }
}