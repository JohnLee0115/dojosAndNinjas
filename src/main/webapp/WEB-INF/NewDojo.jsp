<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>New Dojo</h1>
	<form:form action="/dojos/new/create" method="post" modelAttribute="dojo">
		<div>
			<form:errors path="name" />
		</div>
		<div>
			<form:label path="name">Name: </form:label>
			<form:input path="name" />
		</div>
		<input type="submit" value="Create" />
	</form:form>
	
</body>
</html>