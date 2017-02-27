<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="${js}/hospital.js"></script>
<img src="${img}/loading.gif" alt="" />
<script>
$(function() {
	goPage('${context}/home.do','move','main')
});
</script>
