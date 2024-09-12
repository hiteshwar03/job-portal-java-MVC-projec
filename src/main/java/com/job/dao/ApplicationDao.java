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
			stmt.setLong(3, application.getUser().getUserId());
			
			
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
				+ "JOIN candidate c ON a.candidate_id=c.candidate_id JOIN user u ON a.user_id=u.user_id";
		
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
				application.setUser(user);
				
				applications.add(application);
				

			}
			
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			 e.printStackTrace();  

		}
		
		return applications;
	}

	public boolean isApplicationDone(Long jobid, Long userId) {
		String sql="select * from application where user_id=? and job_id=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, userId);
			pstmt.setLong(2, jobid);
			
			
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {				
				return true;
			}
			

		} catch (Exception e) {
			 e.printStackTrace();  

		}
		
		return false;
	}

	public List<Application> getAllApplicationsById(Long userId) {
		List<Application> applications=new ArrayList<Application>();
		
		String sql="select job_id from application where user_id="+userId;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {				
				Job job = new Job();
				job.setJobId(rs.getLong("job_id"));
				
				
				Application application=new Application();
				application.setJob(job);
				
				applications.add(application);
				
			}
			
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			 e.printStackTrace();  

		}
		
		return applications;
	}

	public Application getApplicationId(Long appid) {
		String sql="select a.application_id, a.job_id, a.candidate_id, a.status, a.applied_on, j.job_title, j.location, j.salary, j.job_type, j.posted_on, j.status, j.experience, c.resume, c.cover, u.phone, u.username, u.email FROM Application a JOIN Job j ON a.job_id=j.job_id\r\n"
				+ "JOIN candidate c ON a.candidate_id=c.candidate_id JOIN user u ON a.user_id=u.user_id where application_id=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, appid);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {				
				Job job = new Job();
				
				job.setJobId(rs.getLong("job_id"));
				job.setJobTitle(rs.getString("job_title"));
				job.setLocation(rs.getString("location"));
				job.setJobType(rs.getString("job_type"));
				job.setStatus(rs.getString("status"));
				job.setSalary(rs.getDouble("salary"));
				job.setPostedDate(rs.getTimestamp("posted_on"));
				job.setExperience(rs.getString("experience"));
				
				Candidate candidate=new Candidate();
				candidate.setCover(rs.getString("cover"));
				candidate.setResume(rs.getBytes("resume"));
				
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
				application.setUser(user);
				application.setCandidate(candidate);
				
				return application;

			}
			
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			 e.printStackTrace();  

		}
		
		return null;
	}

	public boolean updateApplication(Application application, Long appid) {
		String sql="update application set status=? where application_id="+appid;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, application.getStatus());
			int res = pstmt.executeUpdate();
			
			if(res>0) {
				return true;
			}
		} catch (Exception e) {
			 e.printStackTrace();  

		}
		
		return false;
	}

	public List<Application> getInterviewedApplication() {
		List<Application> applications=new ArrayList<Application>();
		
		String sql="select a.application_id, a.job_id, a.candidate_id, a.status, a.applied_on, j.job_title, j.location, j.salary, j.job_type, j.posted_on, j.status, j.experience, c.resume, u.phone, u.username, u.email FROM Application a JOIN Job j ON a.job_id=j.job_id\r\n"
				+ "JOIN candidate c ON a.candidate_id=c.candidate_id JOIN user u ON a.user_id=u.user_id where a.status=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "Interview");
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
				application.setUser(user);
				
				applications.add(application);
				

			}
			
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			 e.printStackTrace();  

		}
		
		return applications;
	}

	public List<Application> getSelectedApplication() {
		List<Application> applications=new ArrayList<Application>();
		
		String sql="select a.application_id, a.job_id, a.candidate_id, a.status, a.applied_on, j.job_title, j.location, j.salary, j.job_type, j.posted_on, j.status, j.experience, c.resume, u.phone, u.username, u.email FROM Application a JOIN Job j ON a.job_id=j.job_id\r\n"
				+ "JOIN candidate c ON a.candidate_id=c.candidate_id JOIN user u ON a.user_id=u.user_id where a.status=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "Selected");
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
				application.setUser(user);
				
				applications.add(application);
				

			}
			
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			 e.printStackTrace();  

		}
		
		return applications;
	
	}
	public List<Application> getRejectedApplication() {
		List<Application> applications=new ArrayList<Application>();
		
		String sql="select a.application_id, a.job_id, a.candidate_id, a.status, a.applied_on, j.job_title, j.location, j.salary, j.job_type, j.posted_on, j.status, j.experience, c.resume, u.phone, u.username, u.email FROM Application a JOIN Job j ON a.job_id=j.job_id\r\n"
				+ "JOIN candidate c ON a.candidate_id=c.candidate_id JOIN user u ON a.user_id=u.user_id where a.status=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "Reject");
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
				application.setUser(user);
				
				applications.add(application);
				

			}
			
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			 e.printStackTrace();  

		}
		
		return applications;
	
	}

	public boolean deleteApplicationById(int appid) {
		String sql = "delete from application where application_id="+appid;

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			int res = stmt.executeUpdate();

			if (res > 0) {
				return true;
			}

			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public int totalApplication() {
	    String sql = "SELECT COUNT(*) FROM application";
	    int total = 0;  

	    try {
	        PreparedStatement stmt = con.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            total = rs.getInt(1);  
	        }

	        rs.close();
	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return total;  
	}

	public int totalInterviewApplication() {
	    String sql = "SELECT COUNT(*) FROM application where status=?";
	    int total = 0;  

	    try {
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, "Interview");
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            total = rs.getInt(1);  
	        }

	        rs.close();
	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return total;  
	}
	public int totalSelectedApplication() {
	    String sql = "SELECT COUNT(*) FROM application where status=?";
	    int total = 0;  

	    try {
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, "Selected");
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            total = rs.getInt(1);  
	        }

	        rs.close();
	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return total;  
	}
	
	public int totalRejectedApplication() {
	    String sql = "SELECT COUNT(*) FROM application where status=?";
	    int total = 0;  

	    try {
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, "Rejected");
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            total = rs.getInt(1);  
	        }

	        rs.close();
	        stmt.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return total;  
	}
	
	
}
