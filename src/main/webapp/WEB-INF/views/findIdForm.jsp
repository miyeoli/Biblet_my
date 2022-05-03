<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 찾기</title>
</head>
<body>
	<form action="<c:url value='/findId'/>" method="post">
	<h2>아이디 찾기</h2>
		<div>
			<p>
				<label>Email</label>
				<input type="text" id="mem_email" name="mem_email">
			</p>
			<p>
				<button type="submit" id=findBtn>find</button>
				<button type="button" onclick="history.go(-1);">Cancel</button>
			</p>
		</div>
	</form>
</body>
</html>