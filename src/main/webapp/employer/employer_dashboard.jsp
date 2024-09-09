<%@ page session="true" %>
<%@ page import="java.sql.*" %>

<p>Hello: ${sessionScope.user.username}</p>
Role: ${sessionScope.user.role}
<p>As an employer, you can manage your job postings and applications here.</p>

<!-- Links to different functionalities -->
<a href="post_job.jsp">Post a New Job</a><br>
<a href="viewPostedJobs.jsp">View Your Posted Jobs</a><br>
<a href="manageApplications.jsp">Manage Job Applications</a><br>

<!-- Displaying posted jobs -->
<h3>Your Posted Jobs</h3>


<a href="logout.jsp">Logout</a>
