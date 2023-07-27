<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/gesipan.css">
<script src="./js/gesipan.js"></script>
<style>
.head_image{
    margin : 0 auto;
    width: 900px;
    height : 100px;
    margin-bottom: 3px;
}
.flex_menu_container{
    margin : 0 auto;
    width: 900px;
    display: flex;
    height : 30px;
    margin-bottom: 3px;
}
.flex_menu_container div{
    line-height: 30px;
    text-align: center;
    margin: 3px;
}
.hamburger{
    display: none;
}
.menu1{
    flex : 0 1 100px;
}
.menu2{
    flex : 0 1 100px;
}
.menu3{
    flex : 0 1 100px;
}
.menu4{
    flex :0 1 100px;
}
.menu5{
    flex : 0 1 100px;
}
.menu6{
    flex : 1 1 150px;    
}
</style>
</head>
<body>
    <div class="container">
        <div class="head_image bgcolor2">
            Head Image Area
        </div>
        <div class='flex_menu_container bgcolor1'>
            <div class="hamburger"><button>햄버그</button></div>
            <div class='menu1'>menu1</div>
            <div class='menu2'>menu2</div>
            <div class='menu3'>menu3</div>
            <div class='menu4'>menu4</div>
            <div class='menu5'>
                <c:if test="${sessionScope.mp_isAmdin == 'admin' }">관리자 메뉴</c:if>
            </div>
            <div class='menu6'><button id="btnLogin" onclick="onLogin(event);">
            		<c:if test="${sessionScope.mp_isLogin == 'login_state' }">logout</c:if>
            		<c:if test="${sessionScope.mp_isLogin == null}">login</c:if>
            	</button>${ sessionScope.mp_user_name }-${sessionScope.mp_isLogin }-${sessionScope.mp_isAmdin }</div>
        	</div>
			<div class="flex_container">
				<h2> 멤버 게시판입니다 </h2>
	        </div>
      	<c:forEach var="board" items="${boards }">
      		<div class="flex_container">
	            <div class="id">${board.orig_id }</div>
	            <div class="created_at">${board.created_at }</div>
	            <div class="modified_at">${board.modified_at }</div>
	            <div class="space"></div>
	            <div class="modify"><a href="#">수정</a></div>
	            <div class="delete"><a href="#">삭제</a></div>
	        </div>
            <div class="flex_container">
            	${board.content }
            </div>
            <div class="flex_container">
            	<a onclick="open_close_reply(event);" id="open_${board.id}" href="#">댓글열기</a>
        	</div>
            <div class="flex_seperator">
            </div>
            
        </c:forEach>
            <div class="flex_container">
	        	<div class="reply_area" id="reply_area">
	        	    <div class="flex_container">댓글 쓰기</div>
	        		<form class="new_baord_form" action="#">
			        	<textarea class="new_board" name="content"></textarea><br>
			        	<input type="submit" value="저장">
		        	</form>	
	        	</div>
        	</div>
        	<div class="flex_container">새 글 쓰기</div>
        	<div class="flex_container">
        		<form class="new_baord_form" method="post" action="/MyProject/create.board">
		        	<textarea class="new_board" name="content"></textarea><br>
		        	<input type="submit" value="저장">
	        	</form>
        	</div>

    </div>
	
</body>
</html>