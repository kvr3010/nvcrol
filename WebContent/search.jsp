<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="top.jsp" %>
<% if (dto == null){%>
<script>
alert("로그인 후 이용 가능한 서비스 입니다.");
location.href="login.kakao";
</script>	
	
<% } %>


<body>
<div class="container">
<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">날씨 검색</h4>
	<p class="text-center">검색창에 입력하세요</p>
    <div class="form-group input-group">
        <input name="search" id="search" class="form-control" placeholder="날씨 검색" type="text" value ="">
    </div> <!-- form-group// -->                                  
    <div class="form-group">
        <button type="submit" id="searchBtn"class="btn btn-primary btn-block"> 검색  </button>
    </div> <!-- form-group// -->                                                                 
</article>
</div> <!-- card.// -->
<h3>검색결과출력</h3>
<div id="result"></div>
</div> 
	<script>
	$(document).ready(function(){
		  $("#searchBtn").click(function(){
			var search = $("#search").val();
			console.log(search);
		    $.post("searchok.kakao",
		    {
		    	search: search
		    },
		    function(data, status){
		    	var html = "";
		    	console.log(data['total']);
		    	console.log(data.items);
		    	$.each(data.items, function(key, field){
		    		html += "<a href='" + field.link + "' target='_blank'>"
		    		html += field.title + "</a><br>";
//		             $("div").append(field + " ");
//		     		console.log("Data: " + field.title);  // field['title']
		          });
				$("#result").html(html);
		    });
		  });
		});
	</script>

</body>
</html>