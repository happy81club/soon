<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/fromStyle.css">
</head>
<body>

<div class="login_append">
	<span><a href="/logout">로그아웃</a></span>
</div>

<div class="inner_login">
	  <span style="color: orange;font-size: 25px;"><c:out value="${username}"/></span> 님이 로그인 하였습니다.
</div>


</body>
</html>