<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    request.setCharacterEncoding("utf-8");
    %>
    
    <!-- 변수 선언 -->
    <c:set var="id" value="hong" scope="page"/>
    <c:set var="pwd" value="1234" scope="page"/>
    <c:set var="name" value="${'홍길동' }" scope="page"/>
    <c:set var="age" value="${22 }" scope="page"/>
    <c:set var="height" value="${177 }" scope="page"/>
    
    <!-- 변수 제거  -->
    <c:remove var="age"/>
    <c:remove var="height"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 : ${id }<br>
비밀번호 : ${pwd }<br>
이름 : ${name }<br>
나이 : ${age }<br>
키 : ${height }<br>
</body>
</html>