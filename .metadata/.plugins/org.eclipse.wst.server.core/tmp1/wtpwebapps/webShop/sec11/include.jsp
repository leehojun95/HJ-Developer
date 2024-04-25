<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인클루드 디렉티브</title>
</head>
<body>
	<h1>안녕하세요. 쇼핑몰 중심 JSP 시작입니다.!!!</h1>
	<%@ include file="duke_image.jsp" %>
	<!-- include 디렉티브는 공통내용을 가지고 있는 파일을 참조할 때 사용 -->
	<!-- duke_image.jsp 파일이 실행되어 결과코드가 삽입되는 것이 아니라, 파일 원본내용이 그대로 삽입되어
	하나의 파일로 합쳐진다. 그래서 자바파일 하나로 생성된다.-->
	<h1>안녕하세요. 쇼핑몰 중심 JSP 끝 부분입니다.!!</h1>
</body>
</html>