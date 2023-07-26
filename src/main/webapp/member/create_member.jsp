<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/MyProject/create.member" method="post">
		id : <input type="text" name="id"><br>
		name : <input type="text" name="name"><br>
		password : <input type="password" name="password"><br>
		tel : <input type="text" name="tel"><br>
		<input type="submit" value="가입">
	</form>
</body>
</html>