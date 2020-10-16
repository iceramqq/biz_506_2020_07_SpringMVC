<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<nav id="main-nav">
	<ul id="main-menu">
		<li><a href="/">HOME</a></li>
		<li><a>시대별 추천코스</a>
			<ul id="sub-menu">
				<li><a href="page1">삼국 시대</a></li>
				<li><a href="page2">고려 시대</a></li>
				<li><a href="page3">조선 시대</a></li>
			</ul></li>
		<li><a>지역별 추천코스</a>
			<ul id="sub-menu">
				<li><a href="page4">경기 지방</a></li>
				<li><a href="page5">관동 지방</a></li>
				<li><a href="page6">호서 지방</a></li>
				<li><a href="page7">호남 지방</a></li>
				<li><a href="page8">경남 지방</a></li>
			</ul></li>
		<li><a href="page9">인기별 추천코스</a></li>
	</ul>
</nav>