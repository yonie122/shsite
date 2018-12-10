<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

#board td tr {
	color: #669;
	border-top: 1px solid #e8edff;
	padding: 10px 15px;
}

tbody {
	text-align: center;
}

tbody.content tr:hover td {
	color: #339;
	background: #eff2ff;
}
</style>
</head>
<body>
	<form name="forms" method="post">
		<table id="board">
			<thead>
				<tr>
					<th scope="col" width="50px">글번호</th>
					<th scope="col" width="50px">글태그</th>
					<th scope="col" width="600px">글제목</th>
					<th scope="col" width="50px">작성자</th>
					<th scope="col" width="100px">작성일</th>
					<th scope="col" width="50px">조회수</th>
					<th scope="col" width="50px">좋아요</th>
				</tr>
			</thead>

			<tbody class="content">
				<c:forEach items="${list}" var="list">
					<tr>
						<td>${list.noticePostNo }</td>
						<td>${list.noticePtagName }</td>
						<td><a href="contentView?noticePostNo=${list.noticePostNo}">${list.noticeTitle }</a></td>
						<td>${list.noticePostWriter}</td>
						<td><fmt:formatDate value="${list.noticePostDate }"
								pattern="yyyy-MM-dd" /></td>
						<td>${list.noticePostNv }</td>
						<td>${list.noticePostLike}</td>
					</tr>
				</c:forEach>
			</tbody>

			<tr>

				<td align="right" colspan="7">
	
						<input type="button" onclick="write2()" value="글쓰기">
				</td>

			</tr>
			<tr>
				<td align="center" colspan="8">
				<select name="searchType">
						<option value="tc" <c:out value="${cri.searchType eq 'tc'?'selected':''}"/> >제목+내용</option>
						<option value="w" <c:out value="${cri.searchType eq 'w'?'selected':''}"/>>작성자</option>
				</select> 
				<input type="text" name="keyword" value="${cri.keyword }" > 
				<input type="button" onclick="search()" value="검색">
				<input type="button" onclick="list2()" value="목록으로">
				</td>
			</tr>

		</table>
	</form>
	
	<script>
	function write2(){
		var f = document.forms;
		f.action="write";
		f.submit();
	}
	function list2(){
		var f = document.forms;
		f.action="list";
		f.submit();
	}
	
	function search(){
		var f= document.forms;
		f.action="search";
		f.submit();
	}
	
	</script>
</body>
</html>