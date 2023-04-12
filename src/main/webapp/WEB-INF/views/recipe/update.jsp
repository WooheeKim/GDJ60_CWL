<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>LESSON UPDATE</title>
	<%@ include file="../common/sessionCheck.jsp" %>
	<c:import url="../template/common_css.jsp"></c:import>
	<link rel="stylesheet" href="/resources/css/common/style.css">
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container-fluid my-5">
		<!-- Title -->
		<div class="row mx-auto text-center border-bottom border-dark pb-2">
			<p class="fs-2" style="font-family: 'Impact'">RECIPE</p>
		</div>
		<!-- Contents -->
		<form action="./update" method="post" enctype="multipart/form-data" id="frm">
			<input type="hidden" name="memberId" value="${member.memberId}">
			<input type="hidden" name="recipeNum" value="${DTO.recipeNum}">
			<div class="row col-8 mx-auto my-5">
				<div class="col-12">
					<label for="recipeTitle" class="form-label fw-bold fs-5">칵테일 이름</label>
					<input type="text" name="recipeTitle" class="form-control" id="recipeTitle" value="${DTO.recipeTitle}"><br>
				</div>
				<div class="col-12 my-4">
					<h5 class="fw-bold fs-5"><b>베이스</b></h5>
					<div class="form-check form-check-block select">
						<input id="tequila" type="radio" name="recipeBase" value="Tequila" class="form-check-input" ${DTO.recipeBase eq 'Tequila' ? 'checked' :''}>
						<label for="tequila" class="form-check-label btn btn-outline-primary btn-sm btn-category mx-1">데킬라 베이스</label>
						<input id="rum" type="radio" name="recipeBase" value="Rum" class="form-check-input" ${DTO.recipeBase eq 'Rum' ? 'checked' :''}>
						<label for="rum" class="form-check-label btn btn-outline-primary btn-sm btn-category mx-1">럼 베이스</label>
						<input id="brandy" type="radio" name="recipeBase" value="Brandy" class="form-check-input" ${DTO.recipeBase eq 'Brandy' ? 'checked' :''}>
						<label for="brandy" class="form-check-label btn btn-outline-primary btn-sm btn-category mx-1">브랜디 베이스</label>
						<input id="vodka" type="radio" name="recipeBase" value="Vodka" class="form-check-input" ${DTO.recipeBase eq 'Vodka' ? 'checked' :''}>
						<label for="vodka" class="form-check-label btn btn-outline-primary btn-sm btn-category mx-1">보드카 베이스</label>
						<input id="gin" type="radio" name="recipeBase" value="Gin" class="form-check-input" ${DTO.recipeBase eq 'Gin' ? 'checked' :''}>
						<label for="gin" class="form-check-label btn btn-outline-primary btn-sm btn-category mx-1">진 베이스</label>
					</div>
					<div class="form-check form-check-block select">
						<input id="whisky" type="radio" name="recipeBase" value="Whisky" class="form-check-input" ${DTO.recipeBase eq 'Whisky' ? 'checked' :''}>
						<label for="whisky" class="form-check-label btn btn-outline-primary btn-sm btn-category mx-1">위스키 베이스</label>
						<input id="beer" type="radio" name="recipeBase" value="Beer" class="form-check-input" ${DTO.recipeBase eq 'Beer' ? 'checked' :''}>
						<label for="beer" class="form-check-label btn btn-outline-primary btn-sm btn-category mx-1">맥주 베이스</label>
						<input id="wine" type="radio" name="recipeBase" value="Wine" class="form-check-input" ${DTO.recipeBase eq 'Wine' ? 'checked' :''}>
						<label for="wine" class="form-check-label btn btn-outline-primary btn-sm btn-category mx-1">포도주 베이스</label>
						<input id="liqueur" type="radio" name="recipeBase" value="Liqueur" class="form-check-input" ${DTO.recipeBase eq 'Liqueur' ? 'checked' :''}>
						<label for="liqueur" class="form-check-label btn btn-outline-primary btn-sm btn-category mx-1">리큐르 베이스</label>
						<input id="non-alcoholic" type="radio" name="recipeBase" value="Non-Alcoholic" class="form-check-input" ${DTO.recipeBase eq 'Non-Alcoholic' ? 'checked' :''}>
						<label for="non-alcoholic" class="form-check-label btn btn-outline-primary btn-sm btn-category mx-1">논 알콜 칵테일</label>
					</div>
				</div>
				<div class="col-12 mx-auto mt-4">
					<label for="recipeIngredients" class="form-label fw-bold fs-5">재료</label>
					<textarea name="recipeIngredients" class="form-control" id="recipeIngredients" rows="3">${DTO.recipeIngredients}</textarea><br>
				</div>
				<div class="col-12 mx-auto mt-4">
					<label for="recipeContents" class="form-label fw-bold fs-5">개요</label>
					<textarea name="recipeContents" class="form-control" id="recipeContents" rows="3">${DTO.recipeContents}</textarea><br>
				</div>
				<div id="imgList" class="col-12 mx-auto mt-3">
					<h5 class="fw-bold fs-5"><b>썸네일</b></h5>
					<div class="input-group mt-3">
						<input type="file" class="form-control img" name="img" id="img">
					</div>
				</div>
				<div class="row justify-content-center my-5">
					<button type="button" id="recipeConfirm" class="btn btn-primary btn-sm btn-default">등록</button>
				</div>
			</div>
	   </form>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
	<c:import url="../template/footer.jsp"></c:import>
	<script src="/resources/js/common/confirm.js"></script>
	<script>
		$('#recipeIngredients').summernote();
		$('#recipeContents').summernote();
	</script>
</body>
</html>