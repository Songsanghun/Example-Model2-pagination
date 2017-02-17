<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>ReportCard</title>
</head>
<body>

<% 
		int korean = Integer.parseInt(request.getParameter("korean"));
		int english = Integer.parseInt(request.getParameter("english"));
		int math = Integer.parseInt(request.getParameter("math"));
		int science = Integer.parseInt(request.getParameter("science"));
		int total = korean + english + math + science;
		int average = total / 4;
		String grade = "";
		if(average >=90){
			grade = "A";			
		}else if(average >=80){
			grade = "B";
		}else if(average >=70){
			grade = "C";
		}else{
			grade = "D";
		}
%>

총점 : <%= total  %> <br />
평균 : <%= average %> <br />
등급 : <%= grade %>

</body>
</html>