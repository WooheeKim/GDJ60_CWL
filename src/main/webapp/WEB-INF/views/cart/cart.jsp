<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/cart.css">
</head>
<body>
<div class="wrapper">
	<div class="wrap">
		<div class="top_gnb_area">
			<ul class="list">
				<c:if test = "${member == null}">	<!-- 로그인 x -->	
					<li >
						<a href="/member/memberLogin">로그인</a>
					</li>
					<li>
						<a href="/member/memberAdd">회원가입</a>
					</li>
				</c:if>
				<c:if test="${member != null }">	<!-- 로그인 o -->		
					<c:if test="${member.adminCheck == 1 }"> <!-- 관리자 계정 -->
						<li><a href="/admin/main">관리자 페이지</a></li>
					</c:if>	
					<li>
						<a href="/member/memberLogout.do">로그아웃</a>
					</li>
					<li>
						<a href="/member/memberPage">마이룸</a>
					</li>
					<li>
						<a href="/cart/${member.memberId}">장바구니</a>
					</li>
				</c:if>
			</ul>			
		</div>
		
		<div class="top_area"></div>
		
		<div class="content_area">
		<div class="content_subject"><span>장바구니</span></div>
		<!-- 장바구니 리스트 -->
		<div class="content_middle_section"></div>
		<!-- 장바구니 가격 합계 -->
		<!-- cartInfo -->
		<div class="content_totalCount_section">
			
			<!-- 체크박스 전체 여부 -->
			<div class="all_check_input_div">
				<input type="checkbox" class="all_check_input input_size_20" checked="checked" id="checkAll" name="checkAll" value="1"><span class="all_chcek_span">전체선택</span>				
			</div>				
			
			<table class="subject_table">
				<caption>표 제목 부분</caption>
				<tbody>
	
					<tr>
						<th class="td_width_1"></th>
						<th class="td_width_2"></th>
						<th class="td_width_3">상품명</th>
						<th class="td_width_4">가격</th>
						<th class="td_width_4">수량</th>
						<th class="td_width_4">합계</th>
						<th class="td_width_4">삭제</th>
					</tr>
				</tbody>
			</table>
			<table class="cart_table">
				<caption>표 내용 부분</caption>
				<tbody>
					<c:forEach items="${cartInfo}" var="ci">
						<tr>
							<td class="td_width_1 cart_info_td">
								<input type="checkbox" class="individual_cart_checkbox input_size_20" checked="checked" name="check" value="1">								
								<input type="hidden" class="individual_productPrice_input" value="${ci.productPrice}">
								<input type="hidden" class="individual_orderStock_input" value="${ci.orderStock}">
								<input type="hidden" class="individual_totalPrice_input" value="${ci.productPrice * ci.orderStock}">
								<input type="hidden" class="individual_productNum_input" value="${ci.productNum}">								
							</td>
							<td class="td_width_2">
								<div class="image_wrap" data-productImgNum="${ci.imageList[0].productImgNum}" data-productNum="${ci.imageList[0].productNum}" data-imgName="${ci.imageList[0].imgName}" data-originalName="${ci.imageList[0].originalName}">
									<img alt="" src="">
								</div>
								
							</td>
							<td class="td_width_3">${ci.productName}</td>
							<td class="td_width_4 price_td">
								정가 : <fmt:formatNumber value="${ci.productPrice}" pattern="#,### 원" /><br>
							</td>
							<td class="td_width_4 table_text_align_center">
								<div class="table_text_align_center quantity_div">
									<input type="text" value="${ci.orderStock}" class="quantity_input">	
									<button class="quantity_btn plus_btn">+</button>
									<button class="quantity_btn minus_btn">-</button>
								</div>
								<a class="quantity_modify_btn" data-cartNum="${ci.cartNum}">변경</a>
							</td>
							<td class="td_width_4 table_text_align_center">
								<fmt:formatNumber value="${ci.productPrice * ci.orderStock}" pattern="#,### 원" />
							</td>
							<td class="td_width_4 table_text_align_center">
								<button class="delete_btn" data-cartNum="${ci.cartNum}">삭제</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<table class="list_table">
			</table>
		</div>
		<!-- 가격 종합 -->
		<div class="content_total_section">
			<div class="total_wrap">
				<table>
					<tr>
						<td>
							<table>
								<tr>
									<td>총 상품 가격</td>
									<td>
										<span class="totalPrice_span">70000</span> 원
									</td>
								</tr>
								<tr>
									<td>배송비</td>
									<td>
										<span class="orderFee_price">3000</span>원
									</td>
								</tr>									
								<tr>
									<td>총 주문 상품수</td>
									<td><span class="totalKind_span"></span>Type <span class="totalCount_span"></span>EA</td>
								</tr>
							</table>
						</td>
						<td>
							<table>
								<tr>
									<td></td>
									<td></td>
								</tr>
							</table>							
						</td>
					</tr>
				</table>
				<div class="boundary_div">구분선</div>
				<table>
					<tr>
						<td>
							<table>
								<tbody>
									<tr>
										<td>
											<strong>총 결제 예상 금액</strong>
										</td>
										<td>
											<span class="finalTotalPrice_span">70000</span> 원
										</td>
									</tr>
								</tbody>
							</table>
						</td>						
					</tr>
				</table>
			</div>
		</div>
		<!-- 구매 버튼 영역 -->
		<div class="content_btn_section">
			<a class="order_btn">주문하기</a>
		</div>
		
		<!-- 수량 조정 form -->
		<form action="./cartUpdate" method="post" class	="quantity_update_form">
			<input type="hidden" name="cartNum" class="update_cartNum">
			<input type="hidden" name="orderStock" class="update_orderStock">
			<input type="hidden" name="memberId" value="${member.memberId}">
		</form>	
		
		<!-- 삭제 form -->
		<form action="./cartDelete" method="post" class="quantity_delete_form">
			<input type="hidden" name="cartNum" class="delete_cartNum">
			<input type="hidden" name="memberId" value="${member.memberId}">
		</form>		
		<!-- 주문 form -->
		<form action="/order/${member.memberId}" method="get" class="order_form">
		</form>				
	</div>
