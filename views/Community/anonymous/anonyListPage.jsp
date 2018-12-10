<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>익명게시판</title>
<link rel="stylesheet" type="text/css"	href="resources/css/anonyList.css">
</head>
<body>
	<table id="board">
		<thead>
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
			<c:forEach var="page" items="${postlist}">
				<tr>
					<td>${page.postno}</td>
					<td><a href="anonyRead?postno=${page.postno}">${page.ptitle}</a></td>
					<td>${page.writer}</td>
					<td>${page.postdate}</td>
					<td>${page.postnv}</td>
					<td>${page.likecount}</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
	<div id="list_function">

		<c:if test="${sessionScope.loginStatus==null}">
				<div class="innerDiv">
					<input id="regBtn" type="button" class="btn" value="글쓰기">
				</div>
	</c:if>
	</div>
	<script src="resources/js/anonyListJS.js"></script>
</body>
</html>