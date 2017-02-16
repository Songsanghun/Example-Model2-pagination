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

	<div style="width: 90%"></div>
	<table class="table_default margin_center text_center"
		style="width: 500px; margin-top: 100px">
		<tr>
			<th>No</th>
			<th>ID</th>
			<th>제목</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<%
			BoardService service = BoradServiceImpl.getInstance();
			List<ArticleBean> list = service.list();
			int cardinality = 5;
			int articleCount = service.count();
			int blockCount = articleCount / cardinality;
			if (articleCount % cardinality == 0) {
				blockCount = articleCount / cardinality;
			} else {
				blockCount = articleCount / cardinality + 1;
			}
			int blockNo = 0;
			int blockStart = 0;
			int blockEnd = 0;
			for (int i = 0; i < cardinality; i++) {
		%>
		<tr>
			<td><%=list.get(i).getSeq()%></td>
			<td><%=list.get(i).getId()%></td>
			<td><%=list.get(i).getTitle()%></td>
			<td><%=list.get(i).getRegdate()%></td>
			<td><%=list.get(i).getReadCount()%></td>
		</tr>
		<%
			}
		%>
		<tr>
			<td colspan="5">
				<div>
					<%="◀"%>

					<%=blockStart%>

					<%=blockEnd%>
					<%="▶"%>
				</div>
			</td>
		</tr>
	</table>



</body>
</html>