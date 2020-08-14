<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
	<link rel="stylesheet" type="text/css" 	href="${rootPath}/static/css/input.css?ver=2020-08-13-002" />
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf"%>
	<section id="main">
		<form action="${rootPath}/blog/writer" method="POST">
			<div>
				<input name="bl_user" placeholder="사용자를 입력하세요" />
			</div>
			<div>
				<input name="bl_title" placeholder="제목을 입력하세요" />
			</div>
			<div>
				<input name="bl_contents" placeholder="내용을 입력하세요" />
			</div>
			
			<div>
				<button type="button">처음으로</button>
				<button type="submit">저장</button>
			</div>
		</form>
	</section>
	<%@ include file="/WEB-INF/views/include/include-footer.jspf"%>
</body>
</html>