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

import com.job.model.Company;
import com.job.model.User;


@WebServlet("/employer/add-company")
public class AddCompanyServlet extends HttpServlet {
  
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String companyName = request.getParameter("companyName");
        String companyAddress = request.getParameter("companyAddress");  
        String companyWebsite = request.getParameter("companyWebsite");
        String companyEmail = request.getParameter("companyEmail");  
        String companySize = request.getParameter("companySize");  
        String foundedYear = request.getParameter("foundedYear");  
        String industry = request.getParameter("industry");  
        
        HttpSession session=request.getSession();
        User user =(User) session.getAttribute("user");
        
        
        Company company=new Company();
        company.setCompanyId(user.getUserId());
        company.setCompanyName(companyName);
        company.setCompanyAddress(companyAddress);
        company.setCompanyWebsite(companyWebsite);
        company.setCompanyEmail(companyEmail);
        company.setCompanySize(companySize);
        company.setFoundedYear(foundedYear);
        company.setIndustryType(industry);
        
        CompanyDao companyDao=new CompanyDao();
        companyDao.addCompany(company);
        
        response.sendRedirect(request.getContextPath()+"/employer/employer-dashboard");
        
    }
}