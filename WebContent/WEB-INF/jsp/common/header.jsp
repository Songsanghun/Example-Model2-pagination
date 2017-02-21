<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="context" value="<%=application.getContextPath() %>" />
<c:set var="img" value="${context}/images" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" type="text/css" href="${context}/css/hanbit.css" />

</head>
<body>
<div id="wrapper" class="width_full_size">
<div id="header" class="width_full_size position_fix;" style="height:120px;">
	<div class="logo_box width_full_size text_center" style="height: 60%">
	<a href="index.html"><img src="${context}/images/common/index_logo.png" style="margin-top:20px;"></a>
	</div>
	<ul class="gnb width_full_size text_center" style="color:black; font-size: 15px; height: 38%">
		<li><a href="${context}/patient.do?action=move&page=registerForm" class="text_no_underline">회원가입</a></li>
		<li><a href="${context}/patient.do?action=move&page=loginForm" class="text_no_underline">로그인</a></li>
		<li><a href="${context}/board.do?action=move&page=articleList" class="text_no_underline">자유게시판</a></li>
		<li class="dropdown">
			<div class="dropdown_content text_left" style="color:black">
				<p><a href="" class="text_no_underline">의 사</a></p>
				<p><a href="" class="text_no_underline">간호사</a></p>
				<p><a href="" class="text_no_underline">환 자</a></p>
				<p><a href="" class="text_no_underline">진 료</a></p>
				<p><a href="" class="text_no_underline">차 트</a></p>
			</div>
		</li>
		<li class="tooltip">
			<a href="#" class="text_no_underline">병원소개</a>
			<span class="tooltiptext">구현되지 않은 기능입니다.</span>
		</li>	
	</ul>
	</div>
<div style="height: 120px;"></div>

