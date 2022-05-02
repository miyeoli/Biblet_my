<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인 페이지 임당</h2>
		<c:if test = "${ authInfo != null}"> 
			<div class="mypage_button"><a href="mypage">마이페이지</a></div>
			<span><a href="logout">로그아웃</a></span>
		</c:if>
		
		
		

</body>
</html>