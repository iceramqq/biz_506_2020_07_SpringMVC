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
<style>
	*{
		box-sizing: border-box;
		padding: 0;
		margin: 0;
	}
	html, body {
		width: 100%;
		height: 100%;
	}
	body{
		overflow: auto;
	}
	
	form#books{
		 width: 60%;
		 margin: 10px auto;
	}
	form#books input {
	/*
	만약 input box와 button등 다른 tag를 한줄에 나란히 놓으면서 
	input box의 width를 임의로 설정하고 싶으면
	display를 inline-block으로 설정하자
	
	*/
		display: inline-block;
		width: 90%;
		border: 1px solid #ddd;
		margin: 5px;
		padding: 8px;
	}
	form#books fieldset {
		border: 1px solid rgb(0,100,200);
	}
	
	form#books #title {
		width: 70%;
	}
	form#books div.button-box {
		width: 93%;
		text-align: right;
	}
	
	form#books button {
		border: none;
		outline: 0;
		
		padding: 0.5rem 12px;
		border-radius: 5px;
	}
	
	form#books button#naver-search {
		background-color: green;
		color: white;
	}
	
	form#books button#btn-save {
		background-color: blue;
		color: white;
	}
	form#books button:hover {
		box-shadow: 5px 5px 5px rgba(0,0,0,0.3);
	}
	
	/* modal 설정
	--------------------------------*/
	section#book-modal {
		position: fixed;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		
		/*
		!important
		색상을 지정했을때 
		다른 css하고 충돌하여 색상지정이 원하는대로
		안되는 경우가 있다.
		이때 !important
		*/
		background-color: rgba(0,0,0,0.4);		
	}
	
	article#modal-body {
		position: absolute;
		top: 50%;
		left: 70%;
		width: 70%;
		height: 50%;
		transform: translate(-50%,-50%);
		
		display: flex;
		flex-flow: column nowrap;
	}
	
	div#modal-header {
		flex:1;
		width: 60%;
		text-align: right;
		background-color: rgba(100,100,100,1);
		border-top-left-radius: 10px;
		border-top-right-radius: 10px;
	}
	
	div#modal-header span {
		font-size: 30px;
		font-weight: 500;
		color: white;
		cursor: pointer;
		margin: 15px;
	}
	
	div#modal-header span:hover {
		color: red;
	}
	
	div#search-result {
		flex: 7;
		width: 60%;
		padding: 30px;
		overflow: auto;
		
		background-color: rgba(255,255,255,1);
		border: 1px solid rgba(0,0,255,1);
		
		box-shadow: 10px 10xp 10px rgba(0,0,0,0.5);
		border-bottom-left-radius: 15px;
		border-bottom-right-radius: 15px;
	}
	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function () {
	$("#naver-search").click(function() {
		
		let title = $("#title").val()
		if(title === ""){
			alert("도서명을 입력한 후 검색을 하세요")
			$("#title").focus()
			return false
		}
		// ajax를 사용하여 서버에 네이버 검색 요청
		$.ajax({
			url : "${rootPath}/naver/search",
			method : "POST",
			data : {"search_text" : title},
			success : function(result) {
				$("#search-result").html(result)
			},
			error : function(error){
				alert("서버 통신 오류!!")
			}
		})		
		$("#book-modal").css("display","block")	
	})
	// x 표시를 클릭 했을때 modal 창 닫기
	$("div#modal-header span").click(function() {
		$("#book-modal").css("display","none")	
	})
	
	/*
	동적을로 구현된 html에 event 핸들링 설정하기
	현재 rk 생성되는 동안이 없던 tag 를
	js코드에서 동적으로 생성했을 경우 화면에 그려지는 것은 
	아무런 문제가 없으나
	
	js에서 event핸들러르 설정할때 아직 화면에 없는 tag에 연결을 하면
	무싱헤 버리고 엇ㅂ던일로 만들어 버린다
	
	사후에 js코드로 생성할 tag에 
	event를 설정하려면 자체에 설정하지 않고
	가장 상위 겍체인 document에 on 함수를 사용하여  event를 설ㅈ어한다
	$(document).on("click","div.book-select",function(){}
	
	주의사항
	$(selector).click(function(){})
	만약 기존에 selection에 click event가 설정되어 잇으면
	기존의 잉벤트를 덮어쓰기 한다.
	
	$(document).on("click","div.book-select")
	만약 기존에 
	
	동적으로 여는곳에서는
	$(document).on()을 사용하여 event 행들러를 설정하고 
	
	동적으로 
	*/
	$(document).on("click","div.book-select",function(){
		let isbn = $(this).data("isbn")
		// 
		// 코드의 13자리를 잘라내라
		let length = isbn.length
		isbn = isbn.substring(length - 13)
		//alert(isbn)
		
		$.ajax({
			url : "${rootPath}/api/isbn",
			method : "POST",
			data : {"search_text" : isbn}
		})
		.done(function(bookVO){
			// alert(JSON.stringify(bookVO))
			$("#seq").val(bookVO.seq);
			$("#title").val(bookVO.title);
			$("#link").val(bookVO.link);
			$("#image").val(bookVO.image);
			$("#author").val(bookVO.author);
			$("#price").val(bookVO.price);
			$("#discount").val(bookVO.discount);
			$("#publisher").val(bookVO.publisher);
			$("#isbn").val(bookVO.isbn);
			$("#description").val(bookVO.description);
			$("#pubdate").val(bookVO.pubdate);
			$("#buydate").val(bookVO.buydate);
			$("#buyprice").val(bookVO.buyprice);
			$("#buystore").val(bookVO.buystore);
			$("section#book-modal").css("display","none")

		})
		.fail(function(xhr,textStatus,error){
			alert("서버와 통신오류!")
		})
	})
	
	$("section#book-modal").css("display","none")
})
</script>
<h3>도서정보 등록</h3>
<form method="POST" id="books">
	<fieldset>
		<legend>도서정보 입력</legend>
		<input name="seq" id="seq" placeholder="일련번호"/>
		<input name="title" id="title" placeholder="도서명"/>
		<button id="naver-search" type="button">네이버검색</button>
		<input name="link" id="link" placeholder="상세링크"/>
		<input name="image" id="image" placeholder="이미지"/>
		<input name="author" id="author" placeholder="저자"/>
		<input name="price" id="price" placeholder="가격"/>
		<input name="discount" id="discount" placeholder="할인"/>
		<input name="publisher" id="publisher" placeholder="출판사"/>
		<input name="isbn" id="isbn" placeholder="isbn"/>
		<input name="description" id="description" placeholder="세부설명"/>
		<input name="pubdate" id="pubdate" placeholder="출간일자"/>
		<input name="buydate" id="buydate" placeholder="구입일자"/>
		<input name="buyprice" id="buyprice" placeholder="구입금액"/>
		<input name="buystore" id="buystore" placeholder="구입처"/>
		<div class="button-box">
			<button id="btn-save" type="button">저장</button>
		</div>
	</fieldset>
</form>
<section id="book-modal">
	<article id="modal-body">
		<div id="modal-header">
			<span>&times;</span>
		</div>
		<div id="search-result"></div>
	</article>
</section>
</body>
</html>