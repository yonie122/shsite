<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<tiles:insertAttribute name="include" />
</head>
<body>
	<div class="mainSection">
		<div>
			<tiles:insertAttribute name="top" />
		</div>
		<div class="left">
			<tiles:insertAttribute name="left" />
		</div>
		<div class="main">
			<tiles:insertAttribute name="main" />
		</div>
		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>