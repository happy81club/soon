<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/include/header.jsp" %>
<%@include file="/WEB-INF/jsp/include/nav.jsp" %>

<section>

<div class="container">
<div class="row">
	
	<form:form id="writeForm" name="writeForm" modelAttribute="board" action="/user/procWriter" method="post">
	<table class="table table-striped">
	<thead>
	    <tr>
	        <th></th>
	        <th></th>
	    </tr>
	</thead>
	<tbody>
		<tr>
			<th>제목</th>
			<td>
			<form:input path="title" class="form-control" type="text" placeholder="제목을 입력해주세요"/></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><c:out value="${user.username}"/> </td>
		</tr>
		<tr>
			<th>내용</th>
			<td><form:textarea path="content" class="form-control col-sm-5" rows="5" placeholder="내용을 입력해주세요"></form:textarea></td>
		</tr>
	</tbody>
	</table>	
	</form:form>

	<hr/>
</div>
	
	<div class="row">
		<div class="col-12">
			<button id="btnList" type="button" class="btn pull-right">목록</button>
			<button id="btnSave" type="button" class="btn btn-primary pull-right">저장</button>
		</div>
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
		// 저장
		$('#btnSave').click(function(){
			$('#writeForm').submit();
		});
	});
</script>

<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>