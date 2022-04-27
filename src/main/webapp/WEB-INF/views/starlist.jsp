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
<title>도서 리스트</title>
</head>
<body>
	<h2>도서 리스트</h2>

	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script> 
  	
 	
 	<div></div>
 	
 	<script>	
 	
 	 	
 	window.onload=function() {
 		//var starlist = $("#starlist.isbn").val();
        //var list = JSON.parse($(json));
        
        var pageNum = 1;
        
        var array = ['${starlist[0].isbn}', '${starlist[1].isbn}', '${starlist[2].isbn}'];
        
        //var array = ['']
        for(var i =0; i<array.length; i++) {
        	(function (i){
        	$.ajax({	//카카오 검색요청 / [요청]
                method: "GET",
                traditional: true,
                url: "https://dapi.kakao.com/v3/search/book?target=isbn",
                data: {query: array[i], page: pageNum},
                headers: {Authorization: "KakaoAK 6f9ab74953bbcacc4423564a74af264e"} 
            })
            
            .done(function (msg) {   //검색 결과 담기 / [응답]	
                console.log(msg);
                    $("div").append("<img src='" + msg.documents[0].thumbnail + "'/>");
                    $("div").append("<h2>" + msg.documents[0].title + "</h2>");
                    $("div").append("<strong>일련번호:</strong> " + msg.documents[0].isbn + "<br>");   //일련번호
       
                });
        	})(i);
        }
 	}
//         	$.ajax({	//카카오 검색요청 / [요청]
//                 method: "GET",
//                 traditional: true,
//                 url: "https://dapi.kakao.com/v3/search/book?target=isbn",
//                 data: {query: array[1], page: pageNum},
//                 headers: {Authorization: "KakaoAK 6f9ab74953bbcacc4423564a74af264e"} 
//             })
            
//             .done(function (msg) {   //검색 결과 담기 / [응답]
//                 console.log(msg);
                
//                     $("div").append("<img src='" + msg.documents[0].thumbnail + "'/>");
//                     $("div").append("<h2>" + msg.documents[0].title + "</h2>");
//                     $("div").append("<strong>일련번호:</strong> " + msg.documents[0].isbn + "<br>");   //일련번호
                
             
//                 });
        	
//         	$.ajax({	//카카오 검색요청 / [요청]
//                 method: "GET",
//                 traditional: true,
//                 url: "https://dapi.kakao.com/v3/search/book?target=isbn",
//                 data: {query: array[2], page: pageNum},
//                 headers: {Authorization: "KakaoAK 6f9ab74953bbcacc4423564a74af264e"} 
//             })
            
//             .done(function (msg) {   //검색 결과 담기 / [응답]
//                 console.log(msg);
               
//                     $("div").append("<img src='" + msg.documents[0].thumbnail + "'/>");
//                     $("div").append("<h2>" + msg.documents[0].title + "</h2>");
//                     $("div").append("<strong>일련번호:</strong> " + msg.documents[0].isbn + "<br>");   //일련번호
                
             
//                 });

        
        	
        
//  		}
 	
	
 	
// 	$(document).ready(function () {
// 	//var starlist = $("#starlist.isbn").val();
// 	var pageNum = 1;
// 	var array = [${starlist[0].isbn}, ${starlist[1].isbn},${starlist[2].isbn}];
// 	 	$.ajax({	//카카오 검색요청 / [요청]
// 	         method: "GET",
// 	         url: "https://dapi.kakao.com/v3/search/book?target=isbn",
// 	         data: { query: array[1], page: pageNum},
// 	         headers: {Authorization: "KakaoAK 6f9ab74953bbcacc4423564a74af264e"} 
// 	 })     
//      .done(function (msg) {	//검색 결과 담기 / [응답]
//      	console.log(msg);
//          	$("div").append("<img src='" + msg.array[1].thumbnail + "'/><br>");
//              $("div").append("<h2>" + msg.array[1].title + "</h2>");
//              $("div").append("<strong>일련번호:</strong> " + msg.array[1].isbn + "<br>");	//일련번호
         
//      });
//  	})

   </script>
    

</body>
</html>