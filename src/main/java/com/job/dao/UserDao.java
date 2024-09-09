package com.job.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
		String sql = "INSERT INTO user (username, password, email, role, phone ) VALUES (?, ?, ?, ?, ?)";

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
			// TODO: handle exception
		}
		
		return false;
	}
}
