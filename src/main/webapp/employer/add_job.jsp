<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	main{
		background-color:#F7F7F8;
	}
	.main-content{
		width:82%;
		margin:0 auto;
		padding:2rem;
	}
	form{
		display:flex;
		gap:1rem;
		
		& .section1{
			width:50%;
		}
		& .section2{
			width:50%;
			margin-top:2rem;
		}
		
	}
	.btn-container{
		display: flex;
		justify-content:center;
		gap:2rem;
	}
	.heading{
		margin-left:40rem;
	}
</style>
</head>
<body>
	<%@ include file="/components/employer_navbar.jsp"%>

	<main>
			<h2 class="heading">Post Your Job</h2>
		<div class="main-content">
					<form action="${pageContext.request.contextPath}/add-job" method="POST">
				 		<section class="section1">
			
							<div class="mb-3">
								<label for="title1" class="form-label">Title for Job:</label>
								<input type="text" class="form-control" name="jobTitle" id="title1" placeholder="Enter title for job">
							</div>
							
								 <div class="mb-3">
						  	<label for="exampleInputEmail1" class="form-label">Job Type:</label>
						  	<select class="form-select" name="jobType" required>
					        	<option selected>-Select Job Type-</option>
							  	<option value="Full Time">Full Time</option>
								<option value="Part Time">Part Time</option>
								<option value="Contract">Contract</option>
								<option value="Internship">Internship</option>
							</select>
						 </div>
							
							<div class="mb-3">
								<label for="loc" class="form-label">Job Location:</label>
								<input type="text" class="form-control" name="location" id="loc" placeholder="Enter job location">
							</div>
							
							
									
							 <div class="mb-3">
						  	<label for="status" class="form-label">Status:</label>
						  	<select class="form-select" name="status" id="status" required>
					        	<option selected>-Select Status-</option>
								<option value="Open">Open</option>
								<option value="Close">Close</option>
							</select>
						 </div>
						
						 <div class="mb-3">
						  	<label for="exp" class="form-label">Experience:</label>
						  	<select class="form-select" name="experience" id="exp" required>
					        	<option value="0 Year">0 Year</option>
								<option value="1 Year">1 Year</option>
								<option value="2 Year">2 Year</option>
								<option value="3 Year">3 Year</option>
								<option value="4 Year">4 Year</option>
								<option value="5 Year">5 Year</option>
								<option value="6 Year">6 Year</option>
								<option value="7 Year">7 Year</option>
								<option value="8 Year">8 Year</option>
								<option value="9 Year">9 Year</option>
								<option value="10 Year">10 Year</option>
							</select>
						 </div>
							 	
						<div class="mb-3 form-floating">
								<textarea class="form-control" placeholder="Leave a comment here" name="jobDesc" id="floatingTextarea2" style="height: 100px"></textarea>
			  					<label for="floatingTextarea2">Enter description for job</label>
						</div>
					 </section>
			
					 <section class="section2">
			
						<div class="mb-3 form-floating">
								<textarea class="form-control" placeholder="Leave a comment here" name="requirement" id="floatingTextarea2" style="height: 100px"></textarea>
			  					<label for="floatingTextarea2">Enter Requirement</label>
						</div>
						
						<div class="mb-3 form-floating">
								<textarea class="form-control" placeholder="Leave a comment here" name="responsibilities" id="floatingTextarea2" style="height: 100px"></textarea>
			  					<label for="floatingTextarea2">Enter Responsibilities</label>
						</div>
						
						<div class="mb-3 form-floating">
								<textarea class="form-control" placeholder="Leave a comment here" name="benefits" id="floatingTextarea2" style="height: 100px"></textarea>
			  					<label for="floatingTextarea2">Enter Benefits of this job</label>
						</div>
						
						<div class="mb-3">
								<label for="op" class="form-label">Total vacancy:</label>
								<input type="number" class="form-control" name="openings" id="op" placeholder="Enter total vacancy">
							</div>
						
							<div class="mb-3">
								<label for="sal" class="form-label">Salary:</label>
								<input type="number" class="form-control" name="salary" id="sal" placeholder="Enter salary here">
							</div>
						
						 <div class="btn-container">
						 	<input type="submit" class="btn btn-primary" value="Add Job">
						 	<input type="reset" class="btn btn-secondary" value="Cancel">
						 </div>
						 
					 </section>
			</form>
		</div>
	</main>
	

</body>
</html>