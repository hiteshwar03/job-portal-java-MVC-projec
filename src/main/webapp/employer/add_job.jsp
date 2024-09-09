<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/components/employer_navbar.jsp"%>

	<h2>Post Job</h2>
	<form action="${pageContext.request.contextPath}/add-job" method="POST">
		<label for="username">Title:</label> 
		<input type="text" name="jobTitle" required><br> 
		
		<label for="username">Job Description:</label>
		<textarea name="jobDesc"></textarea> <br> 
		
		<label for="username">Job Location</label> 
		<input type="text" name="location" required><br> 
		
		<label for="username">Salary:</label> 
		<input type="number" name="salary" required><br> 
		
		<label for="username">Job Type:</label>
		<select name="jobType">
			<option value="Full Time">Full Time</option>
			<option value="Part Time">Part Time</option>
			<option value="Contract">Contract</option>
			<option value="Internship">Internship</option>
		</select> <br> 
		
		<label for="username">Status:</label>
		<select name="status">
			<option value="Open">Open</option>
			<option value="Close">Close</option>
		</select> <br> 		
		
		 <input type="submit" value="Register">
	</form>
	
	<button onclick="history.back()">Back to Dashboard</button>
	

</body>
</html>