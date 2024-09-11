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
			<h2 class="heading">Update Job</h2>
		<div class="main-content">
					<form action="${pageContext.request.contextPath}/employer/update-job" method="POST">
				 		<section class="section1">
							<input type="hidden" value="${job.jobId}" name="id"/>
							<div class="mb-3">
								<label for="title1" class="form-label">Title for Job:</label>
								<input type="text" class="form-control" name="jobTitle" value="${job.jobTitle}" id="title1" placeholder="Enter title for job">
							</div>
							
								 <div class="mb-3">
						  	<label for="exampleInputEmail1" class="form-label">Job Type:</label>
						  	<select class="form-select" name="jobType" required>
						  		<option value="Full Time" <c:if test="${job.jobType == 'Full Time'}">selected</c:if>>Full Time</option>
						  	 	<option value="Part Time" <c:if test="${job.jobType == 'Part Time'}">selected</c:if>>Part Time</option>
						  	 	<option value="Contract" <c:if test="${job.jobType == 'Contract'}">selected</c:if>>Contract</option>
						  	 	<option value="Internship" <c:if test="${job.jobType == 'Internship'}">selected</c:if>>Internship</option>								
							</select>
						 </div>
							
							<div class="mb-3">
								<label for="loc" class="form-label">Job Location:</label>
								<input type="text" class="form-control" name="location" value="${job.location}" id="loc" placeholder="Enter job location">
							</div>
							
							
									
							 <div class="mb-3">
						  	<label for="status" class="form-label">Status:</label>
						  	<select class="form-select" name="status" id="status" required>
							    <option value="Open" <c:if test="${job.status == 'open'}">selected</c:if>>Open</option>
							    <option value="Close" <c:if test="${job.status == 'close'}">selected</c:if>>Close</option>
							</select>
						 </div>
						
						 <div class="mb-3">
						  	<label for="exp" class="form-label">Experience:</label>
						  	<select class="form-select" name="experience" id="exp" required>
						  	 <option value="0 Year" <c:if test="${job.experience == '0 Year'}">selected</c:if>>0 Year</option>
						  	 <option value="1 Year" <c:if test="${job.experience == '1 Year'}">selected</c:if>>1 Year</option>
						  	 <option value="2 Years" <c:if test="${job.experience == '2 Years'}">selected</c:if>>2 Years</option>
						  	 <option value="3 Years" <c:if test="${job.experience == '3 Years'}">selected</c:if>>3 Years</option>
						  	 <option value="4 Years" <c:if test="${job.experience == '4 Years'}">selected</c:if>>4 Years</option>
						  	 <option value="5 Years" <c:if test="${job.experience == '5 Years'}">selected</c:if>>5 Years</option>
						  	 <option value="6 Years" <c:if test="${job.experience == '6 Years'}">selected</c:if>>6 Years</option>
						  	 <option value="7 Years" <c:if test="${job.experience == '7 Years'}">selected</c:if>>7 Years</option>
						  	 <option value="8 Years" <c:if test="${job.experience == '8 Years'}">selected</c:if>>8 Years</option>
						  	 <option value="9 Years" <c:if test="${job.experience == '9 Years'}">selected</c:if>>9 Years</option>
						  	 <option value="10 Years" <c:if test="${job.experience == '10 Years'}">selected</c:if>>10 Years</option>
						  	</select>
						 </div>
							 	
						<div class="mb-3 form-floating">
								<textarea class="form-control" placeholder="Leave a comment here" name="jobDesc" id="floatingTextarea2" style="height: 100px">${job.jobDescription}</textarea>
			  					<label for="floatingTextarea2">Enter description for job</label>
						</div>
					 </section>
			
					 <section class="section2">
			
						<div class="mb-3 form-floating">
								<textarea class="form-control" placeholder="Leave a comment here" name="requirement" id="floatingTextarea2" style="height: 100px"> ${job.requirement}</textarea>
			  					<label for="floatingTextarea2">Enter Requirement</label>
						</div>
						
						<div class="mb-3 form-floating">
								<textarea class="form-control" placeholder="Leave a comment here" name="responsibilities" id="floatingTextarea2" style="height: 100px"> ${job.responisibilities}</textarea>
			  					<label for="floatingTextarea2">Enter Responsibilities</label>
						</div>
						
						<div class="mb-3 form-floating">
								<textarea class="form-control" placeholder="Leave a comment here" name="benefits" id="floatingTextarea2" style="height: 100px"> ${job.benefits}</textarea>
			  					<label for="floatingTextarea2">Enter Benefits of this job</label>
						</div>
						
						<div class="mb-3">
								<label for="op" class="form-label">Total vacancy:</label>
								<input type="text" class="form-control" value=" ${job.vacancy}" name="openings" id="op" placeholder="Enter total vacancy">
							</div>
						
							<div class="mb-3">
								<label for="sal" class="form-label">Salary:</label>
								<input type="text" class="form-control" value=" ${job.salary}" name="salary" id="sal" placeholder="Enter salary here">
							</div>
						
						 <div class="btn-container">
						 	<input type="submit" class="btn btn-primary" value="Update Job">
						 	<input type="reset" class="btn btn-secondary" value="Cancel">
						 </div>
						 
					 </section>
			</form>
		</div>
	</main>
	

</body>
</html>