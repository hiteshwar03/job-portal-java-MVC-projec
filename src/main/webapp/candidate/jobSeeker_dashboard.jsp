<%@ page session="true" %>
<%@ page import="java.sql.*" %>

<%@ include file="/components/candidate_navbar.jsp"%>  
	
	
<html>
<head>

</head>
<body>
	<p>Welcome: ${sessionScope.user.username} (${sessionScope.user.role})</p> 
	  
	
	<p>As an job seeker, you can apply for the job here.</p>

</body>