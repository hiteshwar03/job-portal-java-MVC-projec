package com.job.model;

import java.sql.Timestamp;


public class Job {
	private Long jobId;
	private Long employerId;  //FK to employer
    private String jobTitle;
    private String jobDescription;
    private String location;
    private double salary;
    private String jobType;
    private Timestamp postedDate;  
    private String status;  
    
    // Relationship
    private Company company;

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	

	public Long getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	

	public Timestamp getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Timestamp postedDate) {
		this.postedDate = postedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	

	public Job(Long jobId, Long employerId, String jobTitle, String jobDescription, String location, double salary,
			String jobType, Timestamp postedDate, String status, Company company) {
		super();
		this.jobId = jobId;
		this.employerId = employerId;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.location = location;
		this.salary = salary;
		this.jobType = jobType;
		this.postedDate = postedDate;
		this.status = status;
		this.company = company;
	}

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}  
    
    
    
    
}
