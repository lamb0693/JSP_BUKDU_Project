<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/grid2by2.css">
    <script src="js/grid2by2.js"></script>
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
        <div class="wrap_grid">
            <div class="grid11">공지사항</div> 
            <div class="grid12"> 
                <img src="./img/image1.jpg" width="400px" alt="ImageGallery">
            </div> 
            <div class="grid21">
            	<h3><a href="<%=request.getContextPath() %>/read.board">게시판 바로가기</a></h3>
                <div class='flex_container bgcolor1'>
                    <div class='id_headline'>id</div>
                    <div class='content_headline'>내용</div>
                    <div class='writer_headline'>이름</div>
                    <div class='date_headline'>날자</div>
                    <div class='view_headline'>조회</div>
                </div>
                <div class='flex_container bgcolor2'>
                    <div class='id'>32</div>
                    <div class='content'>멍청한 놈이 먼저 일..</div>
                    <div class='writer'>이동욱</div>
                    <div class='date'>2007-06-01</div>
                    <div class='view'>87</div>
                </div>
            </div> 
            <div class="grid22">
                <p>(서울·바르샤바=뉴스1) 최동현 기자 </p>= 윤석열 대통령은 16일(현지시간)
                집중호우로 희생된 피해자들과 유가족을 위로하고 일부 지역에서 사전 통제가 
                이루어지지 않은 점을 지적했다. 윤 대통령은 귀국 즉시 중대본 회의를 직접
                주재할 예정이다.
            </div> <!-- 2열 3번째-->
        </div>
        <div class="footer_area bgcolor2">
            Footer Area
        </div>
        <div class="modal_dlg_bg" id="modal_dlg_bg">
            <div class="modal_dlg_form" id="modal_dlg_form">
            	<div class="modalTitle">로그인 id와 비밀번호 입력하세요</div>
            	<form action="/MyProject/loginController" method="post">
            		<div class="inputDiv"> id : <input type="text" name="id"></div>
            		<div class="inputDiv"> password : <input type="password" name="password"></div>
            		<div class="inputDiv"> <input type="submit" value="로그인"></div>
            	</form>
            </div>
        </div>
        <div class="modal_logout_dlg_bg" id="modal_logout_dlg_bg">
            <div class="modal_logout_dlg_form" id="modal_logout_dlg_form">
            	<div class="modalTitle"> 로그 아웃 할까요?</div>
            	<form action="/MyProject/logoutController" method="post">
            		<div class="inputDiv"> <input type="submit" value="로그아웃"></div>
            	</form>
            </div>
        </div>
    </div>
</body>
</html>
