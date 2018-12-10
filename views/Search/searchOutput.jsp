<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색결과</title>
<style>
#board {
	font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
	font-size: 12px;
	width: 1000px;
	text-align: left;
	border-collapse: collapse;
	margin: 20px;
}

#board th {
	font-size: 14px;
	font-weight: normal;
	color: #039;
	padding: 12px 15px;
}

#board td {
	color: #669;
	border-top: 1px solid #e8edff;
	padding: 10px 15px;
}

#board tr:hover td {
	color: #339;
	background: #eff2ff;
}
</style>
</head>
<body>
	<table id="board">
		<thead>
			<tr>
				<th scope="col" colspan="3">검색 결과</th>
			</tr>
			<tr>
				<th scope="col" width="50px">글번호</th>
				<th scope="col" width="600px" style="text-align: center;">글제목</th>
				<th scope="col" width="50px">작성자</th>
				<th scope="col" width="50px">작성일</th>
				<th scope="col" width="50px">조회수</th>
				<th scope="col" width="50px">좋아요</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach var="page" items="${searchlist}">
					<tr>
						<td>${page.postno}</td>
						<td><a id="title" href="anonyRead?postno=${page.postno}">${page.ptitle}</a></td>
						<td>${page.writer}</td>
						<td>${page.postdate}</td>
						<td>${page.postnv}</td>
						<td>${page.likecount}</td>
					</tr>
				</c:forEach>
		</tbody>
	</table>
	<script src="resources/js/anonyListJS.js"></script>
</body>
</html>