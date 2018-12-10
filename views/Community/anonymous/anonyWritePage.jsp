<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>글 작성</title>
<link rel="stylesheet" type="text/css"	href="resources/css/anonyWriteCss.css">
</head>
<body>
	<div id="container" >
		<form name="regForm" action="" method="post" enctype="multipart/form-data">
			<input type="hidden" name="nickname" value="${nickname}"/>
			<div id="content_title">
				<h2>글 제목</h2>
				<span class="post_title"><input type="text" name="ptitle"
					required /></span>
			</div>
			<div id="content_main">
				<h2>본 문</h2>
				<textarea name="pdetail" class="post_data" cols="140" maxlength="200"></textarea>
			</div>

			<input type="button" class="btn" id="post_regist_btn" style="float: right" value="등록" /> 
			<input type="button" class="btn" id="post_cancel_btn" style="float: right" value="취소" /> 
			<input type="button" class="btn" id="post_pre_btn" style="float: right"	value="미리보기" />
			<div id="content_upload">
				<div class="input_wrap">
					<a href="javascript:" onclick="fileUploadAction()" class="btn">이미지 업로드</a>
					<a href="javascript:" onclick="fileInsertAction()" class="btn">본문 삽입</a>
					<input type="file" id="input_imgs" name="files" multiple />
				</div>
			</div>
			<div class="imgs_wrap">
				<img id="img" />
			</div>
		</form>
	</div>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="resources/js/anonyWriteJS.js"></script>
</body>
</html>