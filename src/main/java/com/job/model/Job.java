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
    private String experience;
    private String requirement;
    private String responisibilities;
    private String benefits;
    private String vacancy;
    
    
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

	

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getResponisibilities() {
		return responisibilities;
	}

	public void setResponisibilities(String responisibilities) {
		this.responisibilities = responisibilities;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public String getVacancy() {
		return vacancy;
	}

	public void setVacancy(String vacancy) {
		this.vacancy = vacancy;
	}

	

	public Job(Long jobId, Long employerId, String jobTitle, String jobDescription, String location, double salary,
			String jobType, Timestamp postedDate, String status, String experience, String requirement,
			String responisibilities, String benefits, String vacancy, Company company) {
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
		this.experience = experience;
		this.requirement = requirement;
		this.responisibilities = responisibilities;
		this.benefits = benefits;
		this.vacancy = vacancy;
		this.company = company;
	}

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", employerId=" + employerId + ", jobTitle=" + jobTitle + ", jobDescription="
				+ jobDescription + ", location=" + location + ", salary=" + salary + ", jobType=" + jobType
				+ ", postedDate=" + postedDate + ", status=" + status + ", experience=" + experience + ", requirement="
				+ requirement + ", responisibilities=" + responisibilities + ", benefits=" + benefits + ", vacancy="
				+ vacancy + ", company=" + company + "]";
	}  
    
    
    
    
}
