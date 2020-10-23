<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
section#bbs-detail-header {
	width: 50%;
	margin: 20px auto;
	display: flex;
}

section#bbs-detail-header article:first-child {
	flex: 1;
}

section#bbs-detail-header article:last-child {
	flex: 2;
}

section#bbs-detail-header div {
	margin: 5px;
	padding: 10px;
	border-bottom: 1px solid #ddd
}

section#bbs-detail-header .title {
	display: inline-block;
	width: 25%;
	border-bottom: 2px solid red;
	font-weight: bold;
	text-align: right;
}

section#bbs-detail-header .content {
	display: inline-block;
	width: 60%;
}

section#bbs-detail-header img {
	margin: 5px;
	border-radius: 5px;
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.5)
}

section#bbs-detail-body {
	width: 50%;
	margin: 10px auto;
}

section#bbs-detail-body div {
	border-bottom: 3px solid black;
	padding: 10px;
	font-weight: bold;
	font-size: 25px;
}

section#bbs-button-box {
	width: 50%;
	margin: 10px auto;
	text-align: right;
}

section#bbs-button-box button {
	margin: 5px;
	padding: 10px 16px;
	border: 0;
	outline: 0;
	border-radius: 5px;
	font-weight: bold;
}

section#bbs-button-box button:hover {
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.6);
}

section#bbs-button-box button:nth-child(1) {
	background-color: green;
}

section#bbs-button-box button:nth-child(2) {
	background-color: blue;
	color: white;
}

section#bbs-button-box button:nth-child(3) {
	background-color: orange;
}
</style>
<script type="text/javascript">
document.addEventListener("DOMContentLoaded", function() {
	document.querySelector("section#bbs-button-box").addEventListener("click",function(e){
		let url = "${rootPath}/bbs/${bbsVO.b_seq}/"
		if(e.target.tagName === ("BUTTON")) {
			
			/*
			게시글 삭제를 요청하면(삭제버튼 클릭)
			ajax 사용하여 서버에 delete mathod으로 삭제를 요청하자
			*/
			if(e.target.className == "delete"){
				if(confirm("정말 삭제할까요?")){
					// json 객체데이터를 문자열화 하여 http body 담기
					let data = {
							seq : "${bbsVO.b_seq}",
							subject : "${bbsVO.b_subject}"}
					fetch("${rootPath}/api/bbs",
							{
								method : "DELETE",
								headers : {"Content-type":"application/json"},
								body : JSON.stringify(data) 
							}
					)
					.then(function(result){
						alert(result)
					})
					.catch(function(error){
						alert("실패")
					})
					return false;
				}
			}
			document.location.href = url + e.target.className
		}
	})
})
</script>
<section id="bbs-detail-header">
	<article>
		<a href="${rootPath}/upload/${bbsVO.b_file}" target=_new> 
			<c:if test="${empty bbsVO.b_file}">
				<img src="${rootPath}/static/files/noImage.png" width="200px">
			</c:if>
			<c:if test="${not empty bbsVO.b_file}"> 
				<img src="${rootPath}/upload/${bbsVO.b_file}" width="200px">
			</c:if>
		</a>
	</article>
	<article>
		<div class="title">제목</div>
		<div class="content">${bbsVO.b_subject}</div>
		<div class="title">작성일시</div>
		<div class="content">${bbsVO.b_date},${bbsVO.b_time}</div>
		<div class="title">작성자</div>
		<div class="content">${bbsVO.b_writer}</div>
	</article>
</section>
<section id="bbs-detail-body">
	<div>내용</div>
	<p>${bbsVO.b_content}</p>
</section>
<section id="bbs-button-box">
	<button class="list">리스트</button>
	<button class="update">수정</button>
	<button class="delete">삭제</button>
</section>
<style>
section#images-box {
	width: 50%;
	margin: 3px auto;
	padding: 5px;
}

section#images-box img {
	margin: 3px;
}
</style>
<section id="images-box">
	<c:if test="${not empty bbsVO.images}">
		<c:forEach items="${bbsVO.images}" var="image">
			<img src="${rootPath}/upload/${image.i_file_name}" width="100px">
		</c:forEach>
	</c:if>
</section>
