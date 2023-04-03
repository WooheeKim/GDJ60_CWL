<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Contents -->
<table class="table table-striped">
	<c:forEach items="${list}" var="DTO">
		<tr>
			<td id="lessonReviewContents${DTO.lessonReviewNum}">
				${DTO.lessonReviewContents}
			</td>
			<td>${DTO.memberId}</td>
			<td id="lessonRating${DTO.lessonReviewNum}">
				<c:if test="${DTO.lessonRating eq 1}">
					★
				</c:if>
				<c:if test="${DTO.lessonRating eq 2}">
					★★
				</c:if>
				<c:if test="${DTO.lessonRating eq 3}">
					★★★
				</c:if>
				<c:if test="${DTO.lessonRating eq 4}">
					★★★★
				</c:if>
				<c:if test="${DTO.lessonRating eq 5}">
					★★★★★
				</c:if>
			</td>
			<td>${DTO.lessonReviewDate}</td>
			<td>
				<c:if test="${member.memberId eq DTO.memberId}">
					<button class="btn btn-info" data-lessonReview-num="${DTO.lessonReviewNum}" data-bs-toggle="modal" data-bs-target="#contentsModal">수정</button>
				</c:if>
			</td>
			<td>
				<c:if test="${member.memberId eq DTO.memberId}">
					<button class="btn btn-danger delete" data-lessonReview-num="${DTO.lessonReviewNum}">삭제</button>
				</c:if>
			</td>
		</tr>
	</c:forEach>
</table>

<!-- Paging -->
<div class="rowmx-auto">
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
		
			<li class="page-item ${pagination.page eq 1?'disabled':''}">
				<a class="page-link" href="./list?page=1&condition=${pagination.condition}&search=${pagination.search}" aria-label="Previous" data-board-page="1">
					<span aria-hidden="true">&laquo;</span>
				</a>
			</li>
			
			<li class="page-item ${pagination.prev?'disabled':''}">
				<a class="page-link" href="./list?page=${pagination.startNum-1}&condition=${pagination.condition}&search=${pagination.search}" aria-label="Previous" data-board-page="${pagination.startNum-1}">
					<span aria-hidden="true">&lsaquo;</span>
				</a>
			</li>
								
			<c:forEach begin="${pagination.startNum}" end="${pagination.lastNum}" var="i">
				<li class="page-item"><a class="page-link" href="./list?page=${i}&condition=${pagination.condition}&search=${pagination.search}" data-board-page="${i}">${i}</a></li>
			</c:forEach>
			
			<li class="page-item ${pagination.next eq false ? 'disabled' : ''}">
				<a class="page-link" href="./list?page=${pagination.lastNum+1}&condition=${pagination.condition}&search=${pagination.search}"  aria-label="Next" data-board-page="${pagination.lastNum+1}">
					<span aria-hidden="true">&rsaquo;</span>
				</a>
				</li>
 				
 			<li class="page-item ${pagination.page eq pagination.totalPage?'disabled' : ''}">
				<a class="page-link" href="./list?page=${pagination.totalPage}&condition=${pagination.condition}&search=${pagination.search}"  aria-label="Next" data-board-page="${pagination.totalPage}">
					<span aria-hidden="true">&raquo;</span>
				</a>
				</li>
				
		</ul>
	</nav>
</div>