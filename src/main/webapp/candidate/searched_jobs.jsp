<%@ page session="true" %>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
	<head>
		<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet"></link>
		<title>Canidate-Dashboard</title>
		<style type="text/css">
				main{
				margin:0 auto;
				height: auto;
				
			}
			.container{
				display: flex;
				gap: 1rem;
				background-color: rgb(247, 249, 250);
				padding: 2rem 6rem;
			}
			aside{
				box-shadow: 0 0 2px 0px rgba(0, 0, 0, 0.2);
				width: 25%;
				background-color: white;
				border-radius: 12px;
				height: 50vh;
				display: flex;
				gap: 1rem;
				flex-direction: column;
				align-items: center;
				padding: 1rem;
			}
			section{
				box-shadow: 0 0 5px 0 rgba(0, 0, 0, 0.2);
				width: 75%;
				background-color: rgb(247, 249, 250);
				display: flex;
				flex-direction: column;	
				gap: 3rem;
				padding: 3rem 8rem;
				border-radius: 12px;
				background-color: white;
				
			}
			.fa-user-circle{
				font-size: 5rem;
				padding: 1rem 3.9rem;
			}
			.job-card{
				border-radius: 16px;
				box-shadow: 0px 0px 1px 2px rgba(114, 112, 112, 0.2);
				height: 13rem;
				background-color: white;
				display: flex;
				flex-direction: column;
				padding:1rem 3rem;
				
		
			}
			.duration{
				width: 16rem;
				display: flex;
				justify-content: space-between;
				color:rgb(95, 102, 120);
			}
			#job-title{
				font-size: 1.5rem;
				color:rgb(18, 18, 36);
			}
			.company{
				margin: 0.3rem 0rem;
				color:rgb(95, 102, 120);
			}
			#company-name{
				font-size: 1.2rem;
				margin: 0.3rem 0.1rem;
				color:rgb(95, 102, 120);
			}
			.btn-view-details{
				background-color: rgb(14, 86, 220);
				color: rgb(251, 251, 251);
				border: none;
				border-radius: 5px;
				padding: 0.5rem 1.6rem;
				position: relative;
				text-decoration: none;
				position: relative;
				left:80%;
				top:-0.6rem;
			}
			.btn-view-details:hover{
				background-color: rgb(5, 47, 201);
				color:white;
			}
			.horozontal-line{
				margin: -0.2rem 0;
			}
			#emailid, #phone{
				width:80%;
			}
			#emailid p, #phone p{
				font-size: 0.9rem;
			}
			#view-profile{
				display:inline-block;
				padding: 0.4rem 1.2rem;
				text-decoration: none;
				margin-top:4rem;
				background-color: green;
				color:white;
			}
			#username1{
				color:rgb(95, 102, 120);
			}
		</style>
	</head>
	
	<body>
		<%@ include file="/components/candidate_navbar.jsp"%> 
		
		
		<main>
		<div class="container">
			<aside>
				<div>
					<i class="fa-solid fa-user-circle"></i>
				</div>
				<div>
					<h4 id="username1">${fn:toUpperCase(sessionScope.user.username)}</h4>
				</div>
				<div id="emailid">
					<p><i class="fa-solid fa-envelope"></i> ${sessionScope.user.email}</p>
				</div>
				<div id="phone">
					<p><i class="fa-solid fa-phone"></i>${sessionScope.user.phone}</p>
				</div>
				<div>
					<a href="view-profile" id="view-profile">View Profile</a>
				</div>
			</aside>
			<section>
				
				
				<c:choose>
			        <c:when test="${empty allJobs}">
						<h2>${msg}</h2>
			        </c:when>
			        <c:otherwise>
			            <c:forEach var="job" items="${allJobs}">
							<div class="job-card">
									<h2 id="job-title">${job.jobTitle}</h2>
								<div class="company">
									<h4 id="company-name">${job.company.companyName}</h4>
									<p><i class="fa-solid fa-location-dot"></i> ${job.location}</p>
								</div>
								
								<div class="duration">
									<p><i class="fa-solid fa-briefcase"></i> ${job.experience}</p>
									<p><i class="fa-solid fa-indian-rupee-sign"></i> ${job.salary}/- per anum</p>
								</div>
								
								<div class="btn-apply-container">
									<hr class="horozontal-line">
									<a href="view-job-details?id=${job.jobId}" class="btn-view-details">View Details</a>
								</div>
							</div>
						</c:forEach>
			        </c:otherwise>
			    </c:choose>
			    
			</section>
		</div>
	</main>
	</body>
</html>