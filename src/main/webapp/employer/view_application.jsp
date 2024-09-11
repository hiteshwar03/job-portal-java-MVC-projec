<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
		<style type="text/css">
			main {
		  width: 80vw;
		  margin: 0 auto;
		  height: 100%;
		  background-color: rgb(247, 249, 250);
		  padding: 1rem 5rem;
	  }
	  .main-content {
		width:60%;
		margin: 0 auto;
		box-shadow: 0 0 2px 0 rgba(0, 0, 0, 0.2);
		padding: 2rem;
		background-color: white;
		border-radius: 30px;
		display: flex;
		flex-direction: column;
		color: rgb(95, 102, 120);
	  }
	  .company {
		width: 50%;
		display: flex;
		justify-content: space-between;
	  }
	  .job-title {
		width: 50%;
		display: flex;
		justify-content: space-between;
		font-size:0.6rem;
		}
		.title{
		  color: rgb(38, 18, 35);
	 	}
	  .horizontal-line {
		width: 100%;
		height: 1px;
		background-color: gray;
		}

		.job-requirements, .job-responsibilities , .job-benefits {
			background-color: rgb(247, 249, 250);
			box-shadow: 0 0 2px 0 rgba(0, 0, 0, 0.2);
			margin-top: 1rem;
			padding: 1rem;
			border-radius: 10px;
			font-size: 1.1rem;
		}
		
		.experience-money {
			display: flex;
			gap: 9rem;
		}
		.total-vacancy, .posted-date, .status, .job-location {
			font-size: 1.1rem;
		}
		.job-location{
			margin-bottom: 3rem;
		}
		.total-vacancy{
			margin-top: 2rem;
		}
		.total-vacancy span, .posted-date span, .status span, .job-location span{
			font-weight: 600;
			color: rgb(38, 18, 35);
		}
		#btn-edit{
			margin:2rem auto;
		}
		#btn-edit a{
			margin:0 auto;
			text-decoration: none;
			background-color: green;
			color:white;
			padding:0.4rem 1.2rem;
		}
		
		</style>
	</head>
<body>	

	<%@ include file="/components/employer_navbar.jsp"%> 
	
	<main>
		<div class="main-content">
		<table>
			 <c:forEach var="application" items="${allApplication}">
                        <tr>
							<td>${application.job.jobTitle}</td>
							<td>${application.job.location}</td>
							<td>${application.status}</td>
							<td>${application.candidate.userId}</td>
							<td>${application.candidate.phone}</td>
							<td>${application.candidate.username}</td>
							
							
						</tr>
                         </c:forEach>
                         </table>
		</div>
    </main>
</body>
</html>