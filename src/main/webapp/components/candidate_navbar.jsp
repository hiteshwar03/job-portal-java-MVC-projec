
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script src="https://kit.fontawesome.com/846c497550.js"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">
<title>Document</title>
<%@ include file="/components/common_style.jsp" %>
<style>
/* styles.css */
html {
	margin: 0;
	padding: 0;
	font-family: "Poppins", sans-serif;
	font-weight: 300;
}
header{
	width: 80vw;
	margin: 0 auto;
	display:flex;
	gap:1rem;
	justify-content: space-between;
	align-items: end;
}

#logo {
	width:10%
}

nav {
	width:90%;
	display: flex;
	justify-content: space-between;
	margin: 0 auto;
	background-color: #3572EF;
	padding: 8px;
	height:3rem;
	
	& li {
		list-style: none;
		color:white;
	}

	& a {
		text-decoration: none;
		color: white;
		
		&:hover{
			color:red;
		}
	}
}

.nav1 {
	text-align: center;
	display: flex;
	gap: 1rem;
	justify-content: start;
}

.nav2 {
	text-align: center;
	display: flex;
	gap: 1rem;
	justify-content: space-between;
	margin-right: 3rem;
}




form { 
	&>input { 
		height: 1.8rem;
		width:16rem;
		border-radius: 2px;
		border: none;
	}

	&>button {
		width: 2.5rem;
		height: 1.9rem;
		border-radius: 2px;
		border:none;
		background-color: #9eb3358b;
	}

}

#username{
	font-weight: 700;
}
#role{
	font-weight: 200;
}
#logout{
	color:orange;
}
</style>

</head>
<body>

	   	<header>
			<div id="logo">
				<img alt="" src="https://logodix.com/logo/1038127.jpg" width="140px">
			</div>
			
			  <nav>
				<ul class="nav1">
					<c:choose>
						 <c:when test="${empty sessionScope.user}">
							
						  </c:when>
						  <c:otherwise>
							<li><a href="${pageContext.request.contextPath}/candidate/candidate-dashboard">Home &nbsp; </a>|</li>
							<li><a href="${pageContext.request.contextPath}/candidate/apply_job.jsp">Applied Job &nbsp; </a>|</li>
							<li><a href="#about">All Jobs</a></li>
							<li>
								<form action="">
									<input type="text" placeholder="Search Jobs here">
									<button type="submit">
										<i class="fa-solid fa-magnifying-glass"></i>
									</button>
								</form>
							</li>
						  </c:otherwise>
					</c:choose>
				</ul>
				
				<ul class="nav2">
					<li>
						<li>
						    <c:choose>
						        <c:when test="${empty sessionScope.user}">
						             <a href="${pageContext.request.contextPath}/login.jsp">Login</a>&nbsp;&nbsp; | &nbsp;&nbsp;
						           	 <a href="${pageContext.request.contextPath}/register.jsp">Signup</a>
						        </c:when>
						        <c:otherwise>
						            <a href="view-profile" id="username"><i class="fa-solid fa-user-tie"></i> ${fn:toUpperCase(sessionScope.user.username)}</a>
						            | Role: <span id="role">${sessionScope.user.role}</span>
						            | <a href="${pageContext.request.contextPath}/logout" id="logout">Logout</a>
						            
						        </c:otherwise>
						    </c:choose>
						</li>
					
				</ul>
			</nav>
				
	</header>
	<hr>
</body>
</html>
