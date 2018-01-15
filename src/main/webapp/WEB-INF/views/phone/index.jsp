<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<form method="post" action="phone">
			<tr>
				<td>Name : </td>
				<td>
					<input type="text" name="name" />
				</td>
			</tr>
			<tr>
				<td>Price : </td>
				<td>
					<input type="text" name="price" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="추가" />
				</td>
			</tr>
		</form>
	</table>
	
	<br/><br/>
	
	<table border="1">
		<thead>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>수정</th>
			<th>삭제</th>
		</thead>
		<tbody>
			<c:forEach var="phone" items="${phoneList}" varStatus="status">
				<tr>
					<td>${phone.id}</td>
					<td>${phone.name}</td>
					<td>${phone.price}</td>
					<td>[<a href="<c:url value="/phone/edit/${phone.id}" />">수정</a>]</td>
					<td>[<a id="del" href="<c:url value="/phone/delete/${phone.id}" />">삭제</a>]</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>