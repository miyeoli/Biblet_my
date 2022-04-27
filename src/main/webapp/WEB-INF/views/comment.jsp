<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코멘트 목록</title>
</head>
<body>
	<h2>최근 코멘트</h2>
	<table boder="1">
		<c:forEach var="comm" items="${comment}">
			<tr>
				<!-- <a href="<c:url value='/detailcomment/${comm.appraisal.isbn}'/>"> -->
				<td>${comm.appraisal.isbn}</td> 
				<td>${comm.appraisal.star}</td>	
				<td>${comm.appraisal.book_comment }</td>	
				<td>${comm.mem_id }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>