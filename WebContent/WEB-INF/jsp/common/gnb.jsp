<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="height: 70px;"></div> 
<ul id="commonGnb"> 
		<li><a>회원가입</a></li>
		<li><a>고객:로그인</a></li>
		<li><a>스탭:로그인</a></li>
		<li><a>관리자:로그인</a></li>
		<li><a>자유게시판</a></li>
		<li class="tooltip">
			<a href="#" class="text_no_underline">병원소개</a>
			<span class="tooltiptext">구현되지 않은 기능입니다.</span>
		</li>	
</ul>

<script>
$(function() {                 
	var commonGnb=$('#commonGnb');
	
	commonGnb.addClass('gnb').addClass('width_full_size').addClass('text_center').css('font-size','15px').css('height','7%');
	
	commonGnb.find('li:nth-child(1)').click(function(){
		alert('JQuery Test!');
		goPage('${context}/patient.do','move', 'registerForm');
	});
	
	commonGnb.find('li:nth-child(2)').click(function(){
		alert('aPatLogin.onclick');
		goPage('${context}/patient.do', 'move', 'loginForm');
	});
	commonGnb.find('li:nth-child(3)').click(function(){
		alert('aStaffLogin.onclick');
		goPage('${context}/staff.do', 'move', 'loginForm');
	});
	commonGnb.find('li:nth-child(4)').click(function(){
		alert('aAdminLogin.onclick');
		goPage('${context}/admin.do', 'move', 'loginForm');
	});
	
	commonGnb.find('li:nth-child(5)').click(function(){
		alert('게시판 가기');
		goList('${context}/board.do', 'list', 'articleList', '1');
	});
});
</script>