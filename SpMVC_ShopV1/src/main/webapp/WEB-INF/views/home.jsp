<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>나의 홈페이지</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://kit.fontawesome.com/994ae0a268.js"
	crossorigin="anonymous"></script>

<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

header {
	background-color: green;
	color: white;
	text-align: center;
	padding: 1.5rem;
}


</style>
<link rel="stylesheet" type="text/css" href="${rootPath}/static/css/input.css?var=2020-08-19"/>
</head>
<body>
	<header>
		<h3>빛나리 쇼핑몰 V1</h3>
		<p>빛나리 쇼핑몰 2020 V1</p>
	</header>
	<%@ include file="/WEB-INF/views/include/include-nav.japf"%>
	<section>
		<c:choose>
			<c:when test="${BODY == 'PRO_WRITE'}">
				<%@ include file="/WEB-INF/views/product/product_write.jspf" %>
			</c:when>
			
			<c:when test="${BODY == 'DEPT_LIST'}">
				<h3>,거래처 리스트</h3>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/views/include/include_main.jspf" %>
			</c:otherwise>
		</c:choose>
	</section>
</body>
</html>