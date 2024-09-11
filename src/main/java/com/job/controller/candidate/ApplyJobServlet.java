package com.job.controller.candidate;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

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
import com.job.model.Application;
import com.job.model.Candidate;
import com.job.model.User;


@WebServlet("/candidate/apply-job")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024,  // 1 MB
	    maxFileSize = 10 * 1024 * 1024,   // 10 MB
	    maxRequestSize = 20 * 1024 * 1024  // 20 MB
	)
public class ApplyJobServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		  response.setContentType("text/html");
		  
    	HttpSession session=request.getSession();
    	User user=(User) session.getAttribute("user");
    	
    	Long jobid=Long.parseLong(request.getParameter("jobId"));
    	String skill=request.getParameter("skills");
    	Part filePart = request.getPart("resume");
    	
    	InputStream fileContent=null;
    	  if (filePart != null) {
              // Get input stream from the file part
              fileContent = filePart.getInputStream();
    	  }
    	  
    	  //store candidate
    	  Candidate candidate=new Candidate();
    	  candidate.setJobSeekerId(user.getUserId());
    	  candidate.setCover(skill);
    	  candidate.setResume(fileContent.readAllBytes());
    			  
    	  ApplicationDao applicationDao=new ApplicationDao();
    	  boolean applicationDone = applicationDao.isApplicationDone(jobid, user.getUserId());

    	  //insert into if application not aleardy applied
    	  boolean isCandidateAdd=false;
    	  CandidateDao candidateDao=new CandidateDao();
    	  if(applicationDone==false) {
	    	  isCandidateAdd = candidateDao.addCandidate(candidate);
    	  }
    	  
    	  //fetch candidate id
    	 Long candidate_id = candidateDao.getCandidateIdByJobSeekerId(user.getUserId());
    	  
    	 
    	 //store application
    	  Application application=new Application();
    	  application.setCandidateId(candidate_id);
    	  application.setJobId(jobid); 	  
    	  application.setCandidate(user);

    	  //is application already done
    	  
    	  
    	  if(isCandidateAdd) {  
    		  if(applicationDone==false) { //if application not done
    			  applicationDao.addApplication(application);
    			  response.sendRedirect(request.getContextPath()+"/candidate/candidate-dashboard");
    		  }  
    	  }
    	  else {
    		  out.println("<html>");
	  	        out.println("<head><title>Run JavaScript from Servlet</title></head>");
	  	        out.println("<body>");
	
	  	        out.println("<script type='text/javascript'>");
	  	        out.println("alert('You already applied for this job');");
	  	        out.println("window.location.href = '" + request.getContextPath() + "/candidate/candidate-dashboard';");
	  	        out.println("</script>");
	
	  	        out.println("</body>");
	  	        out.println("</html>");
    	  }
    	  
    	  
        
    }
}