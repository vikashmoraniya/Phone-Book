<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">


<meta charset="ISO-8859-1">
<title>Login Page</title>

<style type="text/css">
.text-center {
	border: solid;
	border-radius: 40px;
	width: 500px;
	margin-top: 200px;
	margin-left: 450px;
	text-align: center;
}

a {
	color: white;
	text-decoration: none;
}

#btn {
	margin-left: 164px;
	margin-top: -64px;
}

#btn2 {
	
}
</style>
</head>

<body class="text-center">
	<h1>Login Page</h1>
	<p>${NOTIFICATION}</p>
	<form action="${pageContext.request.contextPath}/ContactController" method="post">
		<div class="div">
			Username<input type="name" name="userName"
				style="padding: 10px; margin: 10px" ;width="100px"
				placeholder="Enter Name"><br> Password<input
				name="userPassword" type="password"
				style="padding: 10px; margin: 10px" ;width="100px"
				placeholder="Enter Password">

		</div>
		
			<input type="hidden" class="form-control" name="action" value="LOGIN">
		
		<button type="submit" style="font-weight: bolder;" id="btn2"
			class="btn btn-success">Login</button>
	</form>
	<div>
		<p>
			
				<a href="..//ContactBook/views/Signup.jsp">Signup</a>
			</button>
		</p>
	</div>

</body>
</html>