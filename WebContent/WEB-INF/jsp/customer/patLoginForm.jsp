<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="serviceImpl.MemberServiceImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="../../css/hanbit.css"/>
</head>
<body>
<div id="wrapper" class="width_full_size">
<div id="header" class="width_full_size" style="height: 100px;position: fixed;height: 68px;z-index: 2; background-color: white;">
	<div class="logo_box width_full_size">
	<img src="../../images/common/index_logo.png"/>
	</div>
	<div class="gnb width_full_size">
	<ul style="margin: 0px;">
		<li><a class="text_no_underline color_black" href="../../index.html">홈으로</a></li>
		<li><a class="text_no_underline color_black" href="../bbs/bbs_list.html">게시판</a></li>
		<li><div class="dropdown">
			<a class="text_no_underline color_black" href="../admin/admin.html">관리자</a>
				<div class="dropdown_content">
				   <p><a class="active" href="../staff/doctors.html">의사</a></p>
				   <p><a class="active" href="../staff/nurses.html">간호사</a></p>
				   <p><a class="active" href="../customer/patients.html">환자</a></p>
				   <p><a class="active" href="../chart/chart_list.html">차트</a></p>
				</div>
			</div>
		</li>
		<li>
			<div class="tooltip">
				<a class="text_no_underline color_black" href="#">병원소개</a>
					<span class="tooltiptext">구현되지 않았습니다.</span>
			</div>
		</li>
		<li style="float:right;margin-right: 45px;"><a class="text_no_underline color_black" href="join.html">회원 가입</a></li>
		<li style="float:right;"><a class="text_no_underline color_black" href="login.html">로그인</a></li>
	</ul>
	</div>
</div>
<div style="height: 140px"></div>
<div id="container" class="width_full_size" style="height: 200px;">
<form action="patLogin.jsp" style="width: 20%;" class="margin_center">
<table>
	<tr>
		<td colspan="3"><span style="font-size: 20px;">로그인 또는
		<a href="join.html"style="text-decoration: none;line-height: inherit;"><span class="color_orange">회원가입</span></a></span></td>
	</tr>
<!-- 	<tr>
		<td style="border-bottom: 1px dotted black;"></td>
	</tr> -->
	<tr>
		<td colspan="3" class="font_bold" style="font-size: 10px;">아이디</td>
	</tr>
	<tr>
		<td colspan="3"> <input type="text" name="id" placeholder="아이디" class="width_full_size" style="font-size: 10px;padding: 4px;"/> </td>
	</tr>
	<tr>
		<td colspan="3" class="font_bold" style="font-size: 10px;">비밀번호</td>
	</tr>
	<tr>
		<td colspan="3"> <input type="password" name="password" placeholder="비밀번호" class="width_full_size" style="font-size: 10px;padding: 4px;"/> </td>
	</tr>
	<tr>
		<td colspan="2" class="color_orange" style="font-size: 10px;">비밀번호가 기억나지 않으세요?</td>
		<td style="height: 20px;" class="height_full_size bg_color_orange"><input type="submit" value="로그인"/></td>
	</tr>
</table>
<!-- <table class="table_default">
	<tr>
		<td><input type="text" name="" placeholder="아이디" class="border_none"/></td>
		<td rowspan="2"><input type="button" value="로그인" class="width_full_size height_full_size"/></td>
		<td rowspan="2" style="height: 100%;"><a href="admin.html" class=" text_no_underline">로그인</a></td>
	</tr>
	<tr>
		<td><input type="password" name="" placeholder="비밀번호" class="border_none"/></td>
	</tr>
</table> -->
</form>
</div>
<div id="footer" class="width_full_size" style="height: 100px; border-top:2px solid black;">
	<dl class="notice">
		<dt><a href="/NOTICE" class="h_notice">공지사항</a></dt>
	</dl>
	<dl class="policy">
		<dt>네이버 정책 및 약관</dt>
		<dd class="f"><a href="http://www.navercorp.com/" target="_blank" id="plc.intronhn">회사소개</a></dd>
		<dd><a href="http://mktg.naver.com/" id="plc.adinfo">광고</a></dd>
		<dd><a href="https://submit.naver.com/" id="plc.search">마이비즈니스</a></dd>
		<dd><a href="https://www.navercorp.com/ko/company/proposalGuide.nhn" target="_blank" id="plc.contact">제휴제안</a></dd>
		<dd><a href="rules/service.html" id="plc.service">이용약관</a></dd>
		<dd><a href="rules/privacy.html" id="plc.privacy"><strong>개인정보처리방침</strong></a></dd>
		<dd><a href="rules/youthpolicy.html" id="plc.youth">청소년보호정책</a></dd>
		<dd><a href="rules/spamcheck.html" id="plc.policy">네이버 정책</a></dd>
		<dd><a href="https://help.naver.com/" id="plc.helpcenter">네이버 고객센터</a></dd>
	</dl>
	<address>&copy; <strong><a href="http://www.navercorp.com/" target="_blank">NAVER Corp.</a></strong></address>
</div>
</div>
</body>
</html>