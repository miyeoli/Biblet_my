<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코멘트 목록</title>
</head>
<body>
	<table boder="1">
		<c:forEach var="comm" items="${commentList}">
			<tr>
				<!-- <td><div id="book_name_c"></div></td>  -->
				<!-- 별점 -->
				<td>${comm.book_comment}</td>
				<td>${comm.mem_id }님의코멘트입니다.</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>