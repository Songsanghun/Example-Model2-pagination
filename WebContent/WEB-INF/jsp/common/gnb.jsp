<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="height: 70px;"></div> 
<ul id="ulGnb">
		<li><a id="aJoin" class="text_no_underline">회원가입</a></li>
		<li><a id="aPatLogin" class="text_no_underline">고객:로그인</a></li>
		<li><a id="aStaffLogion" class="text_no_underline">스탭:로그인</a></li>
		<li><a id="aAdminLogin" class="text_no_underline">관리자:로그인</a></li>
		<li><a id="aBoard" >자유게시판</a></li>
		<li class="tooltip">
			<a href="#" class="text_no_underline">병원소개</a>
			<span class="tooltiptext">구현되지 않은 기능입니다.</span>
		</li>	
</ul>
<script>
function goPage(){
	$('#ulGnb').addClass('gnb').addClass('width_full_size').addClass('text_center');
	$('#aJoin').click(function(){
		alert('제이쿼리 실행!!!!!!!!!!!!!!!!!!!!!!');
		location.href="${context}/patient.do?action=move&page=registerForm";	
	});
	document.getElementById('aPatLogin').onclick=function(){
		location.href="${context}/patient.do?action=move&page=loginForm";
	}
	document.getElementById('aStaffLogionJoin').onclick=function(){
		location.href="${context}/patient.do?action=move&page=loginForm";
	}
	document.getElementById('aAdminLogin').onclick=function(){
		location.href="${context}/patient.do?action=move&page=loginForm";
	}
	document.getElementById('aBoard').addEventHandler('click',function(){
		location.href="${context}/board.do?action=move&page=main.do"
	});
}
window.onload=goPage();


/* function goPatLogin(){
	location.href="${context}/patient.do?action=move&page=loginForm";
}
function goStaffLogion(){
	location.href="${context}/patient.do?action=move&page=loginForm";
}
function goAdmin(){
	location.href="${context}/patient.do?action=move&page=loginForm";
}
function goBorad(){
	location.href="${context}/board.do?action=move&page=main.do";
} */
</script>