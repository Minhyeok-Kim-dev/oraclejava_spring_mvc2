<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update</title>
</head>
<body>

	<form:form method="post" modelAttribute="phone">
		<table border="1">
		<thead>
			<th>Name</th>
			<th>Price</th>
		</thead>
		<tbody>
			<tr>
				<td>
					<form:input path="name" value="${phone.name}"/>
				<td>
					<form:input path="price" value="${phone.price}"/>
				</td>
			</tr>
		</tbody>
	</table>
	
	<input type="submit" value="update" style="height:25px" />
	<input type="button" value="cancel" style="height:25px" 
							onclick="location.href='<c:url value="/phone"/>'" />
	</form:form>
</body>
</html>