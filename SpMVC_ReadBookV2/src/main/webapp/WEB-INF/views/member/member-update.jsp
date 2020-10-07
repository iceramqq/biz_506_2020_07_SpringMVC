<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${rootPath}/static/css/member-write.css?ver=2020-08-25-01" />
<script>
const id_check = function(username){
if(username === ""){
	$("div#msg_username").css("display","block")
	$("div#msg_username span").css("color","red")
}
$.ajax({
	url : "${rootPath}/member/id_check",
	method : "POST",
	data : {
		"username" : username
	},
	beforeSend : function(ax) {
		ax.setRequestHeader("${_csrf.headerName}",
				"${_csrf.token}")
	},
	success : function(result) {
		$("div#msg_username").css("display",
				"block")
		if (result === "OK") {
			//alert("사용가능")
			$("div#msg_username span").text(
					"사용가능한 username 입니다")
			$("div#msg_username span").css("color",
					"blue")
			$("#password").focuse()
		} else {
			//alert("사용 불가능")
			$("div#msg_username span").text(
					"사용 불가능한 username 입니다")
			$("div#msg_username span").css("color",
					"red")
			$("#username").focuse()
		}

	},
	error : function() {
		alert("통신오류")
	}
	})
})
}

$(function() {
	$("#btn_save").click(function() {
		let username = $("username").val()
		let password = $("password").val()
		let re_password = $("re_password").val()

		if (username === "") {
			alert("사용자 이름을 입력한 후 중복검사를 수행하세요")
			$("#username").focuse()
			return false;
		}
		if (password === "") {
			alert("비밀번호를 입력해 주세요")
			$("#password").focuse()
			return false;
		}
		if (re_password === "") {
			alert("비밀번호 확인을 입력해 주세요")
			$("#re_password").focuse()
			return false;
		}

		if (password != re_password) {
			alert("비밀번호와 비밀번호 확인란이 같지 않습니다")
			$("#password").val("")
			$("#re_password").val("")
			$("#password").focuse()
			return false;
		}
		$("from").submit()
	})
	
	$("#m_username").blur(function() {
		let username = $("#username").val()
		id_check(username)		
		)}
	
	$("#m_username").clck(function() {
		let username = $("#username").val()
		id_check(username)		
		)}
	
})
</script>
<%/*
controller에서 @sessionAttributes()와 @ModelAttribute() 설정이 잇고
jsp에서 spring form taglib를 사용하면서
form:form에 modelAttribute()
*/%>
<style>
div#msg_username {
	display: none;
}
</style>
<form:form modelAttribute="memberVO" id="member-write">
	<fieldset>
		<legend>회원가입</legend>
		<div>
			<label>회원 ID</label>
			<form:input path="username" class="username" />
		<div id="msg_username">
			<label></label> <span></span>
		</div>
		<div>
			<label>비밀번호</label>
			<form:input path="password" type="password" />
		</div>
		<div id="msg_password">
			<label></label> <span></span>
		</div>
		<div id="btn_box">
			<button type="button" id="btn_home" onclick="list()">홈으로</button>
			<button type="button" id="btn_save">다음으로</button>
		</div>
	</fieldset>
</form:form>

<script>
	function list() {
		document.location.href = "${rootPath}/"
	}
</script>


