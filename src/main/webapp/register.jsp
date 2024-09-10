
<html>
	<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<style>
			
			.main-content{
				display: flex;
				flex-direction:column;
				justify-content: center;
				
				& #logo{
					margin-left:6rem;
				}
			}
			
			.login-form{
				padding: 2rem;
				border-radius: 8px;
				width:30%;
				margin:0 auto;
				background-color:#F7F7F8;
				
				& .btn-register{
					background-color:#3572EF;
					width:20.8rem;
					border:none;
					color:white;
					height:35px;
					border-radius: 4px;
				}
			}
		</style>
	</head>
	<body>
		
		<%@ include file="/components/employer_navbar.jsp" %>
		
		<main>
			<div class="main-content">
				
				<div class="login-form">
					<h2>Create an account</h2>
					<form action="register" method="POST">
						<div class="mb-3">
						  	<label for="exampleInputEmail1" class="form-label">Username:</label>
						    <input type="text" class="form-control" name="username" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter username">
						 </div>
						 
						 <div class="mb-3">
						  	<label for="exampleInputEmail1" class="form-label">Password:</label>
						    <input type="password" class="form-control" name="password" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter password">
						 </div>
						 
						 <div class="mb-3">
						  	<label for="exampleInputEmail1" class="form-label">Email:</label>
						    <input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email address">
						 </div>
						 
						 <div class="mb-3">
						  	<label for="exampleInputEmail1" class="form-label">Phone:</label>
						    <input type="number" class="form-control" name="phone" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Phone number">
						 </div>
						 
						 <div class="mb-3">
						  	<label for="exampleInputEmail1" class="form-label">Role:</label>
						  	<select class="form-select" name="role" aria-label="Default select example" required>
					        	<option selected>-Select the role-</option>
							  	<option value="Employer">Employer</option>
					        	<option value="JobSeeker">Job Seeker</option>
							</select>
						 </div>
						 
						 <input type="submit" class="btn-register" value="Register">
						
					</form>
					<span>Already registered ?</span> <a href="login.jsp">Login</a>
				</div>
			</div>
		</main>

	</body>
</html>