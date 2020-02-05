<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/include/header.jsp" %>
<%@include file="/WEB-INF/jsp/include/nav.jsp" %>

<section>

<div class="container">
	<div class="row">
		
		<div class="col-xs-12" style="margin:15px auto;">
	        <label style="font-size:20px;"><span class="glyphicon glyphicon-list-alt"></span>게시글 상세</label>
	    </div>
	
		<div class="col-12">
		
		<table class="table table-striped">
		<thead>
		    <tr>
		        <th></th>
		        <th></th>
		    </tr>
		</thead>
		<tbody>
			<tr>
				<th style="width: 20%">제목</th>
				<td><c:out value="${view.title}"/></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><c:out value="${view.writer}"/></td>
			</tr>
			<tr>
				<th>등록일</th>
				<td><c:out value="${view.registrationTime}"/></td>
			</tr>
 			<tr>
				<th>내용(pre tag)</th>
				<td><pre style="white-space:pre-line;"><c:out value="${view.content}"/></pre></td>
			</tr> 
		</tbody>
		</table>	
		
		<hr/>
		
		<button id="btnList" type="button"   class="btn pull-right">목록</button>
		<button id="btnDelete" type="button" class="btn btn-info pull-right">삭제</button>
		<button id="btnModify" type="button" class="btn btn-primary pull-right">수정</button>
		
		</div><!-- class="col-12" -->
	</div><!-- class="row" -->
</div><!-- class="container" -->

<div class="container">
     <label for="content">comment</label>
     <form:form id="commentForm" name="commentForm" modelAttribute="board" action="procComment" method="post">
			<form:hidden path="articleNumber" id="articleNumber"/>
			<form:hidden path="groupNumber"/>
			<form:hidden path="groupOrder"/>
			<form:hidden path="groupHierarchy"/>
			<form:hidden path="title"/>
         <div class="input-group">
            <form:input path="content" class="form-control" id="content" placeholder="내용을 입력하세요."/>
            <span class="input-group-btn">
                  <button id="commentInsertBtn" class="btn pull-right" type="button" name="commentInsertBtn">등록</button>
            </span>
         </div>
     </form:form>
 </div>
 
 <br/>
 
 <!-- 댓글 리스트 영역 -->
 <div class="container">
	<div class="row">
	<table class="table table-striped">
	<tbody>
		<c:choose>
			<c:when test="${cmmntList eq null }"></c:when>
			<c:otherwise>
			<c:forEach var="commnt"  items="${cmmntList}" varStatus="status">
				<tr>
					<td><c:out value="${commnt.content }"/></td>
				</tr>
			</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
	</table>	
	</div>
 </div>
 
 
 
</section>


<script type="text/javascript" src="/js/bootstrap.js"></script>	
<script>
	$(document).ready(function(){
		// 글목록
		$('#btnList').click(function(){
			window.location.href="<c:url value='boardList' />"; // /user/boardList
		});
		// 수정View 이동
		$('#btnModify').click(function() {
			var articleNumber = $('#articleNumber').val();
			window.location.href="<c:url value='boardModifiy?articleNumber='/>" + articleNumber;
		});
		// 삭제
		$('#btnDelete').click(function(){
			var articleNumber = $('#articleNumber').val();
			if(confirm("삭제하시겠습니까?")) {
				//window.location.href = "procDelete?articleNumber=" + articleNumber;
				window.location.href = "<c:url value='procDelete?articleNumber='/>" + articleNumber;
			}
		});
		
		// 댓글등록
		$('#commentInsertBtn').on('click', function(){
			if("" == $('#content').val().trim()) {
				alert("댓글을 입력 후 등록바랍니다.");
				return;
			}else{
				$('#commentForm').submit();
			}
			
		});
	});
</script>

<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>