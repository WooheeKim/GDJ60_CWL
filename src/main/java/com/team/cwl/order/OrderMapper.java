package com.team.cwl.order;

import java.util.List;

import com.team.cwl.member.MemberDTO;

public interface OrderMapper {
	
	// �ֹ� ��ǰ ����(�ֹ� ������)
	public OrderPageItemDTO getGoodsInfo(Long productNum);
	
	// �ֹ� ��ǰ ����(�ֹ� ó��)
	public OrderItemDTO getOrderInfo(Long productNum);
	
	// �ֹ� ���̺� ���
	public int enrollOrder(OrderDTO orderDTO);
	
	// �ֹ� ������ ���̺� ���
	public int enrollOrderItem(OrderItemDTO orderItemDTO);
	
	// �ֹ� �ݾ� ����
	public int deductMoney(MemberDTO memberDTO);
	
	// �ֹ� ��� ����
	public int deductStock(ProductDTO productDTO);
	
	// �ֹ� ���
	public int orderCancel(String orderId);
	
	// �ֹ� ��ǰ ����(�ֹ����)
	public List<OrderItemDTO> getOrderItemInfo(String orderId);
	
	// �ֹ� ����(�ֹ����)
	public OrderDTO getOrder(String orderId);
	
}
