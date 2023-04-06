<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Contents -->
<table class="table table-striped">
	<c:forEach items="${list}" var="DTO">
		<tr>
			<td id="productReviewTitle${DTO.productReviewNum}" data-productreview-num="${DTO.productReviewNum}">
				<a class="detail" data-productreview-num="${DTO.productReviewNum}">${DTO.productReviewTitle}</a>
			</td>
			<td>${DTO.memberId}</td>
			<td id="productRating${DTO.productReviewNum}">
				<c:if test="${DTO.productRating eq 1}">
					★
				</c:if>
				<c:if test="${DTO.productRating eq 2}">
					★★
				</c:if>
				<c:if test="${DTO.productRating eq 3}">
					★★★
				</c:if>
				<c:if test="${DTO.productRating eq 4}">
					★★★★
				</c:if>
				<c:if test="${DTO.productRating eq 5}">
					★★★★★
				</c:if>
			</td>
			<td>${DTO.productReviewDate}</td>
			<td>
				<c:if test="${member.memberId eq DTO.memberId}">
					<a href="./review/update?productReviewNum=${DTO.productReviewNum}&productNum=${DTO.productNum}" class="btn btn-info" data-productreview-num="${DTO.productReviewNum}">수정</a>
				</c:if>
			</td>
			<td>
				<c:if test="${member.memberId eq DTO.memberId}">
					<button class="btn btn-danger delete" data-productreview-num="${DTO.productReviewNum}">삭제</button>
				</c:if>
			</td>
		</tr>
		<tr>
			<td id="productReviewContents${DTO.productReviewNum}" style="display:none;">
				<div class="row">
 					<c:if test="${not empty DTO.productReviewImgDTOs}">
						<c:forEach items="${DTO.productReviewImgDTOs}" var="imgDTO">
							<img alt="" src="/resources/upload/product/review/${imgDTO.imgName}">
						</c:forEach>
 					</c:if>
				</div>
				<div class="row">
					<!-- <img alt="" src="/resources/upload/product/review/95da24e6-8c73-4a22-9fc5-a7d277f02249_2.jpg">
					<img alt="" src="/resources/images/1.jpg"> -->
				</div>
				${DTO.productReviewContents}
			</td>
		</tr>
	</c:forEach>
</table>

<!-- Paging -->
<div class="m-auto">
	<div class="pagination justify-content-center mt-5 pt-4">
		<ul class="list-inline">
			<li class="list-inline-item ${pagination.page eq 1?'disabled':''}">
				<a href="#" class="page-button-review" aria-label="Previous" data-board-page="1">
					<span aria-hidden="true">&laquo;</span>
				</a>
			</li>
			<li class="list-inline-item ${pagination.prev?'disabled':''}">
				<a href="#" class="page-button-review" aria-label="Previous" data-board-page="${pagination.startNum}">
					<span aria-hidden="true">&lsaquo;</span>
				</a>
			</li>				
			<c:forEach begin="${pagination.startNum}" end="${pagination.lastNum}" var="page">
				<li class="list-inline-item"><a href="#" class="page-button-review" data-board-page="${page}">${page}</a></li>
			</c:forEach>
			<li class="list-inline-item ${pagination.next eq false ? 'disabled' : ''}">
				<a href="#" class="page-button-review" aria-label="Next" data-board-page="${pagination.lastNum}">
					<span aria-hidden="true">&rsaquo;</span>
				</a>
			 </li>
			 <li class="list-inline-item ${pagination.page eq pagination.totalPage?'disabled' : ''}">
				<a href="#" class="page-button-review" aria-label="Next" data-board-page="${pagination.totalPage}">
					<span aria-hidden="true">&raquo;</span>
				</a>
			</li>
		</ul>	
	</div>
</div>