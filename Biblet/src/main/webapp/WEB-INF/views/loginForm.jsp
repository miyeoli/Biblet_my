<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="loginSuccess" value="loginForm" method="post">
	아이디:<input type="text" id=userid name="mem_id"><br>
	비밀번호:<input type="password" id=password name="mem_pass"><br>
	<input type="checkbox" value="기억">
	<input type="submit" value="로그인">
	</form>

</body>
</html>