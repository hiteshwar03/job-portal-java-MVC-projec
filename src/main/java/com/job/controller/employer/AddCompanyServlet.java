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
import com.job.dao.UserDao;
import com.job.model.Company;
import com.job.model.User;


@WebServlet("/add-company")
public class AddCompanyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String companyName = request.getParameter("companyName");
        String companyAddress = request.getParameter("companyAddress");  
        String companyWebsite = request.getParameter("companyWebsite");
        String companyEmail = request.getParameter("companyEmail");  
        
        HttpSession session=request.getSession();
        User user =(User) session.getAttribute("user");
        
        
        Company company=new Company();
        company.setCompanyId(user.getUserId());
        company.setCompanyName(companyName);
        company.setCompanyAddress(companyAddress);
        company.setCompanyWebsite(companyWebsite);
        company.setCompanyWebsite(companyWebsite);
        
        CompanyDao companyDao=new CompanyDao();
        companyDao.addCompany(company);
        
        
        HttpSession session1=request.getSession();
        session1.setAttribute("companyName",companyAddress);
        
        request.setAttribute("company", company);
        RequestDispatcher dispatcher=request.getRequestDispatcher("employer/employer_dashboard.jsp");
        dispatcher.forward(request, response);
        
    }
}