<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>



<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="<c:url value='/loginForm'/>"  name="loginCommand" method="post">
	아이디:<input type="text" id="mem_id" name="mem_id"><br>
	비밀번호:<input type="password" id="mem_pass" name="mem_pass">
	<br>
	<input type="submit" value="로그인">
	<!-- 회원가입 -->
	</form>
</body>
</html>