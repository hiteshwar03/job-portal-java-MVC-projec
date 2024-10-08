package com.job.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.job.model.Company;

public class CompanyDao {

	Connection con = null;

	public CompanyDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal_db", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean addCompany(Company company) {
		String sql = "INSERT INTO Company (employer_id, company_name, company_address, company_website, company_email,company_size, founded_year, industry ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setLong(1,company.getCompanyId());
			stmt.setString(2, company.getCompanyName());
			stmt.setString(3, company.getCompanyAddress());
			stmt.setString(4, company.getCompanyWebsite());
			stmt.setString(5, company.getCompanyEmail());
			stmt.setString(6, company.getCompanySize());
			stmt.setString(7, company.getFoundedYear());
			stmt.setString(8, company.getIndustryType());
			
			
			int res= stmt.executeUpdate();
			
			if(res>0) {
				return true;
			}
			
			stmt.close();
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		return false;
	}

	//if particular user registered its company
	public Company isCompanyExist(Long userId) {
		Company company=null;
		try {
			String sql = "SELECT * FROM Company WHERE employer_id = ?";
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setLong(1, userId);

	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	        	company=new Company();
	        	company.setCompanyName(rs.getString("company_name"));
	        	company.setCompanyAddress(rs.getString("company_address"));
	        	company.setCompanyEmail(rs.getString("company_email"));
	        	company.setCompanyWebsite(rs.getString("company_website"));
	        	
	        	return company;
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
        
		return company;
		
	}

}
