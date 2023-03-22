package com.team.cwl.order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.cwl.cart.CartDTO;
import com.team.cwl.member.MemberDTO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired(required=false)
	private OrderMapper orderMapper;
	
//	@Autowired
//	private MemberMapper memberMapper;
//	
//	@Autowired
//	private CartMapper cartMapper;
//	
//	@Autowired
//	private ProductMapper productMapper;
	
	@Override
	public List<OrderPageItemDTO> getGoodsInfo(List<OrderPageItemDTO> orders) {
		
		List<OrderPageItemDTO> result = new ArrayList<OrderPageItemDTO>();
		
		for(OrderPageItemDTO ord : orders) {
			OrderPageItemDTO goodsInfo = orderMapper.getGoodsInfo(ord.getProductNum());
			goodsInfo.setOrderCount(ord.getOrderCount());
			
			goodsInfo.initTotal();
			
			result.add(goodsInfo);
		}
		return result;
	}
	
	@Override
	@Transactional
	public void order(OrderDTO ord) {
		// ����� ������ ��������
		// ȸ������
		MemberDTO member = memberMapper.getMemberInfo(ord.getMemberId());
		// �ֹ�����
//		List<OrderItemDTO> ords = new ArrayList<>();
		for(OrderItemDTO oit : ord.getOrders()) {
			OrderItemDTO orderItem = orderMapper.getOrderInfo(oit.getProductNum());
			// ���� ����
			orderItem.setOrderCount(oit.getOrderCount());
			// �⺻���� ����
			orderItem.initTotal();
			// List ��ü �߰�
			ords.add(orderItem);
		}
		// OrderDTO ����
		ord.setOrders(ords);
		ord.getOrderPriceInfo();
		
		// DB �ֹ�, �ֹ���ǰ(�������) �ֱ�
		// orderNum ����� �� OrderDTO��ü orderNum�� ����
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("_yyyyMMddmm");
		String orderId = member.getMemberId() + format.format(date);
		ord.setOrderNum(orderId);
		
		// DB�ֱ�
		orderMapper.enrollOrder(ord);
		for(OrderItemDTO oit : ord.getOrders()) {
			oit.setOrderNum(orderId);
			orderMapper.enrollOrderItem(oit);
		}
		
		// ��� ���� ����
		Long calMoney = member.getMemberMoney();
		calMoney -= ord.getOrderFinalSalePrice();
		member.setMemberMoney(calMoney);
		
		orderMapper.deductMoney(member);
		
		// ��� ���� ����
//		for(OrderItemDTO oit : ord.getOrders()) {
//			// ���� ��� �� ���ϱ�
//			ProductDTO productDTO = ProductMapper.getGoodsInfo(oit.getProductNum());
//			productDTO.setProductStock(productDTO.getProductStock() - oit.getOrderCount());
//			// ���� �� DB ����
//			orderMapper.deductStock(productDTO);
//		}
		
		// ��ٱ��� ����
		for(OrderItemDTO oit : ord.getOrders()) {
			CartDTO cartDTO = new CartDTO();
			cartDTO.setMemberId(ord.getMemberId());
			cartDTO.setProductNum(oit.getProductNum());
			
			cartMapper.deleteOrderCart(cartDTO);			
		}
		
	}
	
	// �ֹ����
	@Override
	@Transactional
	public void orderCancel(OrderCancelDTO orderCancelDTO) {
		// �ֹ�, �ֹ���ǰ ��ü
		// ȸ��
		MemberDTO member = memberMapper.getMemberInfo(orderCancelDTO.getOrderNum());
		// �ֹ���ǰ
		List<OrderItemDTO> ords = orderMapper.getOrderItemInfo(orderCancelDTO.getOrderNum());
		for(OrderItemDTO ord : ords) {
			ord.initTotal();
		}
		// �ֹ�
		OrderDTO orw = orderMapper.getOrder(orderCancelDTO.getOrderNum());
		orw.setOrders(ords);
		
		orw.getOrderPriceInfo();
		
		// �ֹ���ǰ ��� DB
		orderMapper.orderCancel(orderCancelDTO.getOrderNum());
		// ��, ��� ��ȯ
		// ��
		Long calMoney = member.getMemberMoney();
		calMoney += orw.getOrderFinalSalePrice();
		member.setMemberMoney(calMoney);
		// DB ����
		orderMapper.deductMoney(member);
		// ���
		for(OrderItemDTO ord : orw.getOrders()) {
//			ProductDTO productDTO = productMapper.getGoodsInfo(ord.getProductNum());
//			productDTO.setProductStock(productDTO.getProductStock() + ord.getOrderCount());
//			orderMapper.deductStock(productDTO);
		}
		
	}
	
}
