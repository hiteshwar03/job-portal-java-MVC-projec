package com.job.model;

import java.sql.Timestamp;

public class Company {
    private Long companyId;
    private String companyName;
    private String companyAddress;
    private String companyWebsite;
    private String companyEmail;
    private Timestamp addedOn;
    
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyWebsite() {
		return companyWebsite;
	}
	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public Timestamp getAddedOn() {
		return addedOn;
	}
	public void setAddedOn(Timestamp addedOn) {
		this.addedOn = addedOn;
	}
	public Company(Long companyId, String companyName, String companyAddress, String companyWebsite,
			String companyEmail, Timestamp addedOn) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyWebsite = companyWebsite;
		this.companyEmail = companyEmail;
		this.addedOn = addedOn;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", companyAddress=" + companyAddress
				+ ", companyWebsite=" + companyWebsite + ", companyEmail=" + companyEmail + ", addedOn=" + addedOn
				+ "]";
	}
    
    
    
}
