<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/MyProject/css/header.css">
<link rel="stylesheet" href="/MyProject/css/footer.css">
<link rel="stylesheet" href="/MyProject/css/gallery.css">
<script src="/MyProject/js/header.js"></script>
<style>
</style>
</head>
<body>
    <div class="gallery_container">
		<jsp:include page="../header.jsp"></jsp:include>
		<div class="gallery_flex_container">
			<h2> 사진 갤러리 입니다 </h2>
        </div>


		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>