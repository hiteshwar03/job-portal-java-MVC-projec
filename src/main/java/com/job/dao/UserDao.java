package com.job.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.job.model.User;

public class UserDao {

	Connection con = null;

	public UserDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal_db", "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean addUser(User user) {
		String sql = "INSERT INTO User (username, password, email, role, phone ) VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getRole());
			stmt.setString(5, user.getPhone());
			
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
	        	user.setPhone(rs.getString("phone"));
	        	
	        	
	        	return user;
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
        
		return user;
	}

	public User getUserById(Long userid) {
		User user=null;
		try {
			String sql = "SELECT * FROM User WHERE user_id ="+userid;
	        PreparedStatement stmt = con.prepareStatement(sql);

	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	        	user=new User();
	        	user.setUserId(rs.getLong("user_id"));
	        	user.setUsername(rs.getString("username"));
	        	user.setEmail(rs.getString("email"));
	        	user.setPhone(rs.getString("phone"));
	        	user.setStatus(rs.getString("status"));
	        	
	        	return user;
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}

	public void updateUser(Long userId, String phone) {
	    String sql = "UPDATE User SET phone = ? WHERE user_id = ?";

	    try (PreparedStatement stmt = con.prepareStatement(sql)) {
	        // Set the phone number and user ID
	        stmt.setString(1, phone);  // Set the provided phone number
	        stmt.setLong(2, userId);   // Set the provided user ID

	        // Execute the update
	        stmt.executeUpdate();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
