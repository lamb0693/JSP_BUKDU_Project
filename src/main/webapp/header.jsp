<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <div class="header_link_home">
            <a href="/MyProject/home">홈으로</a>
        </div>
        <div class="header_image bgcolor2">
            <img src="./img/header_img.png">
        </div>
        <div class='header_menu_container bgcolor1'>
            <div class="header_hamburger"><button><i class="xi-bars"></i></button></div>
            <div class='header_menu1'>menu1</div>
            <div class='header_menu2'>menu2</div>
            <div class='header_menu3'>menu3</div>
            <div class='header_menu4'>menu4</div>
            <div class='header_menu5'>
                <c:if test="${sessionScope.mp_isAmdin == 'admin' }">관리자 메뉴</c:if>
            </div>
            <div class='header_menu6'>
            	<span>
            	    <button id="btnLogin" onclick="onLogin(event);">
	            		<c:if test="${sessionScope.mp_isLogin == 'login_state' }">logout</c:if>
	            		<c:if test="${sessionScope.mp_isLogin == null}">login</c:if>
            		</button>
            	</span>
            	<span>
            		<c:if test="${sessionScope.mp_isLogin == 'login_state' }">${ sessionScope.mp_user_name}님 </c:if>
	            	<c:if test="${sessionScope.mp_isLogin == null}">회원가입</c:if>
            	</span>
            	<span>
            		<c:if test="${sessionScope.mp_isAmdin == true }">관리자</c:if>
            	</span>
            </div>
        </div>
        <!-- ****모달 login 창 ***** -->
        <div class="header_modal_login_bg" id="header_modal_login_bg">
				<div class="header_myFormContainer" id="header_modal_login_form">
		        <div class="header_myFormHeader">
		            <div class="header_myFormHeaderTitle">로 그 인</div>
		            <div class="header_myFormHeaderClose" onclick="closeLoginPopup(event);">X</div>
		        </div>
		        <div class="header_myFormMain">
		            <form action="/MyProject/loginController" method="post"" class="header_myFormGeneral" method="post">
		            	<div class="header_myControlDiv">
		                    <label class="header_mylabelSpan" for="id">내 용 </label>
		                    <span class="header_myInputSpan">
		                        <input type="text" class="myInput" name="id" id="id">
		                    </span>
		                </div>
		                <div class="header_myControlDiv">
		                    <label class="header_mylabelSpan" for="password">내 용 </label>
		                    <span class="header_myInputSpan">
		                        <input type="password" class="myInput" name="password" id="password">
		                    </span>
		                </div>
		                <div class="header_myControlDiv">
		                    <span class="header_myButtonSpan">
		                        <input class="header_myBtnSubmit" type="submit" value="로그인">
		                    </span>
		                </div>
		            </form>
		        </div>
		        <div class="header_myFormFooter">
		           login
		        </div>
    		</div>
        </div>
        <!-- ****모달 logout 창 *********-->
        <div class="header_modal_logout_bg" id="header_modal_logout_bg">
             <div class="header_myFormContainer" id="header_modal_login_form">
		        <div class="header_myFormHeader">
		            <div class="header_myFormHeaderTitle">로그 아웃</div>
		            <div class="header_myFormHeaderClose" onclick="closeLogoutPopup(event);">X</div>
		        </div>
		        <div class="header_myFormMain">
		            <form action="/MyProject/loginController" method="post"" class="header_myFormGeneral" method="post">
		            	<div class="/MyProject/logoutController">
							로 그 아 웃 할 까 요 ?
		                </div>
		                <div class="header_myControlDiv">
		                    <span class="header_myButtonSpan">
		                        <input class="header_myBtnSubmit" type="submit" value="로그아웃">
		                    </span>
		                </div>
		            </form>
		        </div>
		        <div class="header_myFormFooter">
		           login
		        </div>
    		</div>          
        </div>