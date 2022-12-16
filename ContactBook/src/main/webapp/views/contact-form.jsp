<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>

	<p>${NOTIFICATION}</p>
	</div>
	<form action="${pageContext.request.contextPath}/ContactController"
		method="post">

		<div class="form-group">
			<input type="text" class="form-control" name="name"
				placeholder="Enter Name" value="${contact.name}" required="required"/>
		</div>

		<div class="form-group">
			<input type="email" class="form-control" name="email"
				placeholder="Enter Email" value="${contact.email}"/>
		</div>

		<div class="form-group">
			<input type="text" class="form-control" name="phone"
				placeholder="Enter Mobile Number" value="${contact.phone}"/>
		</div>

		<input type="hidden" name="id" value="${contact.id}"/><input
			type="hidden" name="action" value="ADD" />

		<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
	</form>
	<div>
		<p>
			<a href="${pageContext.request.contextPath}/ContactController">Contact List</a>
		</p>
	</div>

</body>
</html>