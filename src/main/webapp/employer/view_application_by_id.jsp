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
		.job-user-details{
			display:flex;
			flex-direction:column;
			gap:2rem;
			align-items:center;
			width:100%;
		}
		
		.container-job, .container-user{
			dislay:flex;
			flex-direction: column;
			background-color:orange;
			box-shadow: 0 0 2px 0 rgba(0, 0, 0, 0.2);
			width:80%;
			padding: 2rem;
			border-radius: 12px;
		}
		
		</style>
	</head>
<body>	

	<%@ include file="/components/employer_navbar.jsp"%> 
	
	<main>
		<div class="main-content">
			<div>
				<h2>Please select candidate ? </h2>
				<hr>
			</div>
			
			<div class="job-user-details">
				<div class="container-job">
					<div class="job-id">
						<p class="id">Job ID: ${application.job.jobId} </p>
					</div>
					<div class="job-title">
						<p class="title">${application.job.jobTitle} </p>
					</div>
					<div class="job-location">
						<p class="location">${application.job.location} </p>
					</div>
					<div class="job-experience">
						<p class="experience">${application.job.experience} </p>
					</div>
					<div class="job-type">
						<p class="job-type-heading">${application.job.jobType} </p>
					</div>
					<div class="job-postedDate">
						<p class="postedDate">${application.job.postedDate} </p>
					</div>
					
					<div class="job-status">
						<p class="status">${application.job.status} </p>
					</div>
					
				</div>
				<div class="container-user">
					<div class="user-id">
						<p class="id">Candidate ID: ${application.user.userId} </p>
					</div>
					<div class="user-phone">
						<p class="phone">${application.user.phone} </p>
					</div>
					<div class="user-username">
						<p class="username">${application.user.username} </p>
					</div>
					<div class="user-email">
						<p class="email">${application.user.email} </p>
					</div>			
					<div class="user-cover">
						<p class="cover">${application.candidate.cover} </p>
					</div>			
						
					<div class="user-resume">
						<p class="resume">${application.candidate.resume} </p>
					</div>			
				</div>
			</div>

			<div class="job-requirements">
				<form action="${pageContext.request.contextPath}/employer/update-application" method="POST">
					<input type="hidden" name="id" value="${application.applicationId}">
					<strong>Application status:</strong>
					<select name="applicationStatus">
						 <option value="Applied" <c:if test="${application.status == 'Applied'}">selected</c:if>>Applied</option>
						 <option value="Interview" <c:if test="${application.status == 'Interview'}">selected</c:if>>Interview</option>
						 <option value="Selected" <c:if test="${job.status == 'Selected'}">selected</c:if>>Selected</option>
						 <option value="Reject" <c:if test="${job.status == 'Reject'}">selected</c:if>>Reject</option>
					</select>
					<div id="btn-edit">
						<button type="submit">Update</button>
					</div>
				</form>
			</div>

			
			
		</div>
    </main>
</body>
</html>