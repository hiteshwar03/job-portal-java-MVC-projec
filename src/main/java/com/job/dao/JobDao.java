package com.job.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.job.model.Company;
import com.job.model.Job;

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
		String sql = "INSERT INTO Job ( employer_id, job_title, job_description, location, salary, job_type, status, experience, requirements, responsibilities, benefits, openings ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setLong(1, job.getEmployerId());
			stmt.setString(2, job.getJobTitle());
			stmt.setString(3, job.getJobDescription());
			stmt.setString(4, job.getLocation());
			stmt.setDouble(5, job.getSalary());
			stmt.setString(6, job.getJobType());
			stmt.setString(7, job.getStatus());
			stmt.setString(8, job.getExperience());
			stmt.setString(9, job.getRequirement());
			stmt.setString(10, job.getResponisibilities());
			stmt.setString(11, job.getBenefits());
			stmt.setString(12, job.getVacancy());

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

	public List<Job> getAllJobsWithCompany() {
		String sql = "SELECT j.job_id, j.job_title, j.job_description, j.location, j.salary, j.job_type, j.status,  j.posted_on, j.experience, c.company_id, c.company_name FROM Job j JOIN Company c ON j.employer_id = c.employer_id";
//		String sql = "SELECT j.job_id, j.title, j.description, j.location, j.posted_date, e.company_name FROM jobs j JOIN employers e ON j.eid = e.employer_id where e.employer_id=?;";

		List<Job> jobs = new ArrayList<>();

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Company company = new Company();
				company.setCompanyId(rs.getLong("company_id"));
				company.setCompanyName(rs.getString("company_name"));

				Job job = new Job();

				job.setJobId(rs.getLong("job_id"));
				job.setJobTitle(rs.getString("job_title"));
				job.setJobDescription(rs.getString("job_description"));
				job.setLocation(rs.getString("location"));
				job.setJobType(rs.getString("job_type"));
				job.setStatus(rs.getString("status"));
				job.setSalary(rs.getDouble("salary"));
				job.setPostedDate(rs.getTimestamp("posted_on"));
				job.setExperience(rs.getString("experience"));
				job.setCompany(company);

				jobs.add(job);

			}
			
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			 e.printStackTrace();  

		}
		return jobs;
	}

	public Job getJobById(int jobId) {
		String sql = "SELECT j.job_id, j.job_title, j.job_description, j.location, j.salary, j.job_type, j.status, j.posted_on, j.experience, j.requirements, j.responsibilities, j.openings, j.benefits, c.company_id, c.company_name, c.company_address FROM Job j JOIN Company c ON j.employer_id = c.employer_id where j.job_id=?";

		Job job=null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, jobId);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {

				Company company = new Company();
				company.setCompanyId(rs.getLong("company_id"));
				company.setCompanyName(rs.getString("company_name"));
				company.setCompanyAddress(rs.getString("company_address"));

				job = new Job();

				job.setJobId(rs.getLong("job_id"));
				job.setJobTitle(rs.getString("job_title"));
				job.setJobDescription(rs.getString("job_description"));
				job.setLocation(rs.getString("location"));
				job.setJobType(rs.getString("job_type"));
				job.setStatus(rs.getString("status"));
				job.setSalary(rs.getDouble("salary"));
				job.setPostedDate(rs.getTimestamp("posted_on"));
				job.setExperience(rs.getString("experience"));
				job.setRequirement(rs.getString("requirements"));
				job.setResponisibilities(rs.getString("responsibilities"));
				job.setBenefits(rs.getString("benefits"));
				job.setVacancy(rs.getString("openings"));
				
				job.setCompany(company);
				
				return job;
			}
			
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			 e.printStackTrace();  

		}
		return job;
	}

	public List<Job> getAllJobsByEmployerId(Long employerId) {
		String sql = "SELECT job_id, job_title, job_description, location, salary, job_type, status, posted_on, experience FROM Job where employer_id=?";
		
		List<Job> jobs=new ArrayList<Job>();		
		Job job=null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, employerId);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				
				job = new Job();

				job.setJobId(rs.getLong("job_id"));
				job.setJobTitle(rs.getString("job_title"));
				job.setJobDescription(rs.getString("job_description"));
				job.setLocation(rs.getString("location"));
				job.setJobType(rs.getString("job_type"));
				job.setStatus(rs.getString("status"));
				job.setSalary(rs.getDouble("salary"));
				job.setPostedDate(rs.getTimestamp("posted_on"));
				job.setExperience(rs.getString("experience"));
				
				jobs.add(job);
				
			}
			return jobs;
			

		} catch (Exception e) {
			 e.printStackTrace();  

		}
		return jobs;
	}

	public boolean updateJob(Job job) {
		String sql = "update Job set employer_id=?, job_title=?, job_description=?, location=?, salary=?, job_type=?, status=?, experience=?, requirements=?, responsibilities=?, benefits=?, openings=? where job_id=?";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			
			stmt.setLong(1, job.getEmployerId());
			stmt.setString(2, job.getJobTitle());
			stmt.setString(3, job.getJobDescription());
			stmt.setString(4, job.getLocation());
			stmt.setDouble(5, job.getSalary());
			stmt.setString(6, job.getJobType());
			stmt.setString(7, job.getStatus());
			stmt.setString(8, job.getExperience());
			stmt.setString(9, job.getRequirement());
			stmt.setString(10, job.getResponisibilities());
			stmt.setString(11, job.getBenefits());
			stmt.setString(12, job.getVacancy());
			stmt.setLong(13, job.getJobId());

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

	public boolean deleteJobById(int jobid) {
		String sql = "delete from Job where job_id="+jobid;

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

}
