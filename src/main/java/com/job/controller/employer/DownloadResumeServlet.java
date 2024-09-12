package com.job.controller.employer;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.job.dao.ApplicationDao;
import com.job.dao.JobDao;
import com.job.model.Application;
import com.job.model.Job;
import com.job.model.User;


@WebServlet("/employer/download-resume")
public class DownloadResumeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve application ID from the request parameter
        Long applicationId = Long.parseLong(request.getParameter("id"));

        // Fetch the resume byte array from the database
        ApplicationDao applicationDao=new ApplicationDao();
        Application application = applicationDao.getApplicationId(applicationId); // Assume you have a method to get Application by ID
        byte[] resume = application.getCandidate().getResume(); // Retrieve resume as byte[]

        // Set content type to application/pdf
        response.setContentType("application/pdf");

        // Set headers to force download
        response.setHeader("Content-Disposition", "attachment; filename=\"resume.pdf\"");

        // Write the resume bytes to the response output stream
        OutputStream out = response.getOutputStream();
        out.write(resume);  // Write byte[] to the output stream
        out.flush();
        out.close();
    }
}
