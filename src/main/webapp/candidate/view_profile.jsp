
<html>
	<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<style>
			main{;
				margin:0 auto;
			}
			.main-content{
				display: flex;
				flex-direction:column;
				justify-content: center;
				
			}
			
			.login-form{
				padding: 2rem 4rem;
				border-radius: 8px;
				width:35%;
				margin:0 auto;
				background-color:#F7F7F8;
				
				& .btn-register{
					background-color:#3572EF;
					width:25.7rem;
					border:none;
					color:white;
					height:35px;
					border-radius: 4px;
				}
			}
		</style>
	</head>
	<body>
		
		<%@ include file="/components/candidate_navbar.jsp" %>
		
		<main>
			<div class="main-content">
				
				<div class="login-form">
					<h2>Your Profile</h2><br>
					<form action="${pageContext.request.contextPath}/candidate/update-candidate-profile" method="POST">
						<input type="hidden" name="id" value="${sessionScope.user.userId}">
						<div class="mb-3">
						  	<label for="exampleInputEmail1" class="form-label">Username:</label>
						    <input type="text" class="form-control" name="username" value="${sessionScope.user.username}" readonly id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter username">
						 </div>
						 
						 <div class="mb-3">
						  	<label for="exampleInputEmail1" class="form-label">Email:</label>
						    <input type="email" class="form-control" name="email" value="${sessionScope.user.email}" readonly id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email address">
						 </div>
						 
						 <div class="mb-3">
						  	<label for="exampleInputEmail1" class="form-label">Phone:</label>
						    <input type="number" class="form-control" name="phone" value="${sessionScope.user.phone}" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Phone number">
						 </div>
						 
						 <div class="mb-3">
						  	<label for="exampleInputEmail1" class="form-label">Role:</label>
						    <input type="text" class="form-control" name="role" value="${sessionScope.user.role}" readonly id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Phone number"> 	
						 </div>
						 
						 <input type="submit" class="btn-register" value="Update">
						
					</form>
				</div>
			</div>
		</main>

	</body>
</html>