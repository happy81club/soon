<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/include/header.jsp" %>
<%@include file="/WEB-INF/jsp/include/nav.jsp" %>

<section>
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
					<td><c:out value="${board.modificationTime }"/></td>
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
</section>

<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>