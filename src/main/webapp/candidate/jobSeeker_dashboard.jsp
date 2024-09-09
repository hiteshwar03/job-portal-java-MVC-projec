<%@ page session="true" %>
<%@ page import="java.sql.*" %>

<p>Welcome: ${sessionScope.user.username}</p>
${sessionScope.user.role}



<a href="logout">Logout</a>
