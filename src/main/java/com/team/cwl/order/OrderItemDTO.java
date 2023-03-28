package com.team.cwl.order;

public class OrderItemDTO {
	
	// �ֹ� ��ȣ
	private Long orderNum;
	// ��ǰ ��ȣ
	private Long productNum;
	// �ֹ� ����
	private Long orderCount;
	// ��ǰ �� �� ����
	private Long productPrice;
	// �� ����(���� * �ֹ� ����)
	private Long totalPrice;
	
	
	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
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
