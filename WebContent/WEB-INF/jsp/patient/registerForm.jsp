<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<link rel="stylesheet" href="<%=application.getContextPath() %>/css/hanbit.css" />

</head>
<body>
<div id="wrapper" class="width_full_size">
<div id="header" class="width_full_size position_fix;" style="height:120px;">
	<div class="logo_box width_full_size text_center" style="height: 60%">
	<a href="../../index.html"><img src="<%=application.getContextPath() %>/images/common/index_logo.png" style="margin-top:20px;"></a>
	</div>
	<ul class="gnb width_full_size" style="font-size: 15px; height: 38%">
		<li><a href="join.html" class="text_no_underline">회원가입</a></li>
		<li><a href="login.html" class="text_no_underline">로그인</a></li>
		<li><a href="../bbs/bbs_list.html" class="text_no_underline">자유게시판</a></li>
		<li class="dropdown"><a href="../admin/admin.html" class="text_no_underline">관리자</a>
			<div class="dropdown_content text_left" style="color:black">
				<p><a href="" class="text_no_underline">의 사</a></p>
				<p><a href="" class="text_no_underline">간호사</a></p>
				<p><a href="" class="text_no_underline">환 자</a></p>
				<p><a href="" class="text_no_underline">차 트</a></p>
			</div>
		</li>	
	</ul>
	</div>
<div style="height: 120px;"></div>
<div id="container" class="width_full_size" style="height:700px;">
<div class="width_full_size" style="margin-top:50px;">
	<form action="" class="margin_center" style="width:500px;">
		<table class="width_full_size table_default">
			<tr>
				<td><div>
						<input type="text" name="" placeholder="성명"/> <br />
						<p class="color_blue" style="font-size: 12px;">한글 또는 영문으로 입력해주세요</p>
						</div></td>
			</tr>
			<tr>
				<td><div>
						<input type="text" name="" placeholder="E-Mail"/> <input type="submit" value="중복확인"><br />
						<p style="font-size: 12px">LPOINT 아이디는 자주 사용하시는 이메일 주소를 입력해주세요</p>
						</div></td>
			</tr>
			<tr>
				<td><input type="password" name="" placeholder="비밀번호"/>
					<p style="font-size: 12px">8~15자의 영문자, 숫자, 특수문자를 함께 입력해주세요</p>
				    </td>
			</tr>
			<tr>
				<td><input type="password" name="" placeholder="비밀번호 확인" /><br/></td>
			</tr>
			<tr>
				<td><p><select name="yeat" id="">
						<option value="">1983년</option>
						<option value="">1982년</option>
						<option value="">1981년</option>
						<option value="">1980년</option>
				</select> <select name="month" id="">
						<option value="">1월</option>
						<option value="">2월</option>
						<option value="">3월</option>
						<option value="">4월</option>
						<option value="">5월</option>
						<option value="">6월</option>
						<option value="">7월</option>
						<option value="">8월</option>
						<option value="">9월</option>
						<option value="">10월</option>
						<option value="">11월</option>
						<option value="">12월</option>
				</select> <select name="date" id="">
						<option value="">1일</option>
						<option value="">2일</option>
						<option value="">3일</option>
						<option value="">4일</option>
						<option value="">5일</option>
						<option value="">6일</option>
						<option value="">7일</option>
						<option value="">8일</option>
						<option value="">9일</option>
						<option value="">10일</option>
				</select></p></td>
			</tr>
			<tr>
				<td><p><select name="" id="">
						<option value="">SKT</option>
						<option value="">LGT</option>
						<option value="">KT</option>
				</select> <select name="" id="">
						<option value="">010</option>
						<option value="">011</option>
						<option value="">016</option>
						<option value="">017</option>
						<option value="">018</option>
						<option value="">019</option>
				</select>-<input type="text" />-<input type="text" /></p></td>
			</tr>
			<tr>
				<td><b>정보수신동의</b><span style="text-align:left;">전체선택<input type="checkbox" /></span><br />
					LPOINT |<input type="checkbox" />E-Mail <input type="checkbox" />SMS<br />
					롯데시네마 |<input type="checkbox" />E-Mail <input type="checkbox" />SMS<br />
					<p style="font-size: 12px">*정보수신동의를 하시면, 고객혜택 및 이벤트 등 다양한 정보를
						받으실 수 있습니다</p>
				</td>
			</tr>
			<tr>
				<td>
					<div>
						개인정보<br />유효기간 | <input type="radio" />탈퇴 시 파기 <input type="radio" />1년<br />
						<p style="font-size: 12px">*개인정보 유효기간 경과 이후 개인정보를 분리 저장관리 또는
							파기합니다</p>
					</div>
				</td>
			</tr>
			<tr>
				<td class="color_blue"><p>*선택항목에 동의하지 않으셔도 정상적인 서비스를 이용하실 수 있습니다</p></td>
			</tr>
			<tr style="text-align:center; width:100%">
				<td>
					<input style="background-color: #5e6869; color: white; width:49%; height:40px;" type="button" value="이전" />
					<input style="background-color: blue; color: white; width:49%; height:40px;" type="button" value="다음" />
				</td>
			</tr>
		</table>
	</form>
	</div>
	</div>
<div id="footer" class="width_full_size" style="height:100px; border-top:2px solid #5a5a5a;">
	<dl class="notice">
		<dt><a href="/NOTICE" class="h_notice">공지사항</a></dt>
	</dl>
	<dl class="policy">
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