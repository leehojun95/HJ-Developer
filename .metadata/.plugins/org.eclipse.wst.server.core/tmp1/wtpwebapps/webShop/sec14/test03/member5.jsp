<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    // 스프링에서 다음과 같으 정보가 구성.
    List dataList = new ArrayList();
    dataList.add("hello");
    dataList.add("world");
    dataList.add("안녕하세요");
    %>
    <c:set var="list" value=" <%= dataList%> "/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>반목분 실습</h3>
	<c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
		i = ${i } &nbsp;&nbsp;&nbsp; 반복횟수: ${loop.count }<br>
	</c:forEach>
	<br>
	<c:forEach var="i" begin="1" end="10" step="2">
	5*${i } = ${5 * i }<br>
	</c:forEach>
	<br>
	<c:forEach items="${list }" var="data">
	${data }<br>
	</c:forEach>
	
	<c:set var="fruits" value="사과, 파인애들, 바나나, 망고, 귤"/>
	<c:forTokens items="${fruits }" delims="" var="token">
	${token }<br>
	</c:forTokens>
</body>
</html>