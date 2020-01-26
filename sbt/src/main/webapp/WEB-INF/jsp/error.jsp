<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error page</title>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>">
</head>
<body>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>	

<div class="container">
	
	<table class="table table-striped">
	<thead>
	    <tr>
	        <th>ERROR PAGE!!!</th>
	    </tr>
	</thead>
	<tbody>
		<tr>
			<td><c:out value="${errMsg }"/></td>
		</tr>
	</tbody>
	</table>	


</div>	

<script type="text/javascript" src="/js/bootstrap.js"></script>	
</body>
</html>