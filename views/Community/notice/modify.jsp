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

#board tr td {
	color: #669;
	border-top: 1px solid #e8edff;
	padding: 10px 15px;
}

.resize {
resize: none;
}
</style>
</head>
<body>
	<form action="modifyView" method="post">
		<table id="board">
			<tr>
				<td colspan="2"> 글번호: ${contentView.noticePostNo }
				<input type="hidden" name="noticePostWriter" value="${contentView.noticePostWriter }">
				<input type="hidden" name="noticePostLike" value="${contentView.noticePostLike }">
				<input type="hidden" name="noticePostNv" value="${contentView.noticePostNv }">
				<input type="hidden" name="noticePtagName" value="${contentView.noticePtagName }">
				<input type="hidden" name="noticePostNo" value="${contentView.noticePostNo }">
				<input type="hidden" name="noticePostDate" value="${contentView.noticePostDate }">
				<input type="hidden" name="noticeModiDate" value="${contentView.noticeModiDate }">
				</td>
			</tr>
			<tr>
				<td scope="col" width="50px">제목</td>
				<td scope="col" width="400px"><input type="text" name="noticeTitle"
					value="${contentView.noticeTitle }" style="width:96%"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea class="resize" name="noticePdetail" style="width:97%" rows="20">${contentView.noticePdetail }</textarea></td>
			</tr>
			<tr>
				<td align="right" colspan="3"><input type="submit" value="수정완료"><a href="list"><input type="submit" value="수정취소"></a></td>
			</tr>
		</table>
	</form>
</body>
</body>
</html>