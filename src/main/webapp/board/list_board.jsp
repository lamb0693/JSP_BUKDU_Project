<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/MyProject/css/gesipan.css">
<link rel="stylesheet" href="/MyProject/css/index_head.css">
<script src="/MyProject/js/gesipan.js"></script>
<script src="/MyProject/js/index_head.js"></script>
<style>
</style>
</head>
<body>
    <div class="container">
		<jsp:include page="../index_head.jsp"></jsp:include>
		<div class="flex_container">
			<h2> 멤버 게시판입니다 </h2>
        </div>
      	<c:forEach var="board" items="${boards }">
      		<div class="flex_container">
	            <div class="id">${board.user_id }</div>
	            <div class="created_at">${board.created_at }</div>
	            <div class="modified_at">${board.modified_at }</div>
	            <div class="space"></div>
	            <div class="modify"><a id="mod_${board.id}" onclick='modifyBoard(event, "${board.content}", ${board.id})' href="#">수정</a></div>
	            <div class="delete"><a id="del_${board.id}" onclick="deleteBoard(event)" href="#">삭제</a></div>
	        </div>
            <div class="flex_container">
            	${board.content }
            </div>
            <div class="flex_container">
            	<a onclick="open_close_reply(event);" id="open_${board.id}" href="#">댓글열기</a>
        	</div>
            <div class="flex_seperator">
            </div>
            <c:if test="${board.open_reply == true }">
            	${board.open_reply }
            	<!--  댓글창 popup -->
            	<div class="flex_container">
	        		<div class="reply_area" id="reply_area">
		        	    <div class="flex_container">댓글 쓰기</div>
		        		<form class="new_baord_form" action="#">
				        	<textarea class="new_board" name="content"></textarea><br>
				        	<input type="submit" value="저장">
			        	</form>
			        </div>
        		</div>
            </c:if>

            
        </c:forEach>

        	<div class="flex_container">새 글 쓰기</div>
        	<div class="flex_container">
        		<form class="new_baord_form" method="post" action="/MyProject/create.board">
		        	<textarea class="new_board" name="content"></textarea><br>
		        	<input type="submit" value="저장">
	        	</form>
        	</div>
        
		<!-- 수정용 modal popup -->
		<div class= "modal_modify_board_bg" id = "modal_modify_board_bg">
			<div class = "modal_modify_board" id="modal_modify_board">
			<div class="myFormContainer">
        <div class="myFormHeader">
            <div class="myFormHeaderTitle">Form 한글</div>
            <div class="myFormHeaderClose" onclick="closeModifyPopup(event);">X</div>
        </div>
	        <div class="myFormMain">
	            <form action="#" class="myFormGeneral" method="post">
	            	<div class="myControlDiv">
	                    <label class="mylabelSpan" for="modify_id">내 용 </label>
	                    <span class="myInputSpan">
	                        <input type="text" class="myInput" name="modify_id" id="modify_id">
	                    </span>
	                </div>
	                <div class="myControlDiv">
	                    <label class="mylabelSpan" for="modify_content">내 용 </label>
	                    <span class="myInputSpan">
	                        <textarea class="myInput" name="modify_content" id="modify_content"></textarea>
	                    </span>
	                </div>
	                <div class="myControlDiv">
	                    <span class="myButtonSpan">
	                        <input class="myBtnSubmit" type="submit" value="저장" onclick="saveModified(event)" id="btnSubmit">
	                    </span>
	                </div>
	            </form>
	        </div>
        <div class="myFormFooter">
            Form 한글
        </div>
    </div>
			</div>
		</div>
	</div>
</body>
</html>