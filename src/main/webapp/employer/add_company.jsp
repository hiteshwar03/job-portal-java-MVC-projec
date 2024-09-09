<html>
<head>

</head>
<body>
	<form action="${pageContext.request.contextPath}/add-company" method="POST">
		<label for="username">Comapny Name:</label> 
		<input type="text" name="companyName" required><br> 
		
		<label for="username">Company Address:</label> 
		<textarea name="companyAddress"> </textarea><br>
		
		<label for="username">Comapny Website:</label> 
		<input type="text" name="companyWebsite" required><br> 
		 
		<label for="username">Comapny Email:</label> 
		<input type="email" name="companyEmail" required><br> 
		
		<input type="submit" value="Register">
	</form>

</body>
</html>

