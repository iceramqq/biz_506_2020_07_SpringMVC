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
</head>
<body>
<section id="search-list">
	<c:forEach items="${NAVERS}" var = "naver">
		<div data-isbn="${naver.contentid}" class="book-select">
			
			<a href="${naver.link}" target=_new>
				<c:if test="${naver.firstimage == 'noImage' }">
					<p>noImage</p>
				</c:if>
				<c:if test="${naver.firstimage != 'noImage' }">
					<img src="${naver.firstimage}" alt="네이버 이미지">
				</c:if>
			</a>
			<h3>${naver.title}</h3>
		</div>	
	</c:forEach>
</section>

</body>
</html>