<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/MyProject/css/grid2by2.css">
    <link rel="stylesheet" href="/MyProject/css/index_head.css">
    <script src="/MyProject/js/index_head.js"></script>
</head>
<body>
    <div class="container">
 		<jsp:include page="index_head.jsp"></jsp:include>
        <div class="wrap_grid">
            <div class="grid11">공지사항</div> 
            <div class="grid12"> 
                <img src="/MyProject/img/image1.jpg" width="400px" alt="ImageGallery">
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
    </div>
</body>
</html>
