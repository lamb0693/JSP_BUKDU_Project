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
<link rel="stylesheet" href="/MyProject/css/header.css">
<script src="/MyProject/js/gesipan.js"></script>
<script src="/MyProject/js/header.js"></script>
<style>
</style>
</head>
<body>
    <div class="gesipan_container">
		<jsp:include page="../header.jsp"></jsp:include>
		<div class="gesipan_flex_container">
			<h2> 멤버 게시판입니다 </h2>
        </div>

      	<c:forEach var="board" items="${boards }">
      	
      	    <div class="gesipan_flex_container">
	            <div class="gesipan_id gesipan_other" >${board.user_id }</div>
	            <div class="gesipan_modified_at gesipan_other">${board.modified_at }</div>
	            <div class="gesipan_space gesipan_other"></div>
	            <div class="gesipan_modify gesipan_other"><a class="gesipan_link_element" id="mod_${board.id}" onclick='modifyBoard(event, "${board.content}", ${board.id})' href="#">수정</a></div>
	            <div class="gesipan_delete gesipan_other"><a class="gesipan_link_element" id="del_${board.id}" onclick="deleteBoard(event)" href="#">삭제</a></div>
	        </div>
            <div class="gesipan_flex_container">
            	<div class="gesipan_content">
            	     ${board.content }
            	</div>
            </div>
            <div class="gesipan_flex_container">
            	<div class="gesipan_other">
            		<a class="gesipan_link_element" onclick="open_close_reply(event, ${board.id});" " href="#">댓글열기</a>
            	</div>
        	</div>
            <div class="reply_area" id="reply_area${board.id}">     
	            <c:forEach var="ele" items="${replies}" >
	            	<c:if test="${ele.key==board.id}">
	            		<c:forEach var="reply" items="${ele.value }">
	            			<div class="gesipan_flex_container">
	            				<div class="gesipan_id_re"><i class="xi-subdirectory-arrow"></i></div>
		            			<div class="gesipan_id gesipan_other" >${reply.user_id }</div>
		            			<div class="gesipan_modified_at gesipan_other">${reply.modified_at }</div>
		            			<div class="gesipan_space gesipan_other"></div>
		            			<div class="gesipan_modify gesipan_other"><a class="gesipan_link_element" id="mod_${reply.id}" onclick='modifyBoard(event, "${reply.content}", ${board.id})' href="#">수정</a></div>
		            			<div class="gesipan_delete gesipan_other"><a class="gesipan_link_element" id="del_${reply.id}" onclick="deleteBoard(event)" href="#">삭제</a></div>
	        				</div>
	        				<div class="gesipan_flex_container">
	        					<div class="gesipan_id_re"></div>
            					<div class="gesipan_reply_content">
            	     					${reply.content }
            					</div>
            				</div>
	            		</c:forEach>
	            		            	</c:if>      
	            </c:forEach>  
	            		
            	<!--  댓글창  -->
            	<div class="gesipan_flex_container">
	        	    <div>댓글 쓰기</div>   		
        		</div>
        		<div class="gesipan_flex_container">
        			<div>
        				<form class="new_baord_form" method="post" action="/MyProject/create.board">
		        			<input type="hidden" name="orig_id" value="${board.id}">
				        	<textarea class="new_board" name="content"></textarea>
				        	<input type="submit" onclick="saveReply(event);" value="저장">
			        	</form>
        			</div>
	        	</div>  
      
            </div>
            <div class="gesipan_flex_seperator">
            </div>
            
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