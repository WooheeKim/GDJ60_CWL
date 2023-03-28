package com.team.cwl.order;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.team.cwl.member.MemberDTO;
import com.team.cwl.product.ProductDTO;

@MapperScan(basePackages = "OrderMapper")
public interface OrderMapper {
	
	// �ֹ� ��ǰ ����(�ֹ� ������)
	public OrderPageItemDTO getGoodsInfo(Long productNum);
	
	// �ֹ� ��ǰ ����(�ֹ� ó��)
	public OrderItemDTO getOrderInfo(Long productNum);
	
	// �ֹ� ���̺� ���
	public int enrollOrder(OrderDTO ord);
	
	// �ֹ� ������ ���̺� ���
	public int enrollOrderItem(OrderItemDTO orid);
	
	// �ֹ� �ݾ� ����
	public int deductMoney(MemberDTO member);
	
	// �ֹ� ��� ����
	public int deductStock(ProductDTO product);
	
	// �ֹ� ���
	public int orderCancel(String orderNum);
	
	// �ֹ� ��ǰ ����(�ֹ����)
	public List<OrderItemDTO> getOrderItemInfo(String orderId);
	
	// �ֹ� ����(�ֹ����)
	public OrderDTO getOrder(String orderNum);
	
}
