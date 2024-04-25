<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	// 선언문. 필드와 메서드만 작성가능
	// 선언문 코딩위치는 jsp파일에서 아무데나 작성해도 상관없다. 이유는 필드,메서드가 클래스수준으로 생성되기 때문이다.
	
	String name = "이순신";
	public String getName() { return name; }

%>

<%
	//스크립트 릿(scriptlet) : _jspService()메서드안에 코드가 삽입된다.
	String age = request.getParameter("age");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현식</title>
</head>
<body>
	<h1>jsp파일에 자바코드 삽입하는 방법3 - 표현식</h1>
	<h1>안녕하세요 <%=name %></h1>
	<h1>나이는 <%=age %>살 입니다.!</h1>
	<h1>키는 <%=180 %>cm입니다.!</h1>
	<h1>나이+10은 <%=Integer.parseInt(age)+10 %> 살입니다.!!</h1>
</body>
</html>