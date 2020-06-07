<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Add new item</title>
<p><a href="<%=request.getContextPath()%>/">Back to
        Item List</a>
</p>
<c:if test="${not empty error}">
    ${error}
</c:if>
<c:if test="${not empty success}">
    ${success}
</c:if>
<h3>Add new item</h3>
<form method="POST" name="login" action="<%=request.getContextPath()%>/add">
    Item Name: <input name="name" value="${name}" type="text" /> <br /><br /> 
    Item Price: <input name="price" value="${price}" type="text" /><br /> 
    <input value="Add Item" type="submit" />
</form>