package com.job.controller.employer;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.dao.ApplicationDao;
import com.job.model.Application;


@WebServlet("/employer/download-resume")
public class DownloadResumeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long applicationId = Long.parseLong(request.getParameter("id"));

        ApplicationDao applicationDao=new ApplicationDao();
        Application application = applicationDao.getApplicationId(applicationId); 
        byte[] resume = application.getCandidate().getResume(); 


        response.setContentType("application/pdf");

        response.setHeader("Content-Disposition", "attachment; filename=\"resume.pdf\"");

        OutputStream out = response.getOutputStream();
        out.write(resume);  
        out.flush();
        out.close();
    }
}
