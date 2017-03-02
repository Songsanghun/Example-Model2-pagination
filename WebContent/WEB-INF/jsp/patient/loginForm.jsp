<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="serviceImpl.PatientServiceImpl"%>
<jsp:include page="../common/top.jsp" />
<jsp:include page="../common/header.jsp" />
<div id="container">
	<div id="logDiv">
		<form id="loginForm">
			<table class="table_default">
				<tr>
					<td><input id="id" type="text" placeholder="아이디" name="id">
					</td>
					<td rowspan="2"><input id="logBox" type="submit" value="LOGIN" />
						<!-- <a href="admin.html">로그인</a> --></td>
				</tr>
				<tr>
					<td><input id="pw" type="password" placeholder="비밀번호"
						name="password"></td>
				</tr>
			</table>
			<input type="hidden" name="action" value="login" /> <input
				type="hidden" name="page" value="main" />
		</form>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
	<script>
		$(function() {

			var $loginForm = $('#loginForm');
			$loginForm.addClass('margin_center').css('width','20%');
			var tab = $loginForm.find('table');
			$('#loginForm input[value=LOGIN]').click(function(event) {
				$loginForm.attr("action","${context}/patient.do");
				$loginForm.attr("method","post");
			var idVal = tab.find('input[name=id]').val();
			var pwVal = tab.find('input[name=password]').val();
				if (idVal== '' || pwVal== '') {
					alert('값을 먼저 입력해주세요!!!!');
				} else {
					alert('로그인하기위해 입력한 ID ,PW 값 ID=' + idVal + ',pw=' + pwVal);
					loginForm.submit();
				}
			})

			$('#container').addClass('width_full_size').css('height', '700px');
			$('#loginForm').addClass('margin_center').css('width', '20%');
			$('#logDiv').addClass('width_full_size').css('margin-top', '200px');

		});
	</script>