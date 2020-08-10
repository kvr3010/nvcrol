<%@page import="com.kakao.dto.MovieDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="top.jsp" %>

<%

ArrayList<MovieDTO> dlist = (ArrayList<MovieDTO>) request.getAttribute("movielist");
if (dto == null){
	response.sendRedirect("login.kakao");
}

%>

<h3>영화랭킹</h3>
<% for (MovieDTO mv : dlist){ %>
<img alt="" src="<%=mv.getImg()%>" >
<button type="button" onclick = "send('<%=mv.getTitle()%>')">리뷰 작성</button><br><br>
<% } %>


<script>
function send(title){
	alert(title);
	alert("<%=dto.getName()%>");
}

</script>


</body>
</html>