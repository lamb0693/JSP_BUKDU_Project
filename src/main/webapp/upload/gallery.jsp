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
			<div class="gallery_myFormContainer">
	            <div class="gallery_myFormHeader">
	                갤러리 사진 올리기
	            </div>
	            <div class="gallery_myFormMain">
	                <form action="/MyProject/create.gallery" class="gallery_myFormGeneral" enctype="multipart/form-data" method="post">
	                    <div class="gallery_myControlDiv">
	                        <span class="gallery_mylabelSpan">업로드 할 파일 선택</span>
	                        <span class="gallery_myInputSpan">
	                            <input class="myInput" type="file" name="up_file" id="up_file" accept="image/*">
	                        </span>
	                        <span class="gallery_myButtonSpan">
	                            <input class="gallery_myBtnSubmit" type="submit" name="btnSubmit" id="btnSubmit" value="이미지 올리기">
	                        </span>
	                    </div>
	                </form>
	            </div>
	            <div class="gallery_myFormFooter">
	                upload file
	            </div>
	        </div>
        </div>
	
        <div class="gallery_flex_container">
            <table class="gallery_table">
                <tbody>
	                <tr class="tr_cell">
	                	<c:set var="index" value="0" />
			                <c:forEach var="board" items="${boards }">	
			                	<c:set var="index" value="${index + 1 }"/>	
			                        <td class="gallery_cell">
			                            <div class="gallery_cell_container">
			                                <div class="gallery_cell_picture">
			                                	<img src="UploadedFiles/${board.saved_fn }" width="230px">
			                                </div>
			                                <div class="gallery_cell_legend">
			                                	${board.orig_fn }
			                                	날자:<fmt:formatDate value="${board.uploaded_at}" pattern="y/M/d" type="date"/>
			                                </div>
			                            </div>
			                        </td>
		                        <c:if test="${index %4 == 0 }"></tr><tr></c:if>	
			                </c:forEach>
	                <c:if test="${index %4 != 0 }"></tr></c:if>
                </tbody>           
 	          </table>
        </div>

        


		<jsp:include page="../footer.jsp"></jsp:include>
	</div>
</body>
</html>