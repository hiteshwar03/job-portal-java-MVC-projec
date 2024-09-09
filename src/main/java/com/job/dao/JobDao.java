package com.job.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.job.model.Job;
import com.job.model.User;

public class JobDao {

	Connection con = null;

	public JobDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal_db", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean addJob(Job job) {
		String sql = "INSERT INTO Job ( employer_id, job_title, job_description, location, salary, job_type, status ) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setLong(1, job.getEmployerId());
			stmt.setString(2, job.getJobTitle());
			stmt.setString(3, job.getJobDescription());
			stmt.setString(4, job.getLocation());
			stmt.setDouble(5, job.getSalary());
			stmt.setString(6, job.getJobType());
			stmt.setString(7, job.getStatus());
						
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
	
}
