<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>표현언어(EL)로 여러가지 데이터 출력하기.</h1>
	<h1>
		\${10 + 10 };	${10 + 10 }<br>
		\${20 - 10 };	${20 - 10 }<br>
		\${10 * 10 };	${10 * 10 }<br>
		\${10 / 9 };	${10 / 9 }<br>
		<%-- \${10 div 9 };	${10 div 9 }<br>--%><!-- 툴에서는 에러표시가 되지만, 사용에는 문제가 없다. -->
		\${10 % 9 };	${10 % 9 }<br>
		\${10 mod 9 };	${10 mod 9 }<br>
	</h1>
</body>
</html>