package com.team.cwl.order;

public class OrderItemDTO {
	
	// 주문 번호
	private String orderNum;
	// 제품 번호
	private Long productNum;
	// 주문 수량
	private Long orderCount;
	// 상품 한 개 가격
	private Long productPrice;
	// 총 가격(가격 * 주문 수량)
	private Long totalPrice;
	
	
	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Long getProductNum() {
		return productNum;
	}

	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}

	public Long getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Long orderCount) {
		this.orderCount = orderCount;
	}

	public Long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderItemDTO [orderNum=" + orderNum + ", productNum=" + productNum + ", orderCount=" + orderCount + ", productPrice="
				+ productPrice + ", totalPrice=" + totalPrice + "]";
	}
	
	public void initTotal() {
		this.totalPrice = this.productPrice * this.orderCount;
	}
	
	
}
