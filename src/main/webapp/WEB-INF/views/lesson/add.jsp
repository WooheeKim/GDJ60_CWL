<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ADD</title>
	<c:import url="../template/common_css.jsp"></c:import>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container-fluid my-5">
		<!-- Contents -->
		<form action="./add" method="post" enctype="multipart/form-data">
			<div class="row col-md-4 mx-auto my-5">
				<div class="fw-bold fs-5 col-12">
					<label for="memberId" class="form-label">작성자</label>
					<input type="text" name="memberId" class="form-control" id="memberId" value="${DTO.memberId}" readonly><br>
				</div>
				<div class="fw-bold fs-5 col-12">
					<label for="lessonTitle" class="form-label">제목</label>
					<input type="text" name="lessonTitle" class="form-control" id="lessonTitle"><br>
				</div>			
				<div class="fw-bold fs-5 col-12">
					<label for="lessonContents" class="form-label">내용</label>
					<textarea name="lessonContents" class="form-control" id="lessonContents" rows="3"></textarea><br>
				</div>	
				<div class="row justify-content-center my-5">
					<button type="submit" class="btn btn-primary col-2">글쓰기</button>
				</div>
			</div>
	   </form>
	</div>
	<script>
		$('#lessonContents').summernote();
	</script>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>