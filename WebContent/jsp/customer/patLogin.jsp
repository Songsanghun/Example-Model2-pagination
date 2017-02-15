<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="serviceImpl.MemberServiceImpl" %>
<%@ page import="service.MemberService" %>
<%@ page import="domain.MemberBean" %>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
<% 
	MemberService service = MemberServiceImpl.getInstance();
	MemberBean member = new MemberBean();
	member.setId(request.getParameter("id"));
	member.setPassword(request.getParameter("password"));
	boolean check = service.login(member);
	if(check){
%>
	<%= request.getParameter("id") %> 님,
	<a href="">내정보</a> <input type="button" value="로그아웃"/>
<% 
	}else{
	
%>	 
	<h3>회원정보가 일치하지 않습니다.</h3>
	<a href="patLoginForm.jsp">뒤로가기</a>
<%		
	}
%>

</body>
</html>