<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
	$(function(){
		$("#loginBtn").click(function(){
			location.href='/loginForm';
		})
	})
</script>
<title>아이디 찾기</title>
</head>
<body>

	<h3>아이디 찾기 검색결과</h3>
			
	<div>
		<h5>
			${ mem_id }
		</h5>
		<p>
			<button type="button" id=loginBtn >Login</button>
			<button type="button" onclick="history.go(-1);">Cancel</button>
		</p>
	</div>
	
</body>
</html>