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
					<td><c:out value="${board.rownum}"/></td>
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


	
<%--페이징영역--%>
<div class="box-footer">

<div class="text-center">
    <ul class="pagination">

	<%--========================JavaScript를 이용한 페이징 링크 처리========================--%>

	<%--prev가 true 일 경우--%>
	<c:if test="${pageMaker.prev}">
	    <%--javascript 사용--%>
	    <li><a href="${pageMaker.startPage - 1}">&laquo;</a></li>
	</c:if>

	<%--시작 페이지 ~ 마지막 페이지까지 반복--%>
	<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
	    <%--현재 목록 페이지가 idx와 일치하면 현재페이지 표시--%>
	    <li <c:out value="${pageMaker.criteria.page == idx? 'class=active':''}"/>>
		<%--javascript 사용--%>
		<a href="${idx}">${idx}</a>
	    </li>

	</c:forEach>

	<%--next가 true이고 endPage가 0이상일 경우--%>
	<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
	    <%--javascript 사용--%>
	    <li><a href="${pageMaker.endPage +1}">&raquo;</a></li>
	</c:if>

    </ul>
</div>

</div>

    <%--javascript를 이용한 페이징 링크처리 form 태그--%>
    <form id="linkForm">
        <input type="hidden" name="page" value="${pageMaker.criteria.page}">
        <input type="hidden" name="perPageNum" value="${pageMaker.criteria.perPageNum}">
    </form>


</div>	
</section>

<script>
    $(document).ready(function () {
        // javascript를 이용한 페이징 링크처리
        $(".pagination li a").on("click", function (event) {
            // 기본 이벤트 X
            event.preventDefault();
            // 이동할 페이지 선택자
            var targetPage = $(this).attr("href");
            // form 태그 선택자
            var linkForm = $("#linkForm");
            // value 값을 이동할 페이지로 저장
            linkForm.find("[name='page']").val(targetPage);
            // form 태그 속성 추가
            linkForm.attr("action", "/user/boardList").attr("method", "get");
            linkForm.submit();
        });
  
    });
</script>

<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>