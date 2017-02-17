<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="util.BMI" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>BMI 측정</title>
</head>
<body>

<% 	
	int age = Integer.parseInt(request.getParameter("age"));
	double kg = Double.parseDouble(request.getParameter("kg"));
	double cm = Double.parseDouble(request.getParameter("cm"));
%>

<div>
나이 <%= age %> 세 <br />
몸무게 <%= kg %> kg <br />
키 <%= cm %> cm <br />
결과 : <%= new BMI().getBmi(kg,cm) %>

</div>
</body>
</html>