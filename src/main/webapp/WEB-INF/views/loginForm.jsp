<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
=======
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
>>>>>>> d3da63c6bfb6165d8cf7f80c192e29c21d2e6b89
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.title" /></title>
</head>
<body>
	<form:form commandName="commandLogin">
		<form:errors />
		<p>
			<label> 
				<spring:message code="mem_id" /> 
				<form:input path="mem_id" /> 
				<form:errors path="mem_id" />
			</label>
		</p>
		<p>
			<label> 
				<spring:message code="mem_pass" /> 
				<form:input type="password" path="mem_pass" /> 
				<form:errors path="mem_pass" />
			</label>
		</p>
		<p>
			<label> 
				<spring:message code="rememberId" /> 
				<form:checkbox path="rememberId" />
			</label>
		</p>

		<input type="submit" value="<spring:message code="login.btn"/>">
	</form:form>

</body>
</html>