package com.team.cwl.order;

import java.util.List;


public interface OrderService {
	
	// �ֹ� ����
	public List<OrderPageItemDTO> getGoodsInfo(List<OrderPageItemDTO> orders); 
	
	// �ֹ�
	public void order(OrderDTO orw);
	
	// �ֹ����
	public void orderCancel(OrderCancelDTO dto);
}
