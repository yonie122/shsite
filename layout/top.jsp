<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Header</title>
<link rel="stylesheet" type="text/css" href="resources/css/header.css">
</head>

<body>
	<header class="header">
		<div id="header_logo">
			<a href="/shsite"><img id="logo" alt="noImg"
				src="resources/img/1.png"></a>
		</div>
		<nav class="nav">
			<ul>
				<li><a href="" class="">새소식</a>
					<ul>
						<li><a href="list" class="">공지사항</a></li>
						<li><a href="/News/Update/List" class="">업데이트</a></li>
						<li><a href="/News/Event/Now" class="">이벤트</a></li>
					</ul></li>
				<li><a href="/Community/Free/List" class="">커뮤니티</a>
					<ul>
						<li><a href="freeBoard?baseNum=1&endNum=10" class="">자유
								게시판</a></li>
						<li><a href="anonyListPage" class="">익명 게시판</a></li>
					</ul></li>
				<li><a href="#" class="">정보공유</a>
					<ul>
						<li><a href="#">팁과노하우</a></li>
						<li><a href="#" class="">스터디구인</a></li>
					</ul></li>
			</ul>
		</nav>

		<div class="header-menu">
			<span class='green_window'> <input type='text'
				class='input_text' />
			</span>
			<button type='button' class='sch_smit'>검색</button>
			<div class="innerDiv">
				<c:choose>
					<c:when test="${sessionScope.login==null}">
						<span><a href="signupform" id="loginBtn">회원가입 </a></span>
						<span><a href="loginform" id="loginBtn"> Login </a></span>
					</c:when>
					<c:otherwise>
						<span>${login.userid}님반갑습니다.</span>
						<span><a href="userSolo" id="loginBtn"> 내정보</a></span>
						<span><a href="logout" id="loginBtn"> 로그아웃 </a></span>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</header>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="resources/js/headerJS.js"></script>
</body>
</html>