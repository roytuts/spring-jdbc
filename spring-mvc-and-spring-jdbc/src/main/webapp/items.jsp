<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Spring MVC and JDBC Example</title>
<p>${msg}</p>
<p>
	<a href="<%=request.getContextPath()%>/addPage">Add
		New Item</a>
</p>
<c:choose>
	<c:when test="${itemList.size() > 0}">
		<h3>List of Items</h3>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${itemList}">
					<tr>
						<td>${item.itemId}</td>
						<td>${item.itemName}</td>
						<td>${item.itemPrice}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
        No Item found in the DB!
        </c:otherwise>
</c:choose>