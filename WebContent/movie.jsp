<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="top.jsp" %>
<% if (dto == null){%>
<script>
alert("로그인 후 이용 가능한 서비스 입니다.");
location.href="login.kakao";
</script>	
<% } %>

<style>
h3 { margin-top : 30px;}

</style>


<center>
<h3>영화랭킹</h3>
<div id="result"></div>
</center>	
	<script>
	$(document).ready(function(){
// 			var search = $("#search").val();
// 			console.log(search);
		    $.get("movieok.kakao",
		    function(data, status){
 		    	var html = "";
		    	console.log(">>>>>>>>"+ data.title);
		    	console.log(data);
		    	$.each(data, function(key, field){
		    		html += "<a href='" + field.URL + "' target='_blank'>"
		    		html += "<b>"+field.title + "</a><br></b>";
		    		html += "<img src='" + field.imgurl + "'><br><br>"
		          });
				$("#result").html(html);
		    });
		  });
	</script>

<script>
// 	$(document).ready(function(){
// 		  $("#searchBtn").click(function(){
// 			var search = $("#search").val();
// 		    $.get("movieok.kakao",
// 		    function(data, status){
// 		    	var html = "";
// 		    	console.log(data['imgurl']);
// 		    	console.log(data.items); //이미지링크
// 		    	$.each(data, function(key, field){
// 		    		html += field.title + "</a><br>";
// 		    		html += "<a href='" + field.link + "' target='_blank'>"
// //		             $("div").append(field + " ");
// //		     		console.log("Data: " + field.title);  // field['title']
// 		          });
// 				$("#result").html(html);
// 		    });
// 		  });
// 		});
	</script>


</body>
</html>