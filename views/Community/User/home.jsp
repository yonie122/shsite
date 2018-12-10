<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<html>
<head>
	<title>Home</title>
</head>
<body>

<P>  The time on the server is ${serverTime}. </P>
<!-- <form action="signupform">
	<input type="submit" value="회원가입">
</form>

<form action="loginform">
	<input type="submit" value="로그인하세요">
</form>
 -->
<c:if test="${sessionScope.login.userid == null}">
<form action="signupform">
	<input type="submit" value="회원가입">
	</form>
	
<form action="loginform">
	<input type="submit" value="로그인">
</form>
</c:if>

<c:if test="${sessionScope.login.userid != null}">
<form action="loginform">
	<input type="submit" value="로그아웃">
	</form>
	
<form action="">
	<input type="submit" value="내정보">
</form>
</c:if>




</body>
</html>
