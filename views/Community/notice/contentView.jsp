<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#board {
	font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
	font-size: 12px;
	width: 100%;
	border-collapse: collapse;
	margin: 20px;
}

#board th {
	font-size: 14px;
	font-weight: normal;
	color: #039;
	padding: 12px 15px;
	text-align: center;
}

#board td {
	color: #669;
	border-top: 1px solid #e8edff;
	padding: 10px 15px;
}

tbody.content {
	text-align: left;
	padding-left: 10px;
}
tbody.subtitle {
	text-align: left;
	padding-left: 10px;
	color: #660;
	font-size: 11px;
}
</style>
</head>
<body>

<form name="forms" >
	<table id="board">
		<thead>
			<tr>
				<th><input type="hidden" name="noticePostNo" value="${contentView.noticePostNo }">
				${contentView.noticePtagName}</th>
				<th colspan="4">${contentView.noticeTitle}</th>

			</tr>
		</thead>
		<tbody class="subtitle">
		<tr>
		<td>${contentView.noticePostWriter }</td>
		<td>조회수: ${contentView.noticePostNv }</td>
		<td>작성일: <fmt:formatDate value="${contentView.noticePostDate }" pattern="yyyy-MM-dd"/></td>
		<td>수정일: <fmt:formatDate value="${contentView.noticeModiDate }" pattern="yyyy-MM-dd"/></td>
		<td>좋아요: ${contentView.noticePostLike}</td>
		</tr>
		</tbody>
		<tbody class="content">
			<tr>
				<td colspan="5">${contentView.noticePdetail}</td>

			</tr>
		</tbody>
		<tr>
			<td align="right" colspan="8">
			<input type="button" onclick="modifypost()" value="수정">
			<input type="button" onclick="deletepost()" value="삭제">
			<a href="list"><input type="button" value="목록">	</a>	
		</td>
		</tr>
	</table>
	</form>
	
	<script>
		function modifypost(){
			alert("modifypost");
			var f = document.forms;
			f.action="modify";
			f.submit();
		}
		function deletepost(){
			alert("deltepost");
			var f = document.forms;
			f.action="delete";
			f.submit();
		}
	</script>
</body>
</html>