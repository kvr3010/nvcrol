<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="top.jsp" %>
<% if (dto == null){%>
<script>
alert("로그인 후 이용 가능한 서비스 입니다.");
location.href="login.kakao";
</script>	
<% } %>


<body>

<h3>영화랭킹</h3>
<div id="result"></div>
	<script>
	$(document).ready(function(){
			var search = $("#search").val();
			console.log(search);
		    $.get("movieok.kakao",
		    function(data, status){
 		    	var html = "";
// 		    	console.log(data['total']);
// 		    	console.log(data.items);
// 		    	$.each(data.items, function(key, field){
// 		    		html += "<a href='" + field.link + "' target='_blank'>"
// 		    		html += field.title + "</a><br>";
// 		          });
// 				$("#result").html(html);
		    });
		  });
	</script>

</body>
</html>