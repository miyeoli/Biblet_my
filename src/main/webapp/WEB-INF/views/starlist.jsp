<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 리스트</title>
</head>
<body>

	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script> 
 	<script>
 	
 	//도서 검색
 	//즉시실행함수 사용
 	$(document).ready(function () {
        var pageNum = 1;
      	//var tag = $("#tag").val();
        //var $("#tag").val();
        $("#search").click(function () {	//검색 버튼 클릭시 ajax실행
        	
        	$("div").html("");	//재검색
        	$.ajax({	//카카오 검색요청 / [요청]
                method: "GET",
                url: "https://dapi.kakao.com/v3/search/book?target=isbn",
                data: { query: $("#query").val(), page: pageNum},
                headers: {Authorization: "KakaoAK 6f9ab74953bbcacc4423564a74af264e"} 
            })
            
            .done(function (msg) {	//검색 결과 담기 / [응답]
            	console.log(msg);
                for (var i = 0; i < 10; i++){
                	$("div").append("<img src='" + msg.documents[i].thumbnail + "'/><br>");
                }
            });
        })
    

</body>
</html>