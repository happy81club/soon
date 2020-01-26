<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>">
<link rel="stylesheet" href="<c:url value="/css/boardStyle.css"/>">
</head>
<body>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>	

<div class="container">
	<div class="row">
		<div class="col-12">
			
			<form:form id="modifyForm" name="modifyForm" modelAttribute="board" action="/user/procModify" method="post">
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
					<td>
					<form:input path="title" class="form-control" type="text" placeholder="제목을 입력해주세요"/></td>
				</tr>
				<tr>
					<th>등록일</th>
					<td><c:out value="${board.registrationTime}"/></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><c:out value="${board.writer}"/></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><form:textarea path="content" class="form-control col-sm-5" rows="5" placeholder="내용을 입력해주세요"></form:textarea></td>
				</tr>
			</tbody>
			</table>	
			</form:form>
		
			<hr/>
			
			<button id="btnList"   type="button" class="btn pull-right">목록</button>
			<button id="btnModify" type="button" class="btn btn-primary pull-right">수정</button>
		
		</div><!-- class="col-12" -->
	</div><!-- class="row" -->
	
</div>	

<script type="text/javascript" src="/js/bootstrap.js"></script>	
<script>
	$(document).ready(function(){
		// 글목록
		$('#btnList').click(function(){
			window.location.href="<c:url value='boardList' />"; // /user/boardList
		});
		// 수정
		$('#btnSave').click(function(){
			$('#writeForm').submit();
		});
	});
</script>

</body>
</html>