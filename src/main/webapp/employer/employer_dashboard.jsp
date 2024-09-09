<%@page import="com.job.model.Company"%>
<%@page import="com.job.model.User"%>
<%@page import="com.job.dao.CompanyDao"%>
<%@ page session="true"%>
<%@ page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

</head>
<body>
	<%@ include file="/components/employer_navbar.jsp"%>  
	
	
	<p>Hello: ${sessionScope.user.username}  (${sessionScope.user.role})</p>  
	  
	
	<p>As an employer, you can manage your job postings and
		applications here.</p>
		

	<h3>Comapny Name: ${company.companyName}</h3>
	<p>Address:  ${company.companyAddress}</p>
	<p>Email:  ${company.companyEmail}</p>

	<!-- Displaying posted jobs -->
	<h3>Your Posted Jobs</h3>
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
							
							<td><a href="view-job?id=${job.jobId}">View</a> | <a
								href="edit-job?id=${job.jobId}">Edit</a> | <a
								href="delete_job.jsp?id=${job.jobId}">delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>


	
</body>
</html>



