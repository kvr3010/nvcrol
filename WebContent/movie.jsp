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

<form class="container">
  <div class="modal fade" id="myModal">
    <div class="modal-dialog modal-dialog-scrollable">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">영화 리뷰</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
				<div class="modal-header">
				<input type="text" class="form-control" id="hanjul" placeholder="한줄평" name="hanjul" required>
			
				<div class="dropdown dropleft float-left">
				<button type="button"class="btn btn-outline-secondary dropdown-toggle" data-toggle="dropdown">평점</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" id="pyung1">★☆☆☆☆</a> 
						<a class="dropdown-item" id="pyung2">★★☆☆☆</a> 
						<a class="dropdown-item" id="pyung3">★★★☆☆</a>
						<a class="dropdown-item" id="pyung4">★★★★☆</a>
						<a class="dropdown-item" id="pyung5">★★★★★</a>
					</div>
					</div>

       			</div>
       			
        <div class="modal-body" >
        <textarea class="form-control" rows="10" id="sangse" placeholder="상세후기" name="sangse" ></textarea>
        </div>
        
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger" data-dismiss="modal" id ="submit">등록</button>
        </div>
        
      </div>
    </div>
  </div>
</form>


	<script>
	$(document).ready(function(){
// 			var search = $("#search").val();
// 			console.log(search);
		    $.get("movieok.kakao",
		    function(data, status){
 		    	var html = "";
		    	console.log(">>>>>>>>"+ data['']);
		    	console.log(data);
		    	$.each(data, function(key, field){
		    		html += "<a href='" + field.URL + "' target='_blank'>"
		    		html += "<b>"+field.title + "</a><br></b>";
		    		html += "<img src='" + field.img + "'><br>";
		    		html += "<input type = 'hidden' value='" + field.img + "'><br>";
		    		html += "<button type='button' class='btn btn-info' data-toggle='modal' data-target='#myModal' >리뷰 쓰기</button><br><br>"
		    		console.log(":::::::::"+key);
		    		console.log(":::::::::"+field);
		          });
				$("#result").html(html);
		    });
		  });

	
	
		    $("#submit").click(function(){ 
		    //비동기  
		    	var hanjul=$("#hanjul").val();    
		    	var sangse=$("#sangse").val();    
		      //var email=$("#email").val();    
		    	 $.post("reviewsubmit.kakao",
		    			    {
		    			      hanjul:hanjul,
		    			      sangse:sangse
		    			    },
		    			    function(data,status){
		    			    	if(data.trim()=="ok"){
		    			      //	alert("중복된 메일입니다.");
		    			    }else{
		    			    	//alert("가입이 가능한 메일입니다.")
		    			    	}
		    			    }
		    			    	);
		    	 
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