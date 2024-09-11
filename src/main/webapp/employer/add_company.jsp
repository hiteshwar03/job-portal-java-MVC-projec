<html>
<head>
	<style>
			main{;
				margin:0 auto;
			}
			.main-content{
				width:30vw;
				margin:0 auto;
				padding:1rem 5rem;
				background-color:#F7F7F8;
			}
			.btn{
				width:26rem;
				height: 2.2rem;
			}
			
		</style>
</head>
<body>
	<%@ include file="/components/employer_navbar.jsp" %>
	
	<main>
		<div class="main-content">
			<h2>Register Your Company</h2><br>
			<form action="${pageContext.request.contextPath}/employer/add-company" method="POST">
			
				<div class="mb-3">
				  	<label for="cname" class="form-label">Company Name:</label>
				    <input type="text" class="form-control" name="companyName" id="cname" placeholder="Enter compnay name" required>
				</div>
				
				<div class="mb-3 form-floating">
					<textarea class="form-control" placeholder="Leave a comment here" name="companyAddress" id="floatingTextarea2" style="height: 100px"></textarea>
  					<label for="floatingTextarea2">Company Address</label>
				</div>
				
				<div class="mb-3">
				  	<label for="web" class="form-label">Company Website:</label>
				    <input type="text" class="form-control" name="companyWebsite" id="web" placeholder="Enter compnay website url" required>
				</div>
				
				<div class="mb-3">
				  	<label for="email" class="form-label">Company Email:</label>
				    <input type="email" class="form-control" name="companyEmail" id="email" placeholder="Enter compnay address" required>
				</div>
				
				<div class="mb-3">
				  	<label for="size" class="form-label">Company Size:</label>
				    <input type="text" class="form-control" name="companySize" id="size" placeholder="Enter compnay size" required>
				</div>
				
				<div class="mb-3">
				  	<label for="year" class="form-label">Founded year:</label>
				    <input type="text" class="form-control" name="foundedYear" id="year" placeholder="Enter compnay size" required>
				</div>
				
				 <div class="mb-3">
					  	<label for="indus" class="form-label">Industry:</label>
					  	<select class="form-select" name="industry" id="indus" required>
				        	<option value="" disabled selected>Select Industry Type</option>
						    <option value="agriculture">Agriculture & Forestry</option>
						    <option value="manufacturing">Manufacturing</option>
						    <option value="construction">Construction</option>
						    <option value="it">Information Technology (IT)</option>
						    <option value="healthcare">Healthcare</option>
						    <option value="finance">Finance & Insurance</option>
						    <option value="retail">Retail & Wholesale</option>
						    <option value="transportation">Transportation & Logistics</option>
						    <option value="energy">Energy</option>
						    <option value="telecommunications">Telecommunications</option>
						    <option value="hospitality">Hospitality & Tourism</option>
						    <option value="education">Education</option>
						    <option value="real-estate">Real Estate</option>
						    <option value="media">Entertainment & Media</option>
						    <option value="government">Government & Public Administration</option>
						    <option value="non-profit">Non-profit & Social Organizations</option>
						    <option value="professional">Professional, Scientific, and Technical Services</option>
						    <option value="mining">Mining & Extraction</option>
						</select>
					 </div>
					
				<button type="submit" class="btn btn-dark">Add Company</button>
			</form>
		</div>
	</main>
</body>
</html>

