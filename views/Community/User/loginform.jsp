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
<form action="loginprocess" method="post"> <!--�α��ν� ����ȭ������ -->

	 <table border="1">
	  <th colspan='2'>
    * SUNHOSITE *
    </th>



   
            <tr>
                <td>
                   	���̵�
                </td>
                <td>
                     <input type="text" id="userid" name="userid" >
                </td>
            </tr>
            <tr>
                 <td>
                                             ��й�ȣ
                 </td>
                 <td>
                    <input type="password" id="userpw" name="userpw" >
                 </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="�α���">
                </td>
            </tr>
        </table>
    </form>


</body>
</html>