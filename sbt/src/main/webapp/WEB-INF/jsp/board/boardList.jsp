<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>">
</head>
<body>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>	

<div class="container">
	<table class="table table-striped">
	<thead>
	    <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>날짜</th>
	        <th>조회수</th>
	    </tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td>
			<td>부트스트랩 예제입니다.</td>
			<td>쑤니</td>
			<td>2020.01.24</td>
			<td>1</td>
		</tr>
		<tr>
			<td>2</td>
			<td>부트스트랩 예제입니다.</td>
			<td>쑤니</td>
			<td>2020.01.24</td>
			<td>1</td>
		</tr>
		<tr>
			<td>3</td>
			<td>부트스트랩 예제입니다.</td>
			<td>쑤니</td>
			<td>2020.01.24</td>
			<td>1</td>
		</tr>
	</tbody>
	</table>	

	<hr/>
	<a href="<c:url value="/user/boardWriter"/>" class="btn btn-default pull-right">글쓰기</a>
	
	<div class="text-center">
		<ul class="pagination">
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
		</ul>
	</div>

</div>	

<script type="text/javascript" src="/js/bootstrap.js"></script>	
</body>
</html>