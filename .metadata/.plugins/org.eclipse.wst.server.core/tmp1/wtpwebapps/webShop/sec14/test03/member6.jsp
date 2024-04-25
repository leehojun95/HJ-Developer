<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <!-- 컨텍스트 경로가 / 또는 /webshop 인 경우 이경로를 읽어올 때 사용하는 명령어 -->
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
    
    <c:url var="url" value="/sec14/test01/member1.jsp">
    	<c:param name="id" value="hong"></c:param>
    	<c:param name="pwd" value="1234""></c:param>
    	<c:param name="name" value="홍길동"></c:param>
    	<c:param name="email" value="hong@abc.com"></c:param>
    </c:url>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
						<!-- 아래 구문과 같이 나온다 -->
<a href="${contextPath }/sec14/test01/member1.jsp?id=hong&pwd=1234&name=홍길동&email=hong@abc.com">회원정보출력</a>
<a href="${url1 }">회원정보출력</a>
</body>
</html>