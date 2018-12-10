<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type = "text/javascript">





function update() {

	var a= ${freeBoardList["0"].postNo };
	
	var ptagName= document.getElementById("ptagName").value;
	
	var ptitle = document.getElementById("ptitle").value;
	
	var pdetail = document.getElementById("pdetail").value;
	
	
	location.href="afterUpdate?baseNum=" +a+ "&ptagName=" + ptagName + "&ptitle=" + ptitle + "&pdetail=" + pdetail;
	

}
</script>


</head>
<body>

<!-- <form action = "afterUpdate"  method = "post"> -->
<table id = "ver-minimalist" width = "100%">
<tr>

<td class>
게시판
</td>
<td>
자유게시판

</td>
</tr>

<tr>
    <td id = "first">postno</td>
    <td >

        <input size = "43" type= "text" name = "postNo"  value = ${freeBoardList["0"].postNo }  readonly>
    </td>
</tr>

<tr>
    <td id = "first">ptagname</td>
    <td >
        <select name="ptag" id="ptag" onchange = "document.getElementById('ptagName').value = this.options[this.selectedIndex].value">
		<option value="">선택</option>
		<option value="free">free</option>
		<option value="question">question</option>
	</select>
        <input size = "43" type= "text" name = "ptagName" id = "ptagName">
    </td>
</tr>

<tr>
    <td id = "first">ptitle</td>
    <td >
    
        <input size = "43" type= "text" name = "ptitle"  id ="ptitle">
    </td>
</tr>


<tr>
<td id = "first" colspan="2">pdetail</td>
</tr>

<tr>
    <td colspan="2">
        <textarea name = "pdetail"  cols="100"  id ="pdetail"></textarea>
    </td>
</tr>

<tr>
    <td id= "first">writer</td>
    <td >
        <input size = "43" type= "text" name = "writer" id ="writer"  value = "yun" readonly>
    </td>
</tr>



<tr>
    <td id= "first">
        파일첨부
    </td>
    <td>
        <input type="file" name = "uploadFile" id = "uploadFile">
    </td>
</tr>




<tr>
   <td align="right" colspan="2">
        <button  onclick="postPreview()" value="미리보기" >미리보기</button>
        <button onclick = "update()" value="수정">수정</button>
    </td> 
</tr>

<!-- <tr>
<td>
<input type= "submit" value = "수정">수정
</td>
</tr>
</form> -->

</body>
</html>