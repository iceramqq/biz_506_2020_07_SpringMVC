<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>

<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script>
	// 현재 화면의 dom이 load 된 후
	// 와 비슷한 event로 load event가 있는데
	// load event
	window.addEventListener("load",function(){
		document
			.querySelector("#menu-home")
			.addEventListener("click",function(){
			// alert("회원가입")
			document.location.href = "${rootPath}/"
		})
		document
			.querySelector("#menu-center")
			.addEventListener("click",function(){
			// alert("회원가입")
			document.location.href = "${rootPath}/admin"
		})
		document
			.querySelector("#menu-join")
			.addEventListener("click",function(){
			// alert("회원가입")
			document.location.href = "${rootPath}/user/join"
		})
		document
			.querySelector("#menu-login")
			.addEventListener("click",function(){
			// alert("회원가입")
			document.location.href = "${rootPath}/user/login"
		})
		document
			.querySelector("#menu-mypage")
			.addEventListener("click",function(){
			// alert("회원가입")
			document.location.href = "${rootPath}/user/mypage"
		})
	})
</script>
<nav id="main-nav">
	<ul>
		<li id="menu-home">home</li>
		<li id="menu-Center">Center</li>
		<%/*
			isAnnoymous()
			현재 화면에서
		*/%>
		<sec:authorize access="isAnonymous()">
			<li id="menu-join">회원가입</li>
			<li id="menu-login">로그인</li>
		</sec:authorize>
		<%/*
			isAuthenticated()
			현재 화면에서 권한 관계없이 로그인한 세션정보가 있으면
			mypage, 로그아웃  메뉴를 보여라
		*/%>
		<sec:authorize access="isAuthenticated()">
			<li id="menu-mypage">MyPage</li>
			<li>로그아웃</li>
		</sec:authorize>
		<%/*
			hasRole('ROLE_ADMIN')
			로그인 세션정보가 있고, ROLE(권한)정보가 ROLE_ADMIN이면
		*/%>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li>관리자</li>
		</sec:authorize>
		<%/*
			hasRole('USER')
			로그인 세션정보가 있고, ROLE(권한)정보가 USER이면
		*/%>
		<sec:authorize access="hasRole('USER')">
			<li>일반 사용자</li>
		</sec:authorize>
		<%/*
			hasRole('GUEST')
			로그인 세션정보가 있고, ROLE(권한)정보가 GUEST이면
		*/%>
		<sec:authorize access="hasRole('GUEST')">
			<li>손님</li>
		</sec:authorize>
	</ul>
</nav>
