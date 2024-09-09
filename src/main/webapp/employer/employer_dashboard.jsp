<%@ page session="true"%>
<%@ page import="java.sql.*"%>

<html>
<head>

</head>
<body>
	<%@ include file="/components/employer_navbar.jsp"%>  
	
	<p>Hello: ${sessionScope.user.username} (${sessionScope.user.role})</p> 
	  
	
	<p>As an employer, you can manage your job postings and
		applications here.</p>

	<!-- Displaying posted jobs -->
	<h3>Your Posted Jobs</h3>


	
</body>
</html>



