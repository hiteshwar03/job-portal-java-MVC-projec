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


@WebServlet("/employer/edit-job")
public class EditJobServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        int jobid = Integer.parseInt(request.getParameter("id"));
  
        JobDao jobDao=new JobDao();
        Job jobById = jobDao.getJobById(jobid);
        
        
        request.setAttribute("job", jobById);
        
        request.getRequestDispatcher("/employer/update_job.jsp").forward(request, response);
        
    }
}