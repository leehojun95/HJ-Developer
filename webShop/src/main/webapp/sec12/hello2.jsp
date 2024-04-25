<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
 // 선언문.  클래스 레벨에 삽입
 String name = "이순신";

 public String getName() { return name; }


%>


<%
	// 스크립트 릿(Script let)
	String age = request.getParameter("age");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 릿</title>
</head>
<body>
	<h1>jsp파일에 자바코드 삽입하는 방법2 - 스크립트 릿</h1>
	<h1>안녕하세요 <%=name %>님!!</h1>
	<h1>나이는 <%=age %>살입니다.!!</h1>
</body>
</html>

