<%@ page session="true" %>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<html>
<head>

</head>
<body>
	<%@ include file="/components/candidate_navbar.jsp"%> 
	<p>Welcome: ${sessionScope.user.username} (${sessionScope.user.role})</p> 
	  
	
	<p>As an job seeker, you can apply for the job here.</p>

	<h1>All the jobs</h1>
	<table class="table">
				<thead>
					<tr>
						<th>Job Title</th>
						<th>Location</th>
						<th>Job Type</th>
						<th>Posted date</th>
						<th>Status</th>
						<th>Company</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>


					<c:forEach var="job" items="${allJobs}">
						<tr>
							<td>${job.jobTitle}</td>
							<td>${job.location}</td>
							<td>${job.jobType}</td>
							<td>${job.postedDate}</td>
							<td>${job.status}</td>
							<td>${job.company.companyName}</td>
							
							<td><a href="view-job?id=${job.jobId}">View Details</a> 
						</tr>
					</c:forEach>
				</tbody>
			</table>
</body>