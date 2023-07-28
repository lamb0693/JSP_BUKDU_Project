<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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