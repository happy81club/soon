<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/include/header.jsp" %>
<%@include file="/WEB-INF/jsp/include/nav.jsp" %>

 <style>
 div.lottoDiv {
     width: 100%;
     height: 100%;
     /*border: 1px solid #000;*/
 }
 div.lottoDiv.left {
     width: 50%;
     float: left;
     box-sizing: border-box;
 }
 div.lottoDiv.right {
     width: 50%;
     float: right;
     box-sizing: border-box;
     
 }

 </style>

<section>

<div class="container">

	<div class="col-xs-12" style="margin:15px auto;">
        <label style="font-size:20px;">로또</label>
    </div>
	
	<div style="margin:50px auto;">
		<span class="label label-default">Default</span>
		<span class="label label-primary">Primary</span>
		<span class="label label-success">Success</span>
		<span class="label label-info">Info</span>
		<span class="label label-warning">Warning</span>
		<span class="label label-danger">Danger</span>
	</div>
	
	
	<!-- 로또 번호선택 -->
	<div id="lottoDiv">
		
		<div class="lottoDiv left">
			<div class="col-xs-12" style="margin:15px auto;">
		        <label style="font-size:15px;">제외 번호 선택</label>
		    </div>
			<div style="margin:15px auto;">
				<c:forEach begin="1" end="9" var="num">
					<button value="${num }" type="button" class="btn btn-primary" style="width: 45px; ">${num }</button>
				</c:forEach>
			</div>
			<div style="margin:15px auto;">
				<c:forEach begin="10" end="18" var="num">
					<button value="${num }" type="button" class="btn btn-primary" style="width: 45px; ">${num }</button>
				</c:forEach>
			</div>
			<div style="margin:15px auto;">
				<c:forEach begin="19" end="27" var="num">
					<button value="${num }" type="button" class="btn btn-primary" style="width: 45px; ">${num }</button>
				</c:forEach>
			</div>
			<div style="margin:15px auto;">
				<c:forEach begin="28" end="36" var="num">
					<button value="${num }" type="button" class="btn btn-primary" style="width: 45px; ">${num }</button>
				</c:forEach>
			</div>
			<div style="margin:15px auto;">
				<c:forEach begin="37" end="45" var="num">
					<button value="${num }" type="button" class="btn btn-primary" style="width: 45px;">${num }</button>
				</c:forEach>
			</div>
			
			<button id="creatNumber" type="button" class="btn btn-success pull-left" >번호생성</button>
			
		</div><!-- left -->
		
		<div class="lottoDiv right" style="margin:15px auto;">
			<div class="col-xs-12" style="margin:15px auto;">
		        <label style="font-size:15px;">선택한 제외번호 리스트</label>
		    </div>
			<div class="exptDiv" style="margin:15px auto;">
			</div>
		</div>
	</div> <!-- lottoDiv -->
	
</div>


	

</section>

<script>
    var selectNumber = new Array;
    
    $(document).ready(function () {
    	
    	$.ajaxSetup({
    		headers :  { 'X-CSRF-TOKEN': $('meta[name="_csrf_token"]').attr('content') },
    		crossDomain: true,
    		beforeSend : function(request){
    		},
    		complete : function(response){
    		},
    		error : function(data, status, xhr) {
    			console.log(data);
    			alert('네트워크 통신이 불안정하거나 시스템에 장애가 있습니다.');
    		}
    	});
    	
    	
  		$('.btn-primary').click(function(e){
  			$('.exptDiv').append('<button value="'+$(this).val()+'" type="button" class="btn" style="width: 45px; background-color: yellow; margin : 5px;">'+$(this).val()+'</button>');
  			$(this).attr('disabled', true);
  			$(this).removeClass('btn-primary');
  			$(this).addClass('btn-default');
  			
  			selectNumber.push($(this).val());
  		});
  		
  		// 번호생성 버튼
  		$('#creatNumber').click(function(){
  			AjaxCall();
  		});
  		

		});

    function AjaxCall() {
    	var data = 'lottoNumbers=' + selectNumber;
		$.ajax({
				type     : "POST",
				url      : "/lotto/createLotto",
				data     : data,
				dataType : "json",
				success  : function(data, status, xhr) {
					console.log(data);
				}
			});
	 }
</script>

<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>