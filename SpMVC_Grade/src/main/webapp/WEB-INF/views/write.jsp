<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>나의 홈페이지</title>
<style>
form div {
	width: 80%;
	margin: 10px auto;
}

form label, form input {
	display: inline-block;
	padding: 5px;
}

form label {
	width: 20%;
	text-align: right;
}

form input {
	width: 70%;
}

form div:last-child {
	text-align: right;
}
</style>


</head>
<body>
	<h3>학생 성적정보작성</h3>
	<form method="POST" model>
		<div>
			<label>학번</label> <input name="g_id" value="${gradeVO.g_id}">
		</div>
		<div>
			<label>이름</label> <input name="g_name" value="${gradeVO.g_name}">
		</div>
		<div>
			<label>국어</label> <input name="g_kor" type="number" value="${gradeVO.g_kor}">
		</div>
		<div>
			<label>영어</label> <input name="g_eng" type="number" value="${gradeVO.g_eng}">
		</div>
		<div>
			<label>수학</label> <input name="g_math" type="number" value="${gradeVO.g_math}">
		</div>
		<div class="button-box">
			<button type="button" onclick="location.href='${rootPath}/home.jsp'" id="list">리스트</button>
			<button type="submit" id="save">저장</button>
		</div>
	</form>
</body>
</html>