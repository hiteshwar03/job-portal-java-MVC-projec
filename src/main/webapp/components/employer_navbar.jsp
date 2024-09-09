<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/components/common_style.jsp" %>
<style type="text/css">
	nav ul{
		display: flex;
		gap:1rem;
		background-color: black;
		color: white;
	}
	li{
		list-style-type: none;
	}
</style>
</head>
<body>

	<nav>
		<ul>
			<li><a href="">Home</a></li>
			<li><a href="">Add post</a></li>
			<li><a href="">View Application</a></li>
			<li><a href="">Logout</a></li>	
		</ul>
	</nav>
</body>
</html>