<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
	
<link rel="stylesheet" href="css/fromStyle.css">
</head>
<body>

	<div class="inner_login">
		<div class="login_tistory">

			<form method="post" id="authForm" action="/loginProcess">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<fieldset>
					<legend class="screen_out">로그인 정보 입력폼</legend>
					<div class="box_login">
						<div class="inp_text">
							<label for="username" class="screen_out">아이디</label> <input
								type="text" id="username" name="username" placeholder="ID">
						</div>
						<div class="inp_text">
							<label for="password" class="screen_out">비밀번호</label> <input
								type="password" id="password" name="password"
								placeholder="Password">
						</div>
					</div>
					
					<button type="submit" class="btn_login" >로그인</button>
					
					<div class="login_append">
						<div class="inp_chk">
							<!-- 체크시 checked 추가 -->
							<input type="checkbox" id="keepLogin" class="inp_radio"
								name="keepLogin"> <label for="keepLogin" class="lab_g">
								<span class="img_top ico_check"></span> <span class="txt_lab">로그인
									상태 유지</span>
							</label>
						</div>
						<span class="txt_find"> <a href="/member/find/username"
							class="link_find">아이디</a> / <a href="/member/find/password"
							class="link_find">비밀번호 찾기</a>
						</span>
					</div>

				</fieldset>
			</form>

		</div>
	</div>

</body>
</html>