</div>	
</div>

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
$(document).ready(function(){
	
	/* 종합 정보 섹션 정보 삽입 */
	setTotalInfo();	
	
	/* data-productImgNum="${ci.imageList[0].productImgNum}" 
	data-productNum="${ci.imageList[0].productNum}" 
	data-path="${ci.imageList[0].uploadPath}" 
	data-imagename="${ci.imageList[0].imageName}" 
	data-originalName="${ci.imageList[0].originalName}" */
	
	
	/* 이미지 삽입 */
	$(".image_wrap").each(function(i, obj){
		
		data-productImgNum="${ci.imageList[0].productImgNum}"
		data-productNum="${ci.imageList[0].productNum}"
		data-imgName="${ci.imageList[0].imgName}"
		data-originalName="${ci.imageList[0].originalName}">
		
		const bobj = $(obj);
		
		if(bobj.data("productNum")){
			const uploadPath = bobj.data("path");
			const uuid = bobj.data("uuid");
			const imageName = bobj.data("imageName");
			
			const fileCallPath = encodeURIComponent(uploadPath + "/s_" + uuid + "_" + imageName);
			
			$(this).find("img").attr('src', '/display?imageName=' + fileCallPath);
		} else {
			$(this).find("img").attr('src', '/resources/images/iu2.jpg');
		}
		
	});
	
});	
/* 체크여부에따른 종합 정보 변화 */
$(".individual_cart_checkbox").on("change", function(){
	/* 총 주문 정보 세팅(배송비, 총 가격, 마일리지, 물품 수, 종류) */
	setTotalInfo();
});
/* 체크박스 전체 선택 */
$(".all_check_input").on("click", function(){
	/* 체크박스 체크/해제 */
	if($(".all_check_input").prop("checked")){
		$(".individual_cart_checkbox").prop("checked", true);
	} else{
		$(".individual_cart_checkbox").prop("checked", false);
	}
	
	/* 총 주문 정보 세팅(배송비, 총 가격, 마일리지, 물품 수, 종류) */
	setTotalInfo();	
	
});
/* 총 주문 정보 세팅(배송비, 총 가격, 마일리지, 물품 수, 종류) */
function setTotalInfo(){
	
	let totalPrice = 0;				// 총 가격
	let totalCount = 0;				// 총 갯수
	let totalKind = 0;				// 총 종류
	let orderFee = 0;				// 배송비
	let finalTotalPrice = 0; 		// 최종 가격(총 가격 + 배송비)
	
	$(".cart_info_td").each(function(index, element){
		
		if($(element).find(".individual_cart_checkbox").is(":checked") === true){	//체크여부
			// 총 가격
			totalPrice += parseInt($(element).find(".individual_totalPrice_input").val());
			// 총 갯수
			totalCount += parseInt($(element).find(".individual_orderStock_input").val());
			// 총 종류
			totalKind += 1;
		}
	});
	
	
	/* 배송비 결정 */
	if(totalPrice >= 30000){
		orderFee = 0;
	} else if(totalPrice == 0){
		orderFee = 0;
	} else {
		orderFee = 3000;	
	}
	
		finalTotalPrice = totalPrice + orderFee;
	
	/* ※ 세자리 컴마 Javscript Number 객체의 toLocaleString() */
	
	// 총 가격
	$(".totalPrice_span").text(totalPrice.toLocaleString());
	// 총 갯수
	$(".totalCount_span").text(totalCount);
	// 총 종류
	$(".totalKind_span").text(totalKind);
	// 배송비
	$(".orderFee_price").text(orderFee);	
	// 최종 가격(총 가격 + 배송비)
	$(".finalTotalPrice_span").text(finalTotalPrice.toLocaleString());		
}
/* 수량버튼 */
$(".plus_btn").on("click", function(){
	let quantity = $(this).parent("div").find("input").val();
	$(this).parent("div").find("input").val(++quantity);
});
$(".minus_btn").on("click", function(){
	let quantity = $(this).parent("div").find("input").val();
	if(quantity > 1){
		$(this).parent("div").find("input").val(--quantity);		
	}
});
/* 수량 수정 버튼 */
$(".quantity_modify_btn").on("click", function(){
	let cartNum = $(this).attr("data-cartNum");
	let orderStock = $(this).parent("td").find("input").val();
	$(".update_cartNum").val(cartNum);
	$(".update_orderStock").val(orderStock);
	$(".quantity_update_form").submit();
	
});
/* 장바구니 삭제 버튼 */
$(".delete_btn").on("click", function(e){
	e.preventDefault();
	const cartNum = $(this).attr("data-cartNum");
	$(".delete_cartNum").val(cartNum);
	$(".quantity_delete_form").submit();
});
	
/* 주문 페이지 이동*/	
$(".order_btn").on("click", function(){
	
	let form_contents ='';
	let orderNumber = 0;
	
	$(".cart_info_td").each(function(index, element){
		
		if($(element).find(".individual_cart_checkbox").is(":checked") === true){	//체크여부
			
			let productNum = $(element).find(".individual_productNum_input").val();
			let orderStock = $(element).find(".individual_orderStock_input").val();
			
			let productNum_input = "<input name='orders[" + orderNumber + "].productNum' type='hidden' value='" + productNum + "'>";
			form_contents += productNum_input;
			
			let orderStock_input = "<input name='orders[" + orderNumber + "].orderStock' type='hidden' value='" + orderStock + "'>";
			form_contents += orderStock_input;
			
			orderNumber += 1;
			
		}
	});	
	$(".order_form").html(form_contents);
	$(".order_form").submit();
	
});
		
</script>


</body>
</html>