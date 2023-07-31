<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/MyProject/css/home.css">
    <link rel="stylesheet" href="/MyProject/css/header.css">
    <link rel="stylesheet" href="/MyProject/css/footer.css">
    <script src="/MyProject/js/header.js"></script>
    <script src="/MyProject/js/home.js"></script>
    
</head>
<body>
    <div class="index_container">
 		<jsp:include page="header.jsp"></jsp:include>
        <div class="index_wrap_grid">
            <div class="index_grid11">
            	<h5><a class="index_link_text" onclick="" href="#">공지 게시판 바로가기</a></h5>
                <div class='index_grid11_container bgcolor1'>
                    <div class='grid21_userid'>아이디</div>
                    <div class='grid21_content'>내용</div>
                    <div class='grid21_update'>수정</div>
                    <div class='grid21_view'>조회</div>
                </div>
                <div class='index_grid11_container bgcolor2'>
                    <div class='grid21_userid'>chance</div>
                    <div class='grid21_content'>공사중인 페이지 입니다</div>
                    <div class='grid21_update'>2023/7/31</div>
                    <div class='grid21_view'>5</div>
                </div>
            </div> 
	            <div class="index_grid12"> 
	            <h5><a class="index_link_text" onclick="" href="#">사진 갤러리 바로 가기</a></h5>
                <div class='index_grid12_container bgcolor1' id='picture_in_gallery'>
                	<div id="picture_in_gallery" class="picture_in_gallery">
                		<img src="/MyProject/img/image1.jpg" height="260px" alt="ImageGallery">
                		<img src="/MyProject/img/image2.jpg" height="260px" alt="ImageGallery">
                		<img src="/MyProject/img/image3.jpg" height="260px" alt="ImageGallery">
                	</div>
                    
                </div>
                
            </div> 
            <div class="index_grid21">
            	<!-- 
            	           	<h4><a class="index_link_text" href="<%=request.getContextPath() %>/read.board">멤버 게시판 바로가기</a></h4>
            	 -->
            	<h5><a class="index_link_text" onclick="onMoveMemberBoard(event)" href="#">멤버 게시판 바로가기</a></h5>
                <div class='index_grid21_container bgcolor1'>
                    <div class='grid21_userid'>아이디</div>
                    <div class='grid21_content'>내용</div>
                    <div class='grid21_update'>수정</div>
                    <div class='grid21_view'>댓글</div>
                </div>
                <c:forEach var="board" items="${boards }">
                    <div class='index_grid21_container bgcolor2'>
	                    <div class='grid21_userid'>${board.user_id }</div>
	                    <div class='grid21_content'>
	                    	<c:out value="${fn:substring(board.content, 0, 19) }" />
	                    </div>
	                    <div class='grid21_update'>
	                    	<fmt:formatDate value="${board.modified_at}" pattern="y/M/d" type="date"/>
	                    </div>
	                    <div class='grid21_view'>${board.replyNo }</div>
                	</div>
                </c:forEach>

            </div> 
            <div class="index_grid22">
                <p>(서울·바르샤바=뉴스1) 최동현 기자 </p>= 윤석열 대통령은 16일(현지시간)
                집중호우로 희생된 피해자들과 유가족을 위로하고 일부 지역에서 사전 통제가 
                이루어지지 않은 점을 지적했다. 윤 대통령은 귀국 즉시 중대본 회의를 직접
                주재할 예정이다.
            </div> <!-- 2열 3번째-->
        </div>
		<jsp:include page="footer.jsp"></jsp:include>
    </div>
</body>
</html>
