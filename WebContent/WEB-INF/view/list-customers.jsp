<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<link type = "text/css"
	rel = "stylesheet"
	href = "${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	
		<div id = "wrapper">
			<div id = "header">
				<h2>Customer Management</h2>
			</div>
		</div>
		
		<div id = "container">
			<div id = "content">
			
			<input type = "button" value = "Add Customer"
				onclick = "window.location.href='showFormForAdd';return false;"
				Class = "add-button"
				/>
				
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					
					<c:forEach var = "tempCustomer" items = "${customers}">
					
					<c:url var = "updateLink" value = "/customer/showFormForUpdate">
						<c:param name="customerId" value = "${tempCustomer.id}"/>
					</c:url>
					
					<c:url var = "deleteLink" value = "/customer/delete">
						<c:param name="customerId" value = "${tempCustomer.id}"/>
					</c:url>
					
						<tr>
							<td>${tempCustomer.firstname}</td>
							<td>${tempCustomer.lastname}</td>
							<td>${tempCustomer.email}</td>
							<td>
								<a href = "${updateLink}">Update</a>
								|
								<a href = "${deleteLink}" onclick = "if(!(confirm('Are you sure you want to delete this customer?')))return false"> Delete</a>
							</td>
						</tr>
						
						
					</c:forEach>
				</table>
			</div>
	</div>
</body>
</html>

	