<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title>글 읽기</title>
<link rel="stylesheet" type="text/css"
	href="resources/css/anonyRead.css">
</head>
<body>
	<div id="container">
		<input type="hidden" id="postno" name="postno" value="${postContent.postno}" />
		<input type="hidden" id="writer" name="writer" value="${postContent.writer}" />
		<div id="content_title">
			<h2>글 제목</h2>
			<span class="post_title">${postContent.ptitle}</span>
		</div>
		<div id="content_main">
			<section>
				<h2>본 문</h2>
				<c:if test="${imgs!=null}">
					<c:forEach var="img" items="${imgs}">
						<img class="postImg" alt="noImg"
							src='<spring:url value="/images/${img}"/>'>
						<br />
					</c:forEach>
				</c:if>
				<p style="white-space: pre;">
					<c:out value="${postContent.pdetail}" />
				</p>
				<span>${postContent.modidate2}</span>
				<div id="container_btn">
					<span>
						<button id="likeBtn" name="likeBtn" value="unclicked"
							type="button">
							<img id="click_img" alt="noImg"
								src="resources/img/icon/unclicked_thumb.png" />
						</button>
					</span>
				</div>
			</section>
		</div>
		<div id="article_control_btn">
			<button type="button" class="article_btn" style="float: right">목록</button>
			<button type="button" class="article_btn" style="float: right">수정</button>
			<button type="button" class="article_btn" style="float: right">삭제</button>
		</div>

		<div id="coment_list">
			<h2>댓글</h2>
			<div class="comment_form" role="form">
				
					<fieldset>
					<form action="commentInsert" method="post">
						<input type="hidden" id="cpostno" name="cpostno" value="${postContent.postno}" />
						<span>${postContent.writer}</span>
						<input type="text" name="cDetail" id="cDetail" placeholder=""/>
						<button type="submit" class="coment_btn" style="float: right">등록</button>
						</form>
					</fieldset>
				
			</div>
			<div class="comment_list">
				<table>
					<c:forEach var="comment" items="${commentContent}">
						<tr>
							<td width="20px">${comment.commentno}</td>
							<td width="80px">${comment.cuser}</td>
							<td width="600" class="comment_context">${comment.cdetail}</td>
							<td width="200">${comment.cdate}</td>
							<td width="20">${comment.likecount}</td>
							<c:if test="${sessionScope.loginStatus==null}">
								<td><input type="button" class="coment_btn" id="${comment.commentno}" name="deleteBtn" value="삭제"/></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="resources/js/anonyReadJS.js"></script>
</body>
</html>