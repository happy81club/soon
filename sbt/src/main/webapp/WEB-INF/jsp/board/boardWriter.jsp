<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<td><input class="form-control" type="text" placeholder="제목을 입력해주세요"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>user</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea class="form-control col-sm-5" rows="5" placeholder="내용을 입력해주세요"></textarea></td>
		</tr>
	</tbody>
	</table>	

	<hr/>
</div>
	
	<div class="row">
		<div class="" >
			<a href="<c:url value="/user/boardList"/>" class="btn btn-default pull-right" >목록</a>
		</div>
		<div class="" >
			<a href="<c:url value="#"/>" class="btn btn-primary pull-right" >저장</a>
		</div>
	</div>
	

</div>	

<script type="text/javascript" src="/js/bootstrap.js"></script>	
</body>
</html>