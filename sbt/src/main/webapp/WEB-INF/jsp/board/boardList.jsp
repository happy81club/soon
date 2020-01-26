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
	    </tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${list eq null }"></c:when>
			<c:otherwise>
			<c:forEach var="board"  items="${list}" varStatus="status">
				<tr>
					<td><c:out value="${status.count}"/></td>
					<td><a href="<c:url value="boardView?articleNumber=${board.articleNumber }"/>"><c:out value="${board.title }"/></a></td>
					<td><c:out value="${board.writer }"/></td>
					<td><c:out value="${board.registrationTime }"/></td>
				</tr>
			</c:forEach>
			</c:otherwise>
		</c:choose>
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