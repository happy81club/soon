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

<hr/>
<div>
     <span style="color: orange;font-size: 25px;"><c:out value="${user.username}"/></span> 님이 로그인 하였습니다.
	 / <span><a href="/logout">로그아웃</a></span>
</div>
<hr/>

<div class="row">
	<div class="col-sm-6">
		<table class="table table-condensed">
		<tbody>
			<tr><td><a href="<c:url value="/user/boardList"/>">게시판 예제</a></td></tr>
			<tr><td><a href="<c:url value="/user/boardSample"/>">샘플</a></td></tr>
		</tbody>
		</table>	
	</div>
</div><!-- row end -->

<hr/>
<pre>
	■ TO-DO List	
	1. 게시판 - 댓글 처리, 삭제(완료), 수정(완료)
	2. 페이징 처리
	3. 트랜잭션 처리 Exception 처리
</pre>

	
</div>
<script type="text/javascript" src="/js/bootstrap.js"></script>
</body>
</html>