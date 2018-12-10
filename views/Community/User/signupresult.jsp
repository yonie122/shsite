<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table{
  padding-left:200px;
  border: none;
  
}
table tr td{
  padding:10px;
  border-color:#01A9DB;
}
</style>

</head>
<body>
<form action="home">
  <table border="2">
   <tr><td>
     회원가입이 완료되었습니다.<br></td>
   </tr>
   <tr>
    <td>
   
아이디:${UserInfo.userid}<br>
비밀번호:${UserInfo.userpw}<br>
이름:${UserInfo.uname}<br>
닉네임:${UserInfo.nickname}<br>
이메일:${UserInfo.uemail}<br>
   </td>
   </tr>
   
   <tr>
<td>

	<input type="submit" value="완료">
     </td></tr>
</table>
  
</form>





</body>
</html>