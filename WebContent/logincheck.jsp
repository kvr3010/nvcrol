
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kakao.dto.UserDTO"%>

<%
	UserDTO dto = (UserDTO)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	<% if (dto == null){%>
		alert("이메일과 비밀번호를 확인하세요")
		location.href="login.kakao";
	<%}else{%>
		alert("안녕 <%=dto.getName()%>")
		location.href="main.kakao";
	<%}%>
</script>

</body>
</html>