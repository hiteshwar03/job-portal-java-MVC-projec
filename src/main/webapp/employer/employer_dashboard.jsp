<%@page import="com.job.model.Company"%>
<%@page import="com.job.model.User"%>
<%@page import="com.job.dao.CompanyDao"%>
<%@ page session="true"%>
<%@ page import="java.sql.*"%>

<html>
<head>

</head>
<body>
	<%@ include file="/components/employer_navbar.jsp"%>  
	
	<%
		HttpSession session2=request.getSession();
	 	User user=(User) session2.getAttribute("user");
	%>
	
	<p>Hello: <%= user.getUsername() %>  (<%= user.getRole() %>)</p>  
	  
	
	<p>As an employer, you can manage your job postings and
		applications here.</p>
		
	<%
		CompanyDao companyDao=new CompanyDao();
		Company company= companyDao.isCompanyExist(user.getUserId());
	
	%>
	<h3>Comapny Name: <%= company.getCompanyName() %></h3>
	<p>Address: <%= company.getCompanyAddress() %></p>
	<p>Email: <%= company.getCompanyEmail() %></p>

	<!-- Displaying posted jobs -->
	<h3>Your Posted Jobs</h3>


	
</body>
</html>



