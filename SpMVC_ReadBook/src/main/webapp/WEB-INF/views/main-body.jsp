<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<<style>
section#main-body {
	width: 100%;
	display: flex;
}

section#main-body article {
	border: 1px solid blue;
	margin: 5px;
	flex: 1;
}

</style>
<section id="main-body">
	<article>
		<p>도서목록</p>
	</article>
	<article>
		<p>독서록
	</article>
	<article>
		<p>공지사항
	</article>
</section>