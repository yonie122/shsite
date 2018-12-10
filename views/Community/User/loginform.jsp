<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
table{
  all:unset;
  position:absolute;
  left:200px;
  top:80px;
  background-color:#F8E0F7
  
  }

td{
  font-size:25px;
  
  
}
</style>
 
</head>
<body>
<form action="loginprocess" method="post"> <!--로그인시 메인화면으로 -->

	 <table border="1">
	  <th colspan='2'>
    * SUNHOSITE *
    </th>



   
            <tr>
                <td>
                   	아이디
                </td>
                <td>
                     <input type="text" id="userid" name="userid" >
                </td>
            </tr>
            <tr>
                 <td>
                                             비밀번호
                 </td>
                 <td>
                    <input type="password" id="userpw" name="userpw" >
                 </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="로그인">
                </td>
            </tr>
        </table>
    </form>


</body>
</html>