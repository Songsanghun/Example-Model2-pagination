<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="domain.ArticleBean"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="service.BoardService"%>
<%@ page import="serviceImpl.BoradServiceImpl"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
<link rel="stylesheet" href="../../css/hanbit.css" />
</head>
<body>
<% 			
			BoardService service = BoradServiceImpl.getInstance();
			List<ArticleBean> list = service.list();
			int rowCount = 5;
			int card = service.count();
%>
	<div style="width: 90%">
	<table class="table_default margin_center text_center"
		style="width: 500px; margin-top: 100px">
		<tr><th colspan="5" style="text-align:  right;">총게시글수: <%=card %> 건</th></tr>
		<tr>
			<th>No</th>
			<th>ID</th>
			<th>제목</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<%
			for (int i = 0; i < rowCount; i++) {
		%>
		<tr>
			<td><%=list.get(i).getSeq()%></td>
			<td><%=list.get(i).getId()%></td>
			<td><a href=""> <%=list.get(i).getTitle()%></a></td>
			<td><%=list.get(i).getRegdate()%></td>
			<td><%=list.get(i).getReadCount()%></td>
		</tr>
		<%
			}
		%>
</table>
		<nav style="width : 500px; margin : 0 auto;">
			<ul class="gnb" style="background-color: white;">
<%
			int pageCount = (card%rowCount==0)?(card / rowCount):(card / rowCount +1);
			for(int i=0;i<pageCount;i++){
%>
				<li style="text-align: center; width: 20px">
<a href=""> <%= i+1 %></a>
				</li>
<%
			}
%>	
			</ul>
		</nav>
		</div>
</body>
</html>