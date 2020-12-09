<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${rootPath}/static/css/main.css?ver=20202-12-09" />
<script>
	document.addEventListener("DOMContentLoaded",function() {
		const menu_station = document.querySelector("nav.main-nav .get-station")
		menu_station.onclick = function() {
			document.location.href = "${rootPath}/bis/station"
		}
		const select_cat = document.querySelector("select[name='cat']")
		select_cat.onchange = function(e) {
			const value = e.target.value
			if (value === 'hosp') {
				document.querySelector("input[name='search']").placeholder = '병원명 입력 후 enter...'
			} else {
				document.querySelector("input[name='search']").placeholder = '주소 입력 후 enter...'
			}
		}
	})
</script>

</head>
<body>
	<header>
		<h2>공공DB활용</h2>
	</header>
	<nav class="main-nav">
		<ul>
			<li>Home</li>
			<li>
				<form>
					<select name="cat">
						<option value="hosp">병원명</option>
						<option value="addr">주소</option>
					</select> <input name="search" type="search"
						placeholder="동물병원 이름을 입력한 후 Enter">
				</form>
			</li>

			<li>
				<form action="${rootPath}/bis/station">
					<input name="station" placeholder="정류소 입력후 Enter...">
				</form>
			</li>
			<li class="get-station">노선정보가져오기</li>
		</ul>
	</nav>
	<section>
		<c:if test="${BODY == 'PET' }">
			<%@ include file="/WEB-INF/views/pet_view.jsp"%>
		</c:if>
		<c:if test="${BODY == 'STATION' }">
			<%@ include file="/WEB-INF/views/station_view.jsp"%>
		</c:if>
	</section>

</body>
</html>