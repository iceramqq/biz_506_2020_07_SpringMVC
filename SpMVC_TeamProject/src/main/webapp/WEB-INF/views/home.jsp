<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<style>
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	padding: 0;
	font-family: "Roboto", serif;
	display: flex;
	flex-flow: column nowrap;
	justify-content: center;
	overflow-x: hidden;
}

h1 {
	margin: 100px;
	text-align: center;
}

nav {
	width: 100%;
	display: flex;
	justify-content: center;
	position: relative;
	background: linear-gradient(90deg, #051937, #004d7a, #008793, #00bf72, #a8eb12);
	cursor: pointer;
}

ul, li {
	margin: 0;
	padding: 0;
	list-style: none;
}

#main-menu li {
	float: left;
	position: relative;
}

#main-menu li a {
	font-size: 0.85rem;
	color: rgba(255, 255, 255, 0.85);
	text-align: center;
	text-decoration: none;
	letter-spacing: 0.05em;
	display: block;
	padding: 14px 36px;
}

#sub-menu {
	position: absolute;
	background: rgb(19, 201, 247);
	opacity: 0;
	visibility: hidden;
	transition: all 0.15s ease-in;
}

#sub-menu li a {
	color: white;
	text-decoration: none;
}

#main-menu li:hover #sub-menu {
	opacity: 1;
	visibility: visible;
	text-align: center;
}

#sub-menu li a:hover {
	text-decoration: underline;
}

img {
	vertical-align: middle;
	width: 100%;
	padding: 60px;
}

/* Slideshow container */
.slideshow-container {
	max-width: 900px;
	position: relative;
	margin: auto;
	overflow: auto;
}

/* The dots/bullets/indicators */
.dot {
	transition: background-color 0.6s ease;
}

/* Fading animation */
.fade {
	-webkit-animation-name: fade;
	-webkit-animation-duration: 1.5s;
	animation-name: fade;
	animation-duration: 1.5s;
}

.mySlides {
	margin: 100px;
	height: 650px;
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 800px;
}
</style>
</head>
<body>
	<h1>문화탐방</h1>
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	<c:choose>
		<c:when test="${BODY == 'PAGE1' }">
			<%@ include file="/WEB-INF/views/page1.jsp"%>
		</c:when>
		
		<c:otherwise>
			<%@ include file="/WEB-INF/views/main.jsp"%>
		</c:otherwise>
	</c:choose>
</body>
</html>