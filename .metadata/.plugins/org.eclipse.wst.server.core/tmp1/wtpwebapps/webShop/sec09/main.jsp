<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>메인 홈페이지입니다.</h3>
<%if(session.getAttribute("auth") == null)  {%>
<a href="/sec09/login.jsp">로그인</a><br>


<%} else {%>
<a href="/sec09/logout.jsp">로그아웃</a><br>
<%} %>
</body>
</html>