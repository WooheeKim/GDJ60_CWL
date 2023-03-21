package com.team.cwl.order;

import java.sql.Date;
import java.util.List;

public class OrderDTO {
	// �ֹ� ��ȣ
	private String orderNum;
	// ȸ�� ���̵�
	private String memberId;
	// ��� �޴���
	private String orderDonee;
	// �����
	private String orderAddress;
	// �ֹ���û����
	private String orderComment;
	// �ֹ� ��¥
	private Date orderDate;
	// ó������
	private String orderState;
	// �ֹ� ��ǰ
	private List<OrderItemDTO> orders;

	// ��ۺ�
	private Long orderFee;
	// �ǸŰ�(��� ��ǰ ���)
	private Long orderSalePrice;
	// ���� �Ǹ� ���(��ۺ� ����)
	private Long orderFinalSalePrice;
	
	
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getOrderDonee() {
		return orderDonee;
	}
	public void setOrderDonee(String orderDonee) {
		this.orderDonee = orderDonee;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	public String getOrderComment() {
		return orderComment;
	}
	public void setOrderComment(String orderComment) {
		this.orderComment = orderComment;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public List<OrderItemDTO> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderItemDTO> orders) {
		this.orders = orders;
	}
	public Long getOrderFee() {
		return orderFee;
	}
	public void setOrderFee(Long orderFee) {
		this.orderFee = orderFee;
	}
	public Long getOrderSalePrice() {
		return orderSalePrice;
	}
	public void setOrderSalePrice(Long orderSalePrice) {
		this.orderSalePrice = orderSalePrice;
	}
	public Long getOrderFinalSalePrice() {
		return orderFinalSalePrice;
	}
	public void setOrderFinalSalePrice(Long orderFinalSalePrice) {
		this.orderFinalSalePrice = orderFinalSalePrice;
	}
	
	@Override
	public String toString() {
		return "OrderDTO [orderNum=" + orderNum + ", memberId=" + memberId + ", orderDonne=" + orderDonee + ", orderAddress=" 
				+ orderAddress + ", orderComment=" + orderComment + ", orderDate=" + orderDate 
				+ ", orderState="+ orderState + ", orderFee=" + orderFee 
				+ ", orderSalePrice=" + orderSalePrice + ", orderFinalSalePrice=" + orderFinalSalePrice + "]";			
	}
	
	public void getOrderPriceInfo() {
		// ��ǰ ���
		for(OrderItemDTO order : orders) {
			orderSalePrice += order.getTotalPrice();
		}
		// ��� ���
		if(orderSalePrice >= 30000) {
			orderFee = 0L;
		} else {
			orderFee = 3000L;
		}
		// ���� �Ǹ� ���(��ǰ ��� + ��ۺ�)
		orderFinalSalePrice = orderSalePrice + orderFee;
	}
	
	
	
	
}
