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
				padding: 3rem;
				border-radius: 5px;
				width:30%;
				margin:6rem auto;
				background-color:#F7F7F8;
				
				& .btn-submit{
					background-color:#3572EF;
					width:22.8rem;
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
					<h2>Login</h2><br>
					<form action="login" method="POST">
					  <div class="mb-3">
					  <label for="exampleInputEmail1" class="form-label">Email</label>
					    <input type="text" class="form-control" name="username" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="E.g. hiteshwar">
					  </div>
					  <div class="mb-3">
					  <label for="exampleInputEmail1" class="form-label">Password</label>
					    <input type="password" class="form-control" name="password"  id="exampleInputPassword1" placeholder="Enter your Password">
					  </div>
					  <input type="submit" class="btn-submit" value="Login">
					</form>
					<span>Not Registered yet ?</span> <a href="register.jsp">Register Now</a>
				</div>
			</div>
			
		</main>

	</body>
</html>