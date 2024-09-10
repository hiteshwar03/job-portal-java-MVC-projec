package com.job.model;

public class Candidate {
	int candidateId;
	Long jobSeekerId; //FK
	String cover;
	byte[] resume;
	
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public Long getJobSeekerId() {
		return jobSeekerId;
	}
	public void setJobSeekerId(Long jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public byte[] getResume() {
		return resume;
	}
	public void setResume(byte[] resume) {
		this.resume = resume;
	}
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Candidate(int candidateId, Long jobSeekerId, String cover, byte[] resume) {
		super();
		this.candidateId = candidateId;
		this.jobSeekerId = jobSeekerId;
		this.cover = cover;
		this.resume = resume;
	}
	
	
}
