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
	<h1>New Ninja</h1>
	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
		<div>
			<form:errors path="dojo"/>
			<form:errors path="firstName"/>
			<form:errors path="lastName"/>
			<form:errors path="age"/>
		</div>
		<div>
			<form:label path="dojo">Dojo: </form:label>
	        <form:select path="dojo">
	        <c:forEach var="dojo" items="${dojos}">
	        	<option value="${dojo.id}"><c:out value="${dojo.name}" /></option>
	        </c:forEach>
	        </form:select>
		</div>
		<div>
			<form:label path="firstName">First Name: </form:label>
			<form:input path="firstName"/>
		</div>
		<div>
			<form:label path="lastName">Last Name: </form:label>
			<form:input path="lastName"/>
		</div>
		<div>
			<form:label path="age">Age: </form:label>
			<form:input path="age"/>
		</div>
		<input type="submit" value="Create" />
	</form:form>
</body>
</html>