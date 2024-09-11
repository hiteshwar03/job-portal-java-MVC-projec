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
		
		</style>
	</head>
<body>	

	<%@ include file="/components/employer_navbar.jsp"%> 
	
	<main>
		<div class="main-content">
			<div>
				<h2>Want to apply for this job ? </h2>
				<hr>
			</div>
			
			<div class="job-title">
				<h3 class="title">${job.jobTitle} </h3>
				<h4>${job.jobType}</h4>
			</div>
						
			<div class="experience-money">
				<p>Experience: <span>${job.experience}</span></p>
				<p><i class="fas fa-money-bill-alt"></i>  &#8377; ${job.salary} /- per anum</p>
			</div>
			
			<div class="horizontal-line"></div>
	
			<div class="total-vacancy">
				<p>Total Vacancy: <span>${job.vacancy}</span></p>
			</div>
			<div class="posted-date">
				<p>Posted on: <span>${job.postedDate}</span></p>
			</div>
			<div class="status">
				<p>Status: <span>${job.status}</span></p>
			</div>
			
			<div class="job-location">
				<p>Job Location: <span>${job.location}</span></p>
			</div>
			

			<div class="job-requirements">
				<strong>Requirements:</strong>
				<p>${job.requirement}</p>
			</div>
			
			<div class="job-responsibilities">
				<strong>Responsibilities:</strong>
				<p>${job.responisibilities}</p>
			</div>

			<div class="job-benefits">
				<strong>Benefits:</strong>
				<p>${job.benefits}</p>
			</div>
			
		</div>
    </main>
</body>
</html>