<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
<%@ include file="/components/candidate_navbar.jsp"%> 
	
	<h2>Apply for this job ? </h2>
	<h3>Title: ${job.jobTitle}</h3>
	<h4>Job Details for: ${job.company.companyName}</h4>
	
	
	<h5>Job Details for: ${job.jobDescription}</h5>
	<h5>Job Details for: ${job.location}</h5>
	<h5>Job Details for: ${job.salary}</h5>
	<h5>Job Details for: ${job.status}</h5>
	<h5>Job Details for: ${job.postedDate}</h5>
	
	
	<form action="apply-job" method="post" enctype="multipart/form-data">
		
		<input type="hidden" name="jobId" value="${job.jobId }" required><br> 
				
		<label>Skills: </label> 
		<input type="text" name="skills" required><br> 
		
		<label for="username">Resume</label>
		<input type="file" name="resume" accept=".pdf"> <br> 
		
		
		 <input type="submit" value="Apply">
	</form>
	
</body>
</html>