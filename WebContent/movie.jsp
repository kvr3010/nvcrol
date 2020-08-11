<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="top.jsp" %>
<% if (dto == null){%>
<script>
alert("로그인 후 이용 가능한 서비스 입니다.");
location.href="login.kakao";
</script>
	
<% return; } %>



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
          <div id="mvtitle"> </div>
          <input type ="hidden" id="mv_num" value="">
          <input type ="hidden" id="mb_num" value="">
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
          <button type="submit" class="btn btn-danger" data-dismiss="modal" id ="okBtn">등록</button>
        </div>
        
      </div>
    </div>
  </div>
</form>


	<script>
	$(document).ready(function(){
		    $.get("movieok.kakao",
		    function(data, status){
 		    	var html = "";
		    	console.log(">>>>>>>>"+ data['']);
		    	console.log(data);
		    	$.each(data, function(key, field){
		    		html += "<a href='" + field.URL + "' target='_blank'>";
		    		html += "<b>"+field.title + "</a><br></b>";
		    		html += "<img src='" + field.img + "'><br>";
		    		html += "<input type ='hidden' id='mv"+field.num+"' value='" +field.title+"'><br>";
		    		html += "<button type='button' onclick='modinp(\""+field.num+"\")' class='btn btn-info'>리뷰 쓰기</button><br><br>";
		          });
				$("#result").html(html);
		    });
		  });
	
	function modinp(num){
		$("#myModal").modal("show");
		console.log(num);
		var je = $("#mv"+num).val();
		$("#mv_num").val(num);
		$("#mb_num").val(<%=dto.getNum()%>);
		console.log("#mv"+num);
		console.log(je);
		
		html = '<h4 class="modal-title">' + je + '</h4>'
		$("#mvtitle").html(html);
		
	
	};
	
	    $("#okBtn").click(function(){ 
		    //비동기  
		    	var u_num = $("#mb_num").val();
		    	var m_num = $("#mv_num").val();
		    	var sangse= $("#sangse").val();
		    	var hanjul= $("#hanjul").val();    
		    	
		      //var email=$("#email").val();    
		    	 $.post("reviewsubmit.kakao",
		    			    {
		    		 		  unum  : u_num,
		    		 		  mnum  : m_num,
		    			      hanjul : hanjul,
		    			      sangse : sangse
		    			    },
		    			    function(data, status){
		    			    	if (data.trim() == "ok"){
		    			    		alert("후기가 저장 되었습니다.");
		    			    		location.reload();
		    			    	}else {
		    			    		alert("저장에 실패했습니다. \n관리자에게 문의")
		    			    	}
		    			    });
              	    	       });

	</script>
	
</body>
</html>