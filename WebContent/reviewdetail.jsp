<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="top.jsp" %>
<% if (dto == null){%>
<script>
alert("로그인 후 이용 가능한 서비스 입니다.");
location.href="login.kakao";
</script>	
<% } %>

<style>

</style>


<center>
<div class="container">									
	<div class="row">								
		<table class="table table-striped"							
			style="text-align: center; border: 1px solid #dddddd">						
			<thead>						
				<tr>					
					<th style="background-color: #eeeeee; text-align: center;">글번dfdfsdfasdfasdfasdfasdf호</th>				
					<th style="background-color: #eeeeee; text-align: center;">영화제목</th>				
					<th style="background-color: #eeeeee; text-align: center;">영화평점</th>				
					<th style="background-color: #eeeeee; text-align: center;">한줄평</th>				
					<th style="background-color: #eeeeee; text-align: center;">작성자</th>				
				</tr>					
			</thead>

			<tbody id="gl">								
				
			</tbody>
		</table>							
		<a href="" class="btn btn-primary pull-right">글쓰기</a>							
	</div>								
</div>									
<div id="result"></div>
</center>

<div id=result></div>



	
	<script>
	$(document).ready(function(){
	    $.get("reviewout.kakao",
	    function(data, status){
		    	var html = "";
	    	console.log(data);
 	    	$.each(data, function(key, field){
 	    		html += "<tr style = 'cursor:pointer;' onClick ='moverev(\""+field.no+"\")'>"
 	    		html += "<input type ='hidden' id='rev"+field.no+"' value='" +field.no+"'>";
 	    		html += "<td>"+field.no+"</td>"; 	    	
 	    		html += "<td>"+field.je+"</td>";
 	    		html += "<td>"+field.pyung+"</td>";
 	    		html += "<td>"+field.title+"</td>";
 	    		html += "<td>"+field.name+"</td>";
	        	html += "</tr>" 
 	    	});
			$("#gl").html(html);
	    });
	  });
	
	function moverev(no){
		locatino.href="movereview.kakao"
		console.log(no);
		var bunho = $("#rev"+no).val();
		console.log("#mv"+num);
		console.log(je);
		
// 		html = '<h4 class="modal-title">' + je + '</h4>'
// 		$("#mvtitle").html(html);
	};
	</script>


</body>
</html>