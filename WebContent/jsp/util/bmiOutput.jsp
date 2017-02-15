<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="util.BMI" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>BMI 측정</title>
</head>
<body>
<%!
	public String getBmi(double kg,double cm){
	String result = "";
	double bmi = kg / (cm/100*cm/100);
	if (bmi > 30.0) {
		result = "고도비만";
	} else if (bmi > 25.0) {
		result = "비만";
	} else if (bmi > 23.0) {
		result = "과체중";
	} else if (bmi > 18.5) {
		result = "정상";
	} else {
		result = "저체중";
	}
	return result;
}
%>
<% 
	int age = Integer.parseInt(request.getParameter("age"));
	double kg = Double.parseDouble(request.getParameter("kg"));
	double cm = Double.parseDouble(request.getParameter("cm"));
%>

<div>
나이 <%= age %> 세 <br />
몸무게 <%= kg %> kg <br />
키 <%= cm %> cm <br />
결과 : <%= getBmi(kg,cm) %>

</div>
</body>
</html>