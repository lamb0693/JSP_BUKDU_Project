<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <div class="header_link_home">
            <a href="/MyProject/home">홈으로</a>
        </div>
        <div class="header_image bgcolor2">
            <img src="/MyProject/img/header_img.png">
        </div>
        <div class='header_menu_container bgcolor1'>
            <div class="header_hamburger"><button><i class="xi-bars"></i></button></div>
            <div class='header_menu1'><a class="header_link_style" href="#">공지사항</a></div>
            <div class='header_menu2'><a onclick="onMoveGallery(event)"class="header_link_style" href="">사진갤러리</a></div>
            <div class='header_menu3'><a onclick="onMoveMemberBoard(event)" class="header_link_style" href="">멤버게시판</a></div>
            <div class='header_menu4'><a class="header_link_style" href="#">메뉴4</a></div>
            <div class='header_menu5'>
                <c:if test="${sessionScope.mp_isAmdin == 'admin' }">
                	<a class="header_link_style" href="#">관리자메뉴</a>
                </c:if>
            </div>
            <div class='header_menu6'>
            	<span> <!-- 로그인 이나 로그아웃 상태에 따라 button의 text 변경 -->
            	    <button id="btnLogin" onclick="onLogin(event);"> 
	            		<c:if test="${sessionScope.mp_isLogin == 'login_state' }">
	            			logout
	            		</c:if>
	            		<c:if test="${sessionScope.mp_isLogin == null}">
	            			login
	            		</c:if>
            		</button>
            	</span>
            	<span class="header_link_style"> <!-- 로그인 상태이면 id 및 정보수정 링크 아니면 회원가입 링크 -->
            		<c:if test="${sessionScope.mp_isLogin == 'login_state' }">
            			${ sessionScope.mp_user_name}님
            			<a href="#" onclick='openModifyInfoPopup(event, "${mp_user_id}", "${mp_user_name}", "${mp_user_tel}")' class="header_link_style">정보수정</a>
            		</c:if>
	            	<c:if test="${sessionScope.mp_isLogin == null}">
	            		<a href="#" onclick="openSignonPopup(event);" class="header_link_style">회원가입</a>
	            	</c:if>
            	</span>
            	<span class="header_link_style">
            		<c:if test="${sessionScope.mp_isAmdin == 'admin' }">관리자</c:if>
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
		            <form action="/MyProject/loginController" method="post" class="header_myFormGeneral" method="post">
		            	<div class="header_myControlDiv">
		                    <label class="header_mylabelSpan" for="id">아이디 </label>
		                    <span class="header_myInputSpan">
		                        <input type="text" class="myInput" name="id" id="id">
		                    </span>
		                </div>
		                <div class="header_myControlDiv">
		                    <label class="header_mylabelSpan" for="password">비밀번호 </label>
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
		            <form action="/MyProject/logoutController" method="post"" class="header_myFormGeneral" method="post">
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
        
        <!-- ****모달 회원가입 창 *********-->
        <div class="header_modal_signon_bg" id="header_modal_signon_bg">
             <div class="header_myFormContainer" id="header_modal_signon_form">
		        <div class="header_myFormHeader">
		            <div class="header_myFormHeaderTitle">회 원 가 입</div>
		            <div class="header_myFormHeaderClose" onclick="closeSingonPopup(event);">X</div>
		        </div>
		        <div class="header_myFormMain">
		            <form action="/MyProject/create.member" method="post"" class="header_myFormGeneral">
		            	<div class="header_myControlDiv">
		                    <label class="header_mylabelSpan" for="id_signon">아이디</label>
		                    <span class="header_myInputSpan">
		                        <input type="text" class="myInput" name="id" id="id_signon">
		                    </span>
		                </div>
		                <div class="header_myControlDiv">
		                    <label class="header_mylabelSpan" for="password_signon">비밀번호 </label>
		                    <span class="header_myInputSpan">
		                        <input type="password" class="myInput" name="password" id="password_signon">
		                    </span>
		                </div>
		                <div class="header_myControlDiv">
		                    <label class="header_mylabelSpan" for="name_signon">이름</label>
		                    <span class="header_myInputSpan">
		                        <input type="text" class="myInput" name="name" id="name_signon">
		                    </span>
		                </div>
		                <div class="header_myControlDiv">
		                    <label class="header_mylabelSpan" for="tel_signon">전화번호 </label>
		                    <span class="header_myInputSpan">
		                        <input type="text" class="myInput" name="tel" id="tel_signon">
		                    </span>
		                </div>
		                <div class="header_myControlDiv">
		                    <span class="header_myButtonSpan">
		                        <input class="header_myBtnSubmit" type="submit" value="회원 가입">
		                    </span>
		                </div>
		            </form>
		        </div>
		        <div class="header_myFormFooter">
		           login
		        </div>
    		</div>          
        </div>
        
        <!-- ****모달 회원정보 수정 창 *********-->
        <div class="header_modal_modify_info_bg" id="header_modal_modify_info_bg">
             <div class="header_myFormContainer" id="header_modal_modify_info_form">
		        <div class="header_myFormHeader">
		            <div class="header_myFormHeaderTitle">회 원 가 입</div>
		            <div class="header_myFormHeaderClose" onclick="closeModifyInfoPopup(event);">X</div>
		        </div>
		        <div class="header_myFormMain">
		            <form action="/MyProject/update.member" method="post" class="header_myFormGeneral">
		            	<div class="header_myControlDiv">
		                    <label class="header_mylabelSpan" for="id_signon">아이디</label>
		                    <span class="header_myInputSpan">
		                        <input type="text" class="myInput" name="id" id="id_modify">
		                    </span>
		                </div>
		                <div class="header_myControlDiv">
		                    <label class="header_mylabelSpan" for="password_signon">비밀번호 </label>
		                    <span class="header_myInputSpan">
		                        <input type="password" class="myInput" name="password" id="password_modify">
		                    </span>
		                </div>
		                <div class="header_myControlDiv">
		                    <label class="header_mylabelSpan" for="name_signon">이름</label>
		                    <span class="header_myInputSpan">
		                        <input type="text" class="myInput" name="name" id="name_modify">
		                    </span>
		                </div>
		                <div class="header_myControlDiv">
		                    <label class="header_mylabelSpan" for="tel_signon">전화번호 </label>
		                    <span class="header_myInputSpan">
		                        <input type="text" class="myInput" name="tel" id="tel_modify">
		                    </span>
		                </div>
		                <div class="header_myControlDiv">
		                    <span class="header_myButtonSpan">
		                        <input class="header_myBtnSubmit" type="submit" value="정보 수정">
		                    </span>
		                </div>
		            </form>
		        </div>
		        <div class="header_myFormFooter">
		           정보수정
		        </div>
    		</div>          
        </div>
        
        