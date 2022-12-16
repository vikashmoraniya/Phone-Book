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
	<div class="container">

		<h1>Contact List</h1>
		<hr />

		<p>${NOTIFICATION}</p>

		<p>
			<button class="btn btn-primary"
				onclick="window.location.href = 'views/contact-form.jsp'">Add Contact</button> 
			<%-- <button>
				<button <a href="${pageContext.request.contextPath}/views/contact-form.jsp">Add></button>
					Contact</a> --%>
			</button>
		</p>

		<table class="table table-striped table-bordered">

			<tr class="thead-dark">
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${list}" var="contact">

				<tr>
					<td>${contact.name}</td>
					<td>${contact.email}</td>
					<td>${contact.phone}</td>
					<td><a href="${pageContext.request.contextPath}/ContactController?action=EDIT&id=${contact.id}">Edit</a>
					    <a href="${pageContext.request.contextPath}/ContactController?action=DELETE&id=${contact.id}"
						    onclick="return confirm('Are you sure you want to delete this item?');">Delete</a>
					</td>
				</tr>

			</c:forEach>

		</table>

	</div>
</body>
</html>