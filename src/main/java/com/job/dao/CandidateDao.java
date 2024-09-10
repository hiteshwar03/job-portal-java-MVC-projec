package com.job.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.job.model.Candidate;

public class CandidateDao {

	Connection con = null;

	public CandidateDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal_db", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean addCandidate(Candidate candidate) {
		String sql = "INSERT INTO Candidate (job_seeker_id, cover, resume) VALUES (?, ?, ?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setLong(1, candidate.getJobSeekerId());
			stmt.setString(2, candidate.getCover());
			stmt.setBytes(3, candidate.getResume());
			
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

	public Long  getCandidateIdByJobSeekerId(Long userId) {
		try {
			PreparedStatement stmt = con.prepareStatement("select candidate_id from Candidate where job_seeker_id=?");
			stmt.setLong(1, userId);
			
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				Long id=rs.getLong(("candidate_id"));
				return id;
						
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1l;
	}

}
