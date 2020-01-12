<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
</head>
<body>
<h2>home.jsp</h2>
<hr>

<div>message: ${message }</div>
<hr>

<a href="<c:url value="/login"/>">login</a><br>

</body>
</html>