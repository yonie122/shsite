<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>


<style>



#ver-minimalist {
	font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
	font-size: 12px;
	text-align: left;
	border-collapse: collapse;
	margin: 30px 30px 30px 15px;
	width: 100%;

}

#ver-minimalist th {
	font-weight: normal;
	font-size: 14px;
	border-bottom: 2px solid #6678b1;
	border-right: 30px solid #fff;
	border-left: 30px solid #fff;
	color: #039;
	padding: 8px 2px;
}

#ver-minimalist td {
	border-right: 30px solid #fff;
	border-left: 30px solid #fff;
	color: #669;
	padding: 12px 2px 0;
}

#first{
	font-size : 15px;
}

</style>


<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function page(idx) {

		var pm = $("#snum option:selected").val();

		var baseNum = (idx * pm) - (pm - 1);
		var endNum = baseNum + (pm - 1);

		for (i = 0; i < document.getElementById("snum").options.length; i++) {
			if (document.getElementById("snum").options[i].value == pm) {
				document.getElementById("snum").options[i].selected = "selected";

			}
		}

		location.href = "${pageContext.request.contextPath}/freeBoard?baseNum="
				+ baseNum + "&endNum=" + endNum;
	}

	function view(idx) {

		var baseNum = idx;
		location.href = "FreePostView?baseNum=" + baseNum;
	}

	$(function() {
		var baseNum = ${baseNum };
		$('#selectButton').click(function() {
			page(baseNum);
		});
	})
</script>

</head>
<body>

	<select name="snum" id="snum">
		<option value="10" >10</option>
		<option value="20">20</option>
		<option value="30">30</option>

	</select>
	<button id="selectButton">선택</button>


	<table id="ver-minimalist" border="1"  >

		<tr id = "first" style  = "witdh: 100%;">
			<td>POSTNO</td>
			<td>PTAGNAME</td>
			<td>PTITLE</td>
			<!-- <td>PDETAIL</td> -->
			<td>WRITER</td>
			<td>POSTDATE</td>
			<!-- <td>MODIDATE</td> -->
			<td>POSTNV</td>
		</tr>

		<c:forEach var="freeBoardList" items="${freeBoardList }">
			<tr>
				<td>${freeBoardList.postNo }</td>
				<td>${freeBoardList.ptagName }</td>
				<td><a href="javascript:view (${freeBoardList.postNo });">${freeBoardList.ptitle }</a></td>
				<td>${freeBoardList.writer }</td>
				<td>${freeBoardList.postDate }</td>
				<td>${freeBoardList.postNv }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="center">페이지번호 <c:if test="${page.prev }">
					<a style="text-decoration: none;"
						href="javascript:page(${page.getStartPage()-1});">&laquo;</a>
				</c:if> <c:forEach begin="${page.getStartPage() }"
					end="${page.getEndPage() }" var="idx">
					<a style="text-decoration: none;" href="javascript:page (${idx });">${idx }</a>
				</c:forEach> <c:if test="${page.next }">
					<a style="text-decoration: none;"
						href="javascript:page(${page.getEndPage() });">&raquo;</a>
						<!-- getStartPage() + 5 -->
				</c:if>
			</td>
		</tr>
	</table>
	<br>
	<br>
	<a href="FreeWritePost">글쓰기</a>

</body>
</html>