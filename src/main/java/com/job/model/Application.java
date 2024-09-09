package com.job.model;

import java.sql.Timestamp;

public class Application {
	private int applicationId;
	private Long candidateId; // FK to Candidate
	private Long jobId; // FK to Job
	private String coverLetter;
	private byte[] resume;
	private Timestamp applicationDate;
	private String status; // 'pending', 'accepted', 'rejected'
	
	private Job job;
	private User candidate;
	
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	
	public Long getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public String getCoverLetter() {
		return coverLetter;
	}
	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}
	public byte[] getResume() {
		return resume;
	}
	public void setResume(byte[] resume) {
		this.resume = resume;
	}
	public Timestamp getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Timestamp applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public User getCandidate() {
		return candidate;
	}
	public void setCandidate(User candidate) {
		this.candidate = candidate;
	}
	public Application(int applicationId, Long candidateId, Long jobId, String coverLetter, byte[] resume,
			Timestamp applicationDate, String status, Job job, User candidate) {
		super();
		this.applicationId = applicationId;
		this.candidateId = candidateId;
		this.jobId = jobId;
		this.coverLetter = coverLetter;
		this.resume = resume;
		this.applicationDate = applicationDate;
		this.status = status;
		this.job = job;
		this.candidate = candidate;
	}
	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
