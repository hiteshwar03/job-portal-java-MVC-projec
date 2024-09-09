package com.job.model;

import java.util.List;

public class User{
    private Long userId;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String role;  
    private String status;

    // Relationships
    private List<Job> jobs;  // If the user is an employer, they can post multiple jobs.
    private List<Application> applications; // If the user is a job seeker, they can have multiple job applications.
    
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	public List<Application> getApplications() {
		return applications;
	}
	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	public User(Long userId, String username, String password, String phone, String email, String role, String status,
			List<Job> jobs, List<Application> applications) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.role = role;
		this.status = status;
		this.jobs = jobs;
		this.applications = applications;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

  
    
}
