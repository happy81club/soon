<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/include/header.jsp" %>
<%@include file="/WEB-INF/jsp/include/nav.jsp" %>

<section>

<div class="container">

	<div class="col-xs-12" style="margin:15px auto;">
        <label style="font-size:20px;"><span class="glyphicon glyphicon-list-alt"></span>게시글 수정</label>
    </div>


	<div class="row">
		<div class="col-12">
			
			<form:form id="modifyForm" name="modifyForm" modelAttribute="board" action="/user/procModifiy" method="post">
			<form:hidden path="articleNumber"/>
			<form:hidden path="groupNumber"/>
			<form:hidden path="groupOrder"/>
			<form:hidden path="groupHierarchy"/>
			
			<table class="table table-striped">
			<thead>
			    <tr>
			        <th></th>
			        <th></th>
			    </tr>
			</thead>
			<tbody>
				<tr>
					<th style="width: 20%">제목</th>
					<td>
					<form:input path="title" class="form-control" type="text" placeholder="제목을 입력해주세요"/></td>
				</tr>
				<tr>
					<th>등록일</th>
					<td><c:out value="${board.registrationTime}"/></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><c:out value="${board.writer}"/></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><form:textarea path="content" class="form-control col-sm-5" rows="5" placeholder="내용을 입력해주세요"></form:textarea></td>
				</tr>
			</tbody>
			</table>	
			</form:form>
		
			<hr/>
			
			<button id="btnList"   type="button" class="btn pull-right">목록</button>
			<button id="btnModify" type="button" class="btn btn-primary pull-right">수정</button>
		
		</div><!-- class="col-12" -->
	</div><!-- class="row" -->
	
</div>	

<script type="text/javascript" src="/js/bootstrap.js"></script>	
<script>
	$(document).ready(function(){
		// 글목록
		$('#btnList').click(function(){
			window.location.href="<c:url value='boardList' />"; // /user/boardList
		});
		// 수정
		$('#btnModify').click(function(){
			if(confirm("수정하시겠습니까?")) {
				$('#modifyForm').submit();
			}
		});
	});
</script>

</section>

<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>