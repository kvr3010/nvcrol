<%@page import="com.kakao.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
	UserDTO dto = (UserDTO)session.getAttribute("member");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>내사이트</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">뉴스검색</a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="main.kakao">홈</a>
    </li>
    <%if(dto==null) {%>
    <li class="nav-item">
      <a class="nav-link" href="login.kakao">로그인</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="join.kakao">회원가입</a>
    </li>
    <%}else{ %>
    <li class="nav-item">
      <a class="nav-link" href="logout.kakao">로그아웃</a>
    </li>
    <%} %>
    <li class="nav-item">
      <a class="nav-link" href="search.kakao">뉴스 검색</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="food.kakao">맛집 검색</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="movie.kakao">영화 순위</a>
    </li>
  </ul>
</nav>


</html>
