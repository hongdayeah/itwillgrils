<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>

<!-- 본문 시작 test -- screateForm.jsp -->
<!--breadcrumbs start-->
<div class="breadcrumbs">
	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-sm-4">
				<h1>
					우리센터 프로그램을 소개합니다
				</h1>
			</div>
			<div class="col-lg-8 col-sm-8">
				<ol class="breadcrumb pull-right">
					<li>
						<a href="../home.do">
							Home
						</a>
					</li>
					<li>
						<a href="slist.do">
							테스트[1부]
						</a>
					</li>
					<li class="">
						테스트 관리
					</li>
				</ol>
			</div>
		</div>
	</div>
</div>
<!--breadcrumbs end-->

<!--container start-->
<div class="registration-bgtest">
	<div class="container">
		<form class="form-signintest wow fadeInUp" method="POST" action="screate.do">
			<h2 class="form-signin-headingtest">[1부] 질문 추가</h2>
			<div class="login-wraptest">
				<input type="text" class="form-control" name="stest_name" id="stest_name" placeholder="질문추가" autofocus>
				<button class="btn btn-lg btn-login btn-block" type="submit">추가하기</button>
			</div>
		</form>
	</div>
</div>
<!--container end-->

<!-- 본문 끝 -->
        
<%@ include file="../footer.jsp" %>
