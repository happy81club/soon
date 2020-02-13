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
				<c:forEach begin="1" end="10" var="num">
					<button id="btn_${num }" value="${num }" type="button" class="btn btn-primary" style="width: 45px; ">${num }</button>
				</c:forEach>
			</div>
			<div style="margin:15px auto;">
				<c:forEach begin="11" end="20" var="num">
					<button id="btn_${num }" value="${num }" type="button" class="btn btn-primary" style="width: 45px; ">${num }</button>
				</c:forEach>
			</div>
			<div style="margin:15px auto;">
				<c:forEach begin="21" end="30" var="num">
					<button id="btn_${num }" value="${num }" type="button" class="btn btn-primary" style="width: 45px; ">${num }</button>
				</c:forEach>
			</div>
			<div style="margin:15px auto;">
				<c:forEach begin="31" end="40" var="num">
					<button id="btn_${num }" value="${num }" type="button" class="btn btn-primary" style="width: 45px;">${num }</button>
				</c:forEach>
			</div>
			<div style="margin:15px auto;">
				<c:forEach begin="41" end="45" var="num">
					<button id="btn_${num }" value="${num }" type="button" class="btn btn-primary" style="width: 45px;">${num }</button>
				</c:forEach>
			</div>
			
		<div style="margin:20px auto;">
				<button id="creatNumber" type="button" class="btn btn-success pull-left" >번호생성</button>
				<button id="init" type="button" class="btn btn-info" style="margin-left: 10px;">초기화</button>
		</div>
			
			
		</div><!-- left -->
		
		<div class="lottoDiv right" style="margin:15px auto;">
			<div class="col-xs-12" style="margin:15px auto;">
		        <label style="font-size:15px;">선택한 제외번호 리스트</label>
		    </div>
			<div class="exptDiv" style="margin:15px auto;">
			</div>
		</div>
		
		<!-- 생성번호 출력 div -->
		<div id="lottoListDiv">
			<ol start="1"></ol>
		</div>
		
	</div> <!-- lottoDiv -->
	
</div>


	

</section>

<script>
    var selectNumber = new Array;
    
    $(document).ready(function () {
    	
  		$('.btn-primary').on('click', function(e){
  			$('.exptDiv').append('<button value="'+$(this).val()+'" type="button" class="btn backbtn" style="width: 45px; margin : 5px;">'+$(this).val()+'</button>');
  			$(this).attr('disabled', true);
  			$(this).removeClass('btn-primary');
  			$(this).addClass('btn-default');
  			
  			selectNumber.push($(this).val());
  		});
  		
  		$(document).on('click','.backbtn', function(e){
  			
  			$('#btn_'+$(this).val()).attr('disabled',false);
  			$('#btn_'+$(this).val()).removeClass('btn-default');
  			$('#btn_'+$(this).val()).removeClass('backbtn');
  			$('#btn_'+$(this).val()).addClass('btn-primary');
  			
  			$(this).remove();
  			
  			const idx = selectNumber.indexOf($(this).val());
  			if(idx > -1) selectNumber.splice(idx, 1);
  			
  			//console.log(selectNumber);
  			
  		});
		
  		//  생성로또번호 삭제
  		$(document).on('click','.del', function(e){
  			// 부모객체 찾아 삭제
  			$(this).parent().remove();
  		});
  		
  		// 번호생성 버튼
  		$('#creatNumber').click(function(){
  			AjaxCall();
  		});
  		
  		// 초기화
  		$('#init').on('click', function(){
  			$('.backbtn').each(function(){
  	  			$('#btn_'+$(this).val()).attr('disabled',false);
  	  			$('#btn_'+$(this).val()).removeClass('btn-default');
  	  			$('#btn_'+$(this).val()).removeClass('backbtn');
  	  			$('#btn_'+$(this).val()).addClass('btn-primary');
  	  			
  	  			$(this).remove();
  			});
  			
  			selectNumber.splice(0, selectNumber.length);
  		    //console.log(selectNumber);
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
					
				    var preNumber = new Array;
					var numbers = [6, 7, 12, 22, 26, 36, 28];
					
					for(i=0; i<data.lottoNumbers.length; i++){
						const idx = numbers.indexOf(data.lottoNumbers[i]);
						if(idx > -1) preNumber.push(data.lottoNumbers[i]);
					}
					//console.log(preNumber);
					
					var row = "<li> [" + data.lottoNumbers + "]"
					        + " <span class='label label-info del' style='cursor: pointer'>삭제</span>"+ preNumber +"</li>";
					$('#lottoListDiv').find('ol').append(row);
					
				}
			});
	 }
</script>

<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>