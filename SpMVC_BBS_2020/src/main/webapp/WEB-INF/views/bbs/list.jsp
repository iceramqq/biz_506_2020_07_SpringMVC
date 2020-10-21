<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script>
	document.addEventListener("DOMContentLoaded", function() {
		document.querySelector("#bbs-write").addEventListener("click",
				function() {
					document.location.href = "${rootPath}/bbs/write"
				})
		/*
		tagh와 tag들이 서로 감싸는 관계로 layout이 만들어져 잇을때
		tag들에 click event 핸들링 이 설정되어 있으면
		어떤 특정 tag를 click 해ㅆ을 때 원하지 않는 event가 발생하는 경우가 있다.
		이러한 현상을 이벤ㄴ트 버블링 이라고 한다.ㅣ
		tag box의 가장 중간부분에 있는 
		
		이버블링을 역으로 효과적으로 이용할 수 잇는데
		td를 감싸고 있는 table에 click event
		
		
		이러한 기법을 이벤트 위임이라고 한다.
		
		
		*/
		document.querySelector("table").addEventListener("click", function (event) {
		      let tag_name = event.target.tagName;
		      if (tag_name === "TD") {
		        // 제목
		    	// let seq = event.target.dataset.seq;
		        
		        // td tag가 클릭되엇으면 현재 클릭된 td tag와 가장 인접한
		        // tr를 참조한다.
		        // 클릭된 TD를 기준으로 TR tag에서 seq값 추출
		        let seq = event.target.closest("TR").dataset.seq
		        if(seq){
		        	//alert(seq)
		        	document.location.href = "${rootPath}/bbs/detail/" + seq
		        }
		      }
		});
		
	})
	/*
	$(function() {
		$(".bbs_tr").click(function() {
			let seq = $(this).data("seq")
			document.location.href = "${rootPath}/bbs/detail/" + seq
		})
	})
	*/
</script>
<style>
tr.bbs_tr {
	cursor: pointer;
}

tr.bbs_tr:hover {
	background-color: #ccc;
}
</style>
<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>NO</th>
			<th>작성일자</th>
			<th>작성시각</th>
			<th>작성자</th>
			<th>제목</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${empty BBS_LIST}">
		  <tr><td colspan="6">데이터가 없습니다</td></tr>
		</c:if>
		<c:forEach items="${BBS_LIST}" var="vo" varStatus="i">
		<tr class="bbs_tr" data-seq="${vo.b_seq}">
			<td>${i.count}</td>
			<td>${vo.b_date}</td>
			<td>${vo.b_time}</td>
			<td>${vo.b_writer}</td>
			<td data-seq="${vo.b_seq}" class="bbs-subject">
			${vo.b_subject}
			<img src="${rootPath}/upload/${vo.b_file}" width="50px">
			</td>
			<td>${vo.b_count}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<button id="bbs-write">글쓰기</button>


