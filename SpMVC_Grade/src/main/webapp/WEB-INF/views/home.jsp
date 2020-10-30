<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>나의 홈페이지</title>
<style type="text/css">
table {
	width: 80%;
	margin: 10px auto;
	border-collapse: collapse;
}

th, td {
	border: 1px solid blue;
	text-align: center;
}

div {
	width: 80%;
	margin: 10px auto;
	text-align: right;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$(function() {
		$(".grade").click(function() {
			let id = $(this).data("id")
			document.location.href = "${rootPath}/update?id=" + id
		})
	})
})
</script>
</head>
<body>
	<h3>학생 성적정보 리스트</h3>
	<table id="ems-list">
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
			<th>기타</th>
		</tr>
		<c:if test="${empty gradeList}">
			<tr>
				<td colspan="8">데이터가 없음</td>
			</tr>
		</c:if>
		<c:forEach items="${gradeList}" var="list">
			<tr class="grade" data-id="${list.g_id}">
				<td>${list.g_id}</td>
				<td>${list.g_name}</td>
				<td>${list.g_kor}</td>
				<td>${list.g_eng}</td>
				<td>${list.g_math}</td>
				<td>${list.g_sum}</td>
				<td>${list.g_avg}</td>
				<td><a href="${rootPath}/delete?id=${list.g_id}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a href="${rootPath}/input">새로작성</a>
	</div>
</body>
</html>