package com.job.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.job.model.Application;
import com.job.model.User;

public class ApplicationDao {

	Connection con = null;

	public ApplicationDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal_db", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean addApplication(Application application) {
		String sql = "INSERT INTO Application (candidate_id, job_id, cover_letter, resume) VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setLong(1, application.getCandidateId());
			stmt.setLong(2, application.getJobId());
			stmt.setString(3, application.getCoverLetter());
			stmt.setBytes(4, application.getResume());
			
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

	public User loginUser(String username, String password) {
		
		User user=null;
		try {
			String sql = "SELECT * FROM User WHERE username = ? AND password = ?";
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, username);
	        stmt.setString(2, password);  

	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	        	user=new User();
	        	user.setUserId(rs.getLong("user_id"));
	        	user.setUsername(rs.getString("username"));
	        	user.setEmail(rs.getString("email"));
	        	user.setRole(rs.getString("role"));
	        	
	        	return user;
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
        
		return user;
	}
}
