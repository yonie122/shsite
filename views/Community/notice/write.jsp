 

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

	<form name="writeView" method="post" enctype="multipart/form-data">

		<table id="board">

			<tr>

			<td scope="col" width="50px"> 글태그</td>

			<td scope="col" width="400px"> 

			<select name="noticePtagName ">

						<option value="notice" <c:out value="${cri.noticePtagName  eq 'notice'?'selected':''}"/> >공지</option>

						<option value="etc" <c:out value="${cri.noticePtagName  eq 'etc'?'selected':''}"/>>기타</option>

				</select> </td>

			</tr>

			<tr>

				<td scope="col" width="50px">제목</td>

				<td scope="col" width="400px"><input type="text" name="noticeTitle" style="width:96%"></td>

			</tr>

			<tr>

				<td colspan="2"><textarea class="resize" name="noticePdetail" style="width:97%" rows="20"></textarea></td>

			</tr>

			<tr>

			<td colspan="2"><input type="file" name="file" ><input type="button" value="파일추가" onclick="upload2()"></td>

			</tr>

			<tr>

				<td align="right" colspan="2"><input type="button" onclick="writeView2()" value="등록">

				<a href="list"><input type="button" value="홈으로"></a></td>

			</tr>

		</table>

	</form>

	

		

	<script>

	

	

		function upload2(){

			var f = document.writeView;

			f.action="upload";

			f.submit();

		}

 

		

		function writeView2(){

			var f = document.writeView;

			f.action="writeView";

			f.submit();

		}

	</script>

</body>

</html>