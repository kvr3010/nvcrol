<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="top.jsp" %>
<% if (dto == null){%>
<script>
alert("로그인 후 이용 가능한 서비스 입니다.");
location.href="login.kakao";
</script>	
<% } %>

<style>
.container { margin-top : 30px;}

</style>


<center>
<div class="container">									
	<div class="row">								
		<table class="table table-striped"							
			style="text-align: center; border: 1px solid #dddddd">						
			<thead>						
				<tr>					
					<th style="background-color: #eeeeee; text-align: center;">글번호</th>				
					<th style="background-color: #eeeeee; text-align: center;">영화제목</th>				
					<th style="background-color: #eeeeee; text-align: center;">영화평점</th>				
					<th style="background-color: #eeeeee; text-align: center;">한줄평</th>				
					<th style="background-color: #eeeeee; text-align: center;">작성자</th>				
				</tr>					
			</thead>						
			<tbody>						
				<tr>					
					<td>1</td>				
					<td>반도</td>				
					<td>5</td>				
					<td>시간 많은 분만 보세요</td>				
					<td>박주선</td>				
				</tr>					
			</tbody>						
		</table>							
		<a href="" class="btn btn-primary pull-right">글쓰기</a>							
	</div>								
</div>									
<div id="result"></div>
</center>



	
	<script>
// 	$(document).ready(function(){
// // 			var search = $("#search").val();
// // 			console.log(search);
// 		    $.get("movieok.kakao",
// 		    function(data, status){
//  		    	var html = "";
// 		    	console.log(">>>>>>>>"+ data.title);
// 		    	console.log(data);
// 		    	$.each(data, function(key, field){
// 		    		html += "<a href='" + field.URL + "' target='_blank'>"
// 		    		html += "<b>"+field.title + "</a><br></b>";
// 		    		html += "<img src='" + field.imgurl + "'><br><br>"
// 		          });
// 				$("#result").html(html);
// 		    });
// 		  });
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