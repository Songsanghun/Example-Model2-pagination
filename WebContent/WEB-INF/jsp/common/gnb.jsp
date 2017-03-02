<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="height: 70px;"></div> 
<ul id="commonGnb">
		<li><a class="text_no_underline">회원가입</a></li>
		<li><a class="text_no_underline">고객:로그인</a></li>
		<li><a class="text_no_underline">스탭:로그인</a></li>
		<li><a class="text_no_underline">관리자:로그인</a></li>
		<li><a class="text_no_underline" >자유게시판</a></li>
		<li class="tooltip">
			<a href="#" class="text_no_underline">병원소개</a>
			<span class="tooltiptext">구현되지 않은 기능입니다.</span>
		</li>	
</ul>
<script>
$(function(){    // $(function(){});

	var commonGnb = $('#commonGnb');
	commonGnb.addClass('gnb').addClass('width_full_size').addClass('text_center');
	commonGnb.find('li:nth-child(1)').click(function(){
		alert('제이쿼리 실행!!!!!!!!!!!!!!!!!!!!!!');
			goPage('${context}/patient.do','move','registerForm');
	});
	commonGnb.find('li:nth-child(2)').click(function(){
		goPage('${context}/patient.do','move','loginForm');
	});
	commonGnb.find('li:nth-child(3)').click(function(){
		goPage('${context}/patient.do','move','loginForm');
	});
	commonGnb.find('li:nth-child(4)').click(function(){
		goPage('${context}/patient.do','move','loginForm');
	});
	commonGnb.find('li:nth-child(5)').click(function(){
		goPage('${context}/board.do','move','articleList');
	});

});

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
}
window.onload=goPage(); */

</script>