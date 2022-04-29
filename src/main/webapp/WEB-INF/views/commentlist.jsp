<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코멘트 목록</title>
</head>
<body>
	<h2>최근 코멘트</h2>
	<table boder="1">
		<c:if test="${!empty commentlist}">
			<c:forEach var="commentlist" items="${commentlist}">
			<tr>
				<td>${commentlist.star}</td> 
				<td>${commentlist.book_comment}</td>	
				<td>${commentlist.mem_id }</br></td>
			</tr>	
			</c:forEach>
		</c:if>
		
		<tbody id="dynamicTbody">

				</tbody>
				
				<c:if test="${! empty searchApprList }">
					<tbody id="dynamicTbody">

					</tbody>
				</c:if>
		
 	</table>
 	
 	<script>
 	function bookinfo(isbn, star, comment, mem_id) {
			var pageNum = 1;
			$.ajax({ //카카오 검색요청 / [요청]
				method : "GET",
				url : "https://dapi.kakao.com/v3/search/book=isbn",
				data : {
					query : isbn,
					page : pageNum
				},
				headers : {
					Authorization : "KakaoAK 6f9ab74953bbcacc4423564a74af264e"
				}
			})
			.done(function(msg) { //검색 결과 담기 / [응답]
				console.log(msg);
				var html='';
				html +='<td>'+msg.documents[0].thumbnail+'</td>';
				html +='<tr>';
				html +='<td>'+star+'</td>';
				html +='<td>'+comment+'</td>';
				html +='<td>'+mem_id+'</td>';
// 				html +='<td><a href="<c:url value="/adminPage/deleteComment/'+appr_num+'"/>"><button>강제 삭제</button></a></td>';
				html +='<tr>';
				$("#dynamicTbody").append(html);
			});
		};
		
		</script>
	
	
	
	
	
	
	
	
<!-- 	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>  -->
<!-- 	<table boder="1"> -->
<%-- 		<c:forEach var="comm" items="${comm}"> --%>
<!-- 			<tr> -->
<%-- 				<a href="<c:url value='/detailcomment/${comm.appraisal.isbn}'/>"> --%>
<%-- 				<td>${comm.appraisal.isbn}</td>  --%>
<%-- 				<td>${comm.appraisal.star}</td>	 --%>
<%-- 				<td>${comm.appraisal.book_comment }</td>	 --%>
<%-- 				<td>${comm.mem_id }</td> --%>
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</table> -->

</body>
</html>