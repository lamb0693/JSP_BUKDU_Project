<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getContextPath() %>
	<hr>
	<a href = "<%=request.getContextPath() %>/read.member">list member</a>
	<a href = "<%=request.getContextPath() %>/create.member">create member</a>
	<a href = "<%=request.getContextPath() %>/update.member">update member</a>
	<a href = "<%=request.getContextPath() %>/delete.member">delete member</a>
	<hr>
	<a href = "<%=request.getContextPath() %>/read.board">list board</a>
	<a href = "<%=request.getContextPath() %>/create.board">create board</a>
	<a href = "<%=request.getContextPath() %>/update.board">update board</a>
	<a href = "<%=request.getContextPath() %>/delete.board">delete board</a>
	<a href =  "/MyProject/delete.board?board_id=1">test</a>
</body>
</html>