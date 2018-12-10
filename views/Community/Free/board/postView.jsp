<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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


</head>
<body>



<table id = "ver-minimalist"  border = "2">
<tr id = "first">
<td>POSTNO</td>
<td>PTAGNAME</td>
<td>PTITLE</td>

<td>WRITER</td>
<td>POSTDATE</td>
<td>MODIDATE</td>
<td>POSTNV</td>	
<td>LIKECOUNT</td>
</tr>




<tr>
<td>${freeBoardList["0"].postNo }</td>
<td>${freeBoardList["0"].ptagName }</td>
<td>${freeBoardList["0"].ptitle }</td>
<td>${freeBoardList["0"].writer }</td>
<td>${freeBoardList["0"].postDate }</td>
<td>${freeBoardList["0"].modiDate }</td>
<td>${freeBoardList["0"].postNv }</td>
<td>${freeBoardList["0"].likeCount }</td>
</tr>




<tr>
<td colspan = "8">${freeBoardList["0"].pdetail }</td>
</tr>

</table>

<button id = "updateFree" name = "updateFree" value = 'updateFree' onclick = "updateFree()">수정</button>
<button id = "deleteFree" name = "deleteFree" value = "deleteFree" onclick = "deleteFree()">삭제</button>
<a href = "freeBoard?baseNum=1&endNum=10">리스트로돌아가기.</a>



<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type = "text/javascript">

function updateFree() {
	var a = ${freeBoardList["0"].postNo };

	

	
	 location.href = "updateFree?baseNum=" + a; 
//	location.href = "updateFree";
}


function deleteFree()  {
var a = ${freeBoardList["0"].postNo };  


  	location.href="deleteFree?baseNum=" +a;
 
	
}

</script>
</body>
</html>