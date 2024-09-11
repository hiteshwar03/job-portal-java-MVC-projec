package com.job.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.job.model.Application;
import com.job.model.Candidate;
import com.job.model.Company;
import com.job.model.Job;
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
		String sql = "INSERT INTO Application (candidate_id, job_id, user_id) VALUES (?, ?, ?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setLong(1, application.getCandidateId());
			stmt.setLong(2, application.getJobId());
			stmt.setLong(3, application.getCandidate().getUserId());
			
			
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

	public List<Application> getAllApplication() {
		List<Application> applications=new ArrayList<Application>();
		
		String sql="select a.application_id, a.job_id, a.candidate_id, a.status, a.applied_on, j.job_title, j.location, j.salary, j.job_type, j.posted_on, j.status, j.experience, c.resume, u.phone, u.username, u.email FROM Application a JOIN Job j ON a.job_id=j.job_id\r\n"
				+ "JOIN candidate c ON a.candidate_id=c.candidate_id JOIN user u ON a.candidate_id=u.user_id";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {				
				Job job = new Job();
				
				job.setJobId(rs.getLong("job_id"));
				job.setJobTitle(rs.getString("job_title"));
				job.setLocation(rs.getString("location"));
				job.setJobType(rs.getString("job_type"));
				job.setStatus(rs.getString("status"));
				job.setSalary(rs.getDouble("salary"));
				job.setPostedDate(rs.getTimestamp("posted_on"));
				job.setExperience(rs.getString("experience"));
				
				User user=new User();
				user.setPhone(rs.getString("phone"));
				user.setUserId(rs.getLong("candidate_id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				
				Application application=new Application();
				application.setApplicationId(rs.getInt("application_id"));
				application.setStatus(rs.getString("status"));
				application.setApplicationDate(rs.getTimestamp("applied_on"));
				application.setCandidateId(rs.getLong("candidate_id"));
				application.setJob(job);
				application.setCandidate(user);
				
				applications.add(application);
				

			}
			
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			 e.printStackTrace();  

		}
		
		return applications;
	}

	public boolean isApplicationDone(Long userId) {
		String sql="select application_id from application where user_id="+userId;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {				
				return true;
			}
			
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			 e.printStackTrace();  

		}
		
		return false;
	}

	
}
