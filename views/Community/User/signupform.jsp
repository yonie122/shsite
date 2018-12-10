<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="http://code.jquery.com/jquery-1.4.4.min.js"></script>
    <title>Document</title>
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

    
    <form action="signupresult" method="post">
        <table border='1'>

            <tr>
                <td><label for="id">아이디</label></td>
               <td> <input type="text" name="userid" id="userid" > </td> 
                <td><input type="button" onclick = "idcheck()" value="중복확인"><br></td> 
            </tr>

            <tr>
                <td colspan="3">
                    <span id="iderror"></span>
                </td>
            </tr>
            <tr>
                <td>
                    비밀번호 
                </td>
                <td colspan='2'>
                    <input type="password" name="userpw" id="userpw">
                </td>
            </tr>
            <tr>
                <td colspan='3' ><span id ='pwderror'></span></td>
            </tr>
<!--             <tr>
                <td>
                    비밀번호 확인
                </td>
                <td colspan='2'>
                    <input type="password" name="repwd" id="repwd">
                </td>
            </tr>
            <tr>
                <td colspan='3'><span id="repwderror"> </span></td>
            </tr> -->
            <tr>
                <td>
                    이름 
                </td>
                <td colspan='2'>
                    <input type="text" name="uname" id="uname">
                </td>
            </tr>
            <tr>
                <td colspan='3'><span></span></td>
            </tr>
            <tr>
                <td>
                    닉네임 
                </td>
                <td>
                    <input type="text" name="nickname" id="nickname"> 
                </td>
                <td>
                    <input type="button" id="nickchkbtn" value="중복확인">
                </td>
            </tr>
            <tr>
                <td colspan='3'><span></span></td>
            </tr>

            <tr>
                <td>
                    e-mail 
                </td>
                <td>
                    <input type="text" name="uemail" id="uemail"> @ <input type ="text" name="email2" id="email2" > 
                </td>
                <td>
                    <select name="mailad" id="mailad">
                        <option value="" >직접입력</option> 
                        <option value="naver.com">naver.com</option> 
                        <option value="nate.com" >nate.com</option> 
                        <option value="gmail.com" >gmail.com</option> 
                        <option value="hanmail.net" >hanmail.net</option> 
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan='3'><span></span></td>
            </tr>
            
           <br>
            
            <span> </span>
            
            <tr>
                <td>

                    <input type="submit" value="완료"><br>
                </td>
            </tr>
            
            
            
            
        </table>
    </form>
        
    <script>
            
    window.onload = function () {

        
        /*각 항목별로 유효성 검사(ex:아이디는 영문과 숫자만 가능합니다)...*/
        function validCheck(){ //유효성검사 
            var idVal = document.getElementById('id').value;
            var pwdVal = document.getElementById('pwd').value;
            var repwdVal = document.getElementById('repwd').value;
            
            var regTypeId = /^[a-z0-9+]*$/;

            /*아이디 벨리데이션*/
            if(idVal !==''){//아이디가 공백이 아닐때
                if(regTypeId.test(idVal)){//조건에 정규식으로 id필드 검사가 true일때 라는 조건을 넣어야함
                    document.getElementById("iderror").innerText="";
                }else{
                    document.getElementById("iderror").innerText="아이디는 영문과 숫자로만 입력가능합니다.";
                }
            }else{//아이디가 공백일 때
                document.getElementById("iderror").innerText="아이디를 입력해주세요.";
            }


            /*패스워드 벨리데이션(공백만 체크한다)*/
             if(pwdVal !==''){
                    document.getElementById("pwderror").innerText="";
                
            }else{
                document.getElementById("pwderror").innerText="비밀번호를 입력해주세요.";
            }

            if(repwdVal !==''){
                    document.getElementById("repwderror").innerText="";

            }else{
                document.getElementById("repwderror").innerText="올바르게 입력해주세요.";

            }


            
        }
        /*모든 인풋에 대해 키업 이벤트 발생 시, 각 항목별 유효성 검사 실행*/
        $("input").keyup(function(){
            validCheck();
        });

        $("#mailad").change(function(){
            if(document.getElementById('mailad') === ''){
                //
            }else{
                $('#email2').val($('#mailad').val());
            }
            
        });



 
    }

    function idcheck(){
        if(document.getElementById('id').value !== 'session.userid'){
            alert('사용가능한 아이디입니다.');
        }else{
            alert('중복된 아이디입니다.');
        }
    }
    
    
    </script>
  



    
</body>
</html>  