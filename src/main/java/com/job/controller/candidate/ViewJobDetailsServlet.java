package com.job.controller.candidate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.dao.JobDao;
import com.job.model.Job;


@WebServlet("/candidate/view-job-details")
public class ViewJobDetailsServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	int jobid=Integer.parseInt(request.getParameter("id"));
    	
    	JobDao jobDao=new JobDao();
    	Job jobById = jobDao.getJobById(jobid);


		request.setAttribute("job", jobById);
    	
        RequestDispatcher dispatcher=request.getRequestDispatcher("/candidate/view_job_details.jsp");
        dispatcher.forward(request, response);
        
    }
}