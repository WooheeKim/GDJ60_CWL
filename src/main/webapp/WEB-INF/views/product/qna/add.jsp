<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>PRODUCT QNA ADD</title>
	<c:import url="../../template/common_css.jsp"></c:import>
	<link rel="stylesheet" href="/resources/css/common/style.css">
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
	
	<!-- page-title -->
	<section class="page-title bg-cover" data-background="/resources/images/banner/page-title.jpg">
		<div class="container">
			<div class="row">
				<div class="col-12 text-center">
					<h1 class="display-1 text-white font-weight-bold font-primary">Product</h1>
				</div>
			</div>
		</div>
	</section>
</head>
<body>
	<c:import url="../../template/newheader.jsp"></c:import>
	<div class="container-fluid my-5">
		<!-- Contents -->
		<% request.setCharacterEncoding("UTF-8");
	    String productNum = request.getParameter("productNum");
		String memberId = request.getParameter("memberId");
	    %>
		<form action="./add" method="post">
			<input type="hidden" name="memberId" value="<%=memberId%>">
			<input type="hidden" name="productNum" value="<%=productNum%>">
			<div class="row col-8 mx-auto my-5">
				<div class="col-12">
					<label for="productQnATitle" class="form-label fw-bold fs-5">제목</label>
					<input type="text" name="productQnATitle" class="form-control" id="productQnATitle"><br>
				</div>	
				<div class="col-12">
					<label for="productQnAContents" class="form-label fw-bold fs-5">내용</label>
					<textarea name="productQnAContents" class="form-control" id="productQnAContents" rows="3"></textarea><br>
				</div>
				<div class="form-check-block select justify-content-center mx-auto" align="center">
					<input id="open" type="radio" name="productQnASecret" value="0" class="form-check-input">
					<label for="open" class="form-check-label btn btn-outline-primary btn-sm btn-category mx-1">전체 공개</label>
					<input id="secret" type="radio" name="productQnASecret" value="1" class="form-check-input">
					<label for="secret" class="form-check-label btn btn-outline-primary btn-sm btn-category mx-1">비밀글</label>
				</div>
				<div class="row justify-content-center my-5">
					<button type="submit" class="btn btn-primary btn-sm btn-default">작성</button>
				</div>
			</div>
	   </form>
	</div>
	<script>
		$('#productQnAContents').summernote();
	</script>
	<c:import url="../../template/common_js.jsp"></c:import>
	<c:import url="../../template/footer.jsp"></c:import>
	
</body>
</html>