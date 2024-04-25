<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    
    	// 요청이 종료되면, 소멸. member1.jsp파일이 종료되면, 아래 정보는 소멸된다.
    	request.setAttribute("id", "hong");
    	request.setAttribute("pwd", "1234");
    	
    	// 세션이 종료되면, 소멸	예> 로그아웃(강제적으로 세션소멸), 사이트를 30분간 재접속하지 않으면 세션 자동 소멸.
    	session.setAttribute("name", "홍길동");
    	session.setAttribute("email", "hong@test.com");
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:forward page="member1.jsp"></jsp:forward>
</body>
</html>