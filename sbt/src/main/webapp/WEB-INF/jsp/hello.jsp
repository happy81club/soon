<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/fromStyle.css">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>">
</head>
<body>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<div class="container">

<div>
     <span style="color: orange;font-size: 25px;"><c:out value="${username}"/></span> 님이 로그인 하였습니다.
	 / <span><a href="/logout">로그아웃</a></span>
</div>

	<table class="table table-condensed">
	<tbody>
		<tr>
			<td><a href="<c:url value="/user/boardList"/>">글목록</a></td>
		</tr>
		<tr>
			<td><a href="<c:url value="/user/boardWriter"/>">글작성</a></td>
		</tr>
	</tbody>
	</table>	
</div>
<script type="text/javascript" src="/js/bootstrap.js"></script>
</body>
</html>