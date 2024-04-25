<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% session.setMaxInactiveInterval(5 * 60); %>
	<h3>로그인 페이지</h3>
	<form action="/Sec09Ex01LoginServlet" method="post">
		아이디: <input type="text" name="user_id"><br>
		비밀번호: <input type="password" name="user_pw"><br>
		<input type="hidden" name="user_address" value="서울시 노원구 이젠빌딩 404호">
		<input type="hidden" name="user_email" value="user01@abc.com">
		<input type="hidden" name="user_hp" value="010-5555-5555">
		<input type="submit" value="로그인">
		<input type="reset" value="다시입력">
	</form>

</body>
</html